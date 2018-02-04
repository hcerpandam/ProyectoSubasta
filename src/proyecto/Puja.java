package proyecto;
/** 
 * @author Hector Cervera, Carlos Sanchez y Daniel Valencia
 * @version 1.0
 * La puja sera considerada cuando sea "aceptada" y es realizada por un usuario con una cantidad de dinero.
 * 
 */
public class Puja {
	/**
	 * Declaramos variables de tipo final
	 */
	private final Subasta subastaAct;
	private final int cantidadPuj;
	private final Usuario pujador;
	/**
	* El constructor se hace con la subasta sobre la que puja, el usuario que realiza la puja y la cantidad con la que desea pujar
	*/
	Puja(Subasta currentAuction, int betQuantity, Usuario bidder) {
		subastaAct = currentAuction;
		cantidadPuj = betQuantity;
		pujador = bidder;
	}
	/**
	 * @return La subasta sobre la que se puja
	 */
	public Subasta getsubastaAct() {
		return subastaAct;
	}
	/**
	 * @return La cantidad de credito del usuario que puja
	 */
	public int getcantidadPuj() {
		return cantidadPuj;
	}
	/**
	 * @return El usuario que puja
	 */
	public Usuario getPujador() {
		return pujador;
	}

}
