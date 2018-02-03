package proyecto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Usuario {

	// 2.El identificador de un usuario no puede cambiar, mientras que el crédito
	// puede ser incrementado y decrementado.

	private final String nombreUsuario;
	private int creditoUsuario;

	// 11.1.Los usuarios conocen las subastas de las que son propietarios y las
	// pujas
	// que han sido aceptadas.

	private HashMap<Puja, Subasta> pujasAceptadasEnSubastasPropias;

	/*
	 * 12.1.Un usuario permite consultar las subastas de las que es propietario y
	 * las pujas que ha realizado y han sido aceptadas.
	 */

	private LinkedList<Puja> pujasPropias;

	// 13.1.Los usuarios también conocen las subastas que han ganado.

	private LinkedList<Subasta> subastasGanadas;

	/*
	 * 1.Un usuario se caracteriza por una cadena que lo identifica y el crédito
	 * disponible para poder pujar en subastas.
	 */

	public Usuario(String nameU, int money) {
		nombreUsuario = nameU;
		creditoUsuario = money;
		pujasAceptadasEnSubastasPropias = new HashMap<Puja, Subasta>();
		pujasPropias = new LinkedList<Puja>();
		subastasGanadas = new LinkedList<Subasta>();
	}

	public int getCreditoUsuario() {
		return creditoUsuario;
	}

	public void setCreditoUsuario(int creditoUsuario) {
		this.creditoUsuario = creditoUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	// 11.2.BIS

	public void addPujasAceptadasEnSubastasPropias(Puja p, Subasta s) {
		pujasAceptadasEnSubastasPropias.put(p, s);
	}

	// 12.1.BIS

	public void addPujasPropias(Puja p) {
		pujasPropias.addFirst(p);
	}

	// 13.3.BIS

	public void addSubastasganadas(Subasta s) {
		subastasGanadas.addFirst(s);
	}

	// 11.1.BIS

	public String getPujasAceptadasEnSubastasPropias() {
		if(pujasAceptadasEnSubastasPropias.isEmpty()) {
			return "No has creado subastas";
		}
		for (HashMap.Entry<Puja, Subasta> entry : pujasAceptadasEnSubastasPropias.entrySet()) {
			return "Subasta creada ID. " + entry.getKey().getSubastaEnCurso()
					.getDescripcionSubasta()/*
											 * + ", " + entry.getValue().imprimirPujasAceptadas()
											 */;
		}
		return "";
	}

	// 12.1.BIS

	public String getPujasPropias() {
		if (pujasPropias.isEmpty()) {
			return "No has realizado pujas";
		} else {
			for (Puja puja : pujasPropias) {
				return "Puja realizada " + puja.getSubastaEnCurso().getDescripcionSubasta() + " Cantidad pujada "
						+ puja.getCantidadPujada();
			}
		}
		return "";
	}

	// 13.2.Esta información puede ser consultada.

	public String getSubastasGanadas() {
		Iterator<Subasta> Iterator = subastasGanadas.iterator();
		if (subastasGanadas.isEmpty()) {
			return "No has ganado subastas";
		} else {
			while (Iterator.hasNext()) {
				return "Subasta ganada ID. " + Iterator.next().getDescripcionSubasta();
			}
		}
		return "";
	}
}
