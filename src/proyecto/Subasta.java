package proyecto;

import java.util.LinkedList;

public class Subasta {

	private final Usuario propietario;
	private final String descrS;
	private boolean subastaAbierta;
	private LinkedList<Puja> pujasAceptadas;

	public Subasta(Usuario auctionOwner, String auctionDescription) {
		propietario = auctionOwner;
		descrS = auctionDescription;
		pujasAceptadas = new LinkedList<Puja>();
		subastaAbierta = true;
	}

	public String realizarPuja(Usuario bidder, int betQuantity) {

		boolean validarPuja = false;
		if (betQuantity == 0) {
			if (pujasAceptadas.isEmpty() == true) {
				betQuantity = 1;
			} else {
				betQuantity = pujasAceptadas.getFirst().getcantidadPuj() + 1;
			}
		}
		if (subastaAbierta == true) {
			if (bidder.getCreditoU() >= betQuantity) {
				if (bidder != propietario) {
					if (pujasAceptadas.isEmpty() == true) {
						validarPuja = true;
					} else if (betQuantity + 1 >= pujasAceptadas.getFirst().getcantidadPuj()) {
						validarPuja = true;
					}
				}
			}
		}
		if (validarPuja == true) {
			Puja p = new Puja(this, betQuantity, bidder);
			pujasAceptadas.addFirst(p);
			propietario.addPujasASubastasP(p, this);
			bidder.addPujasP(p);
			return "Puja aceptada";
		} else {
			return "Puja rechazada";
		}
	}

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
				return "[Puja " + cont + "] [" + p.getPujador().getNombreU() + ", "
						+ p.getcantidadPuj() + "]";
			}
		}
		return "";
	}

	public void cerrarSubasta() {
		subastaAbierta = false;
	}

	public boolean consultarSubastaAbierta() {
		return subastaAbierta;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public String getdescrS() {
		return descrS;
	}

	public String ejecutarSubasta() {

		if (subastaAbierta == true) {
			return "Debe cerrar la subasta antes de ejecutarla";
		} else {
			pujasAceptadas.getFirst().getPujador()
					.setCreditoU(pujasAceptadas.getFirst().getPujador().getCreditoU()
							- pujasAceptadas.getFirst().getcantidadPuj());
			propietario.setCreditoU(
					getPropietario().getCreditoU() + pujasAceptadas.getFirst().getcantidadPuj());
			pujasAceptadas.getFirst().getPujador().addSubastasG(this);
			return "La subasta ha sido ejecutada";
		}
		
	}
			
		public String pujaMayor() {
			if (Subasta.this.getPujasAceptadas()==null) {
				return null;
			}
			else {
			return "[Puja mayor por " + Subasta.this.getdescrS()+"] "+Subasta.this.getPujasAceptadas().getFirst().getPujador().getNombreU()+", "+Subasta.this.getPujasAceptadas().getFirst().getcantidadPuj()+" €";
			}
		}
}
