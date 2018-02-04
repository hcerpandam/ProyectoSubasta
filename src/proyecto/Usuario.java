package proyecto;

/**
 * @author Hector Cervera, Carlos Sanchez y Daniel Valencia
 * @version 1.0
 * Representa al usuario del sistema de subastas. Estos usuarios pueden pujar
 * por productos que ofrecen otros usuarios y ser los creadores de una subasta de un producto.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;



public class Usuario {
	
	/**
	 * Declaramos variables y listas
	 */

	private final String nombreU;
	private int creditoU;
	private HashMap<Puja, Subasta> pujasASubastasP;
	private LinkedList<Puja> pujasP;
	private LinkedList<Subasta> subastasG;
	
	/**
	 * Este constructor nos permite crear un usuario con su nombre y su credito inicial
	 * El HashMap de las subastas creadas y las pujas aceptadas en ellas y las likedList de sus subastas creadas, sus pujas aceptadas y sus subastas ganadas se crean para poder rellenarse
	 */

	public Usuario(String nameU, int money) {
		nombreU = nameU;
		creditoU = money;
		pujasASubastasP = new HashMap<Puja, Subasta>();
		pujasP = new LinkedList<Puja>();
		subastasG = new LinkedList<Subasta>();
	}
	/**
	 * @return El credito del usuario
	 */
	public int getCreditoU() {
		return creditoU;
	}
	/**
	 * @param creditoU Modifica el crédito del usuario
	 */
	public void setCreditoU(int creditoU) {
		this.creditoU = creditoU;
	}
	/**
	 * @return El nombre del usuario
	 */	
	public String getNombreU() {
		return nombreU;
	}
	/**
	 * Añade una puja aceptada relacionada con una subasta creada por el usuario
	 */
	public void addPujasASubastasP(Puja p, Subasta s) {
		pujasASubastasP.put(p, s);
	}
	/**
	 * Añade una puja aceptada a la lista de pujas aceptadas del usuario
	 */
	public void addPujasP(Puja p) {
		pujasP.addFirst(p);
	}
	/**
	 * Añade una subasta ganada a la lista de subastas ganadas del usuario
	 */
	public void addSubastasG(Subasta s) {
		subastasG.addFirst(s);
	}
	/**
	 * @return Un listado de las subastas creadas por el usuario.Uso de HashMap.Entry
	 */
	public String getPujasASubastasP() {
		if (pujasASubastasP.isEmpty()) {
			return "No has creado subastas";
		} else {
			for (HashMap.Entry<Puja, Subasta> entry : pujasASubastasP.entrySet()) {
				return "Subasta creada de: " + entry.getKey().getsubastaAct().getdescrS();
			}
		}
		return "";
	}
	/**
	 * @return Un listado de las pujas aceptadas del usuario. Uso de for each
	 */
	public String getPujasP() {
		if (pujasP.isEmpty()) {
			return "no has realizado pujas";
		} else {
			for (Puja puja : pujasP) {
				return "puja realizada por " + puja.getsubastaAct().getdescrS() + " (cantidad pujada) "
						+ puja.getcantidadPuj();
			}
		}
		return "";
	}
	/**
	 * @return Un listado de las subastas ganadas por el usuario. Uso de Iterator
	 */
	public String getSubastasG() {
		Iterator<Subasta> Iterator = subastasG.iterator();
		if (subastasG.isEmpty()) {
			return "no has ganado subastas";
		} else {
			while (Iterator.hasNext()) {
				return "subasta ganada por " + Iterator.next().getdescrS();
			}
		}
		return "";
	}
}
