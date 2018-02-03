package proyecto;

import java.util.LinkedList;

public class Subasta {

	// 4.Estos valores son fijos en una subasta y no podr�n variar.

	private final Usuario propietario;
	private final String descripcionSubasta;

	// 7.1.Una subasta recuerda todas las pujas que han sido aceptadas.

	private LinkedList<Puja> pujasAceptadas;
	private boolean subastaAbierta;

	/*
	 * 3.Una subasta se caracteriza por el usuario que la crea (propietario) y por
	 * una cadena que describe el producto o servicio que est� subastando.
	 */

	public Subasta(Usuario auctionOwner, String auctionDescription) {
		propietario = auctionOwner;
		descripcionSubasta = auctionDescription;
		pujasAceptadas = new LinkedList<Puja>();
		subastaAbierta = true;
	}

	/*
	 * 5.Sobre una subasta se puede pujar.Esta operaci�n requiere conocer el usuario
	 * que est� realizando la puja y la cantidad por la que puja.
	 */

	public String realizarPuja(Usuario bidder, int betQuantity) {
		/*
		 * 8.Tambi�n se podr� pujar sin indicar la cantidad. Se asume que la cantidad
		 * ser� un euro mayor que la �ltima puja. Si no hubiera �ltima puja, la cantidad
		 * ser�a de un euro.
		 */
		boolean validarPuja = false;
		if (betQuantity == 0) {
			if (pujasAceptadas.isEmpty() == true) {
				betQuantity = 1;
			} else {
				betQuantity = pujasAceptadas.getFirst().getCantidadPujada() + 1;
			}
		}
		// 6.1.La puja es aceptada si:
		if (subastaAbierta == true) {// 9.2.El cierre de una subasta implica que no se van a aceptar nuevas pujas.
			if (bidder.getCreditoUsuario() >= betQuantity) {// a) el cr�dito del usuario que la realiza es suficiente
															// para la cantidad por la que puja;
				if (bidder != propietario) {// b) el usuario no es propietario de la subasta
					if (pujasAceptadas.isEmpty() == true) {// c) la cantidad es mayor que la cantidad de la puja mayor,
															// si la hubiera.
						validarPuja = true;
					} else if (betQuantity + 1 >= pujasAceptadas.getFirst().getCantidadPujada()) {
						validarPuja = true;
					}
				}
			}
		}
		if (validarPuja == true) {
			Puja p = new Puja(this, betQuantity, bidder);
			pujasAceptadas.addFirst(p);
			//11.2.La operaci�n que realiza la puja se encarga de establecer esta �ltima asociaci�n.
			propietario.addPujasAceptadasEnSubastasPropias(p, this);
			bidder.addPujasPropias(p);//12.1.BIS
			return "Puja aceptada";// 6.2.Por tanto, esta operaci�n finaliza indicando si la puja ha sido aceptada.
		} else {
			return "Puja rechazada";
		}
	}

	// 7.2.La lista de pujas aceptadas puede ser consultada.

	public LinkedList<Puja> getPujasAceptadas() {
		return pujasAceptadas;
	}

	public String imprimirPujasAceptadas() {
		int cont = 0;
		if (pujasAceptadas.isEmpty() == true) {
			return "No se han realizado pujas";
		} else {
			for (Puja p : pujasAceptadas) {
				cont++;
				return "[Puja " + cont + "] [" + p.getPujador().getNombreUsuario() + ", "
						+ p.getCantidadPujada() + "]";
			}
		}
		return "";
	}

	// 9.1.Una subasta se puede cerrar.

	public void cerrarSubasta() {
		subastaAbierta = false;
	}

	// 9.3.Es posible consultar si una puja est� cerrada.

	public boolean consultarSubastaAbierta() {
		return subastaAbierta;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public String getDescripcionSubasta() {
		return descripcionSubasta;
	}

	// 10.1.Una subasta cerrada puede ser ejecutada.Es posible consultar si una subasta ha sido ejecutada.

	public String ejecutarSubasta() {

		if (subastaAbierta == true) {
			return "Debe cerrar la subasta antes de ejecutarla";

		/*
		 * 10.2.La ejecuci�n de una subasta consiste en decrementar el cr�dito del usuario de
		 * la puja mayor e incrementar el cr�dito del propietario de la subasta por el
		 * importe de la puja ganadora.
		 */
		} else {
			pujasAceptadas.getFirst().getPujador()
					.setCreditoUsuario(pujasAceptadas.getFirst().getPujador().getCreditoUsuario()
							- pujasAceptadas.getFirst().getCantidadPujada());
			propietario.setCreditoUsuario(
					getPropietario().getCreditoUsuario() + pujasAceptadas.getFirst().getCantidadPujada());
			//13.3.El m�todo de ejecuci�n se encarga de establecer esta asociaci�n.
			pujasAceptadas.getFirst().getPujador().addSubastasganadas(this);
			return "La subasta ha sido ejecutada";
		}
		
	}
	
	//14.La puja mayor corresponde con la �ltima puja aceptada. Si no hay pujas, esta consulta devuelve un valor nulo.
		
		public String pujaMayor() {
			if (Subasta.this.getPujasAceptadas()==null) {
				return null;
			}
			else {
				return "[Puja mayor por "+Subasta.this.getDescripcionSubasta()+"] "+Subasta.this.getPujasAceptadas().getFirst().getPujador().getNombreUsuario()+", "+Subasta.this.getPujasAceptadas().getFirst().getCantidadPujada()+" �";
			}
		}
}
