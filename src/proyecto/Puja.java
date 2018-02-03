package proyecto;

public class Puja {

	/*
	 * 8.Una puja se caracteriza por la subasta a la que pertenece, la cantidad
	 * pujada y el usuario que ha realizado la puja. Estas propiedades no varían una
	 * vez que han sido establecidas.
	 */

	private final Subasta subastaEnCurso;
	private final int cantidadPujada;
	private final Usuario pujador;

	Puja(Subasta currentAuction, int betQuantity, Usuario bidder) {
		subastaEnCurso = currentAuction;
		cantidadPujada = betQuantity;
		pujador = bidder;
	}

	public Subasta getSubastaEnCurso() {
		return subastaEnCurso;
	}

	public int getCantidadPujada() {
		return cantidadPujada;
	}

	public Usuario getPujador() {
		return pujador;
	}

}
