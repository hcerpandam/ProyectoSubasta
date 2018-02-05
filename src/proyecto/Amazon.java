package proyecto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Amazon {

	public static void main(String[] args) {

		/**
		 * Creamos un HashMap formado por una clave String (nombre de usuario) y un
		 * valor Integer (crédito del usuario) Creamos una LinkedList de tipo Usuario
		 */
		HashMap<String, Integer> creditoUs = new HashMap<String, Integer>();
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

		/**
		 * Creamos tres usuarios e imprimimos su nombre y crédito inicial
		 */
		Usuario u1 = new Usuario("JUAN", 100);
		JOptionPane.showMessageDialog(null,
				"Bienvenido " + u1.getNombreU() + ". Tu crédito es de " + u1.getCreditoU() + "€");

		Usuario u2 = new Usuario("PEDRO", 150);
		JOptionPane.showMessageDialog(null,
				"Bienvenido " + u2.getNombreU() + ". Tu crédito es de " + u2.getCreditoU() + "€");

		Usuario u3 = new Usuario("ENRIQUE", 300);
		JOptionPane.showMessageDialog(null,
				"Bienvenido " + u3.getNombreU() + ". Tu crédito es de " + u3.getCreditoU() + "€");
		/**
		 * El usuario Juan crea una subasta e informamos por pantalla
		 */
		Subasta s1 = new Subasta(u1, "TELÉFONO MÓVIL");
		JOptionPane.showMessageDialog(null,
				"El usuario " + u1.getNombreU() + " ha abierto una subasta: " + s1.getdescrS());
		/**
		 * El usuario Pedro realiza una puja y es aceptada. Informamos
		 */
		s1.realizarPuja(u2, 100);
		JOptionPane.showMessageDialog(null, u2.getNombreU() + ", confirmada tu puja por importe de "
				+ s1.getPujasAceptadas().getFirst().getcantidadPuj() + "€");
		/**
		 * Comprobamos la puja mayor hasta el momento.Informamos
		 */
		JOptionPane.showMessageDialog(null, s1.pujaMayor());
		/**
		 * El usuario Enrique realiza una puja y no es aceptada. Informamos
		 */
		s1.realizarPuja(u3, 50);
		JOptionPane.showMessageDialog(null, u3.getNombreU() + ", denegada tu puja");
		/**
		 * Comprobamos que la puja de Enrique no ha sido aceptada imprimiendo la puja
		 * mayor.Informamos
		 */
		JOptionPane.showMessageDialog(null, s1.pujaMayor());
		/**
		 * Cerramos la subasta
		 */
		s1.cerrarSubasta();
		/**
		 * El usuario Enrique realiza una puja y no es aceptada. Informamos de que la
		 * subasta no está abierta y de que la puja ha sido rechazada
		 */
		s1.realizarPuja(u3, 200);
		JOptionPane.showMessageDialog(null, s1.pujaMayor() + " Subasta abierta: " + s1.consultarSubastaAbierta());
		JOptionPane.showMessageDialog(null, u3.getNombreU() + ", denegada tu puja. La subasta ha sido cerrada");
		/**
		 * Ejecutamos la subasta.Informamos
		 */
		JOptionPane.showMessageDialog(null, s1.ejecutarSubasta());
		/**
		 * Añadimos al HashMap los creditos de los usuarios
		 */
		creditoUs.put(u1.getNombreU(), u1.getCreditoU());
		creditoUs.put(u2.getNombreU(), u2.getCreditoU());
		creditoUs.put(u3.getNombreU(), u3.getCreditoU());
		/**
		 * Informamos
		 */
		creditoUs.forEach((k, v) -> JOptionPane.showMessageDialog(null, "Usuario " + k + ", Crédito " + v));
		/**
		 * Añadimos a la LinkesList los tres usuarios
		 */
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		/**
		 * Informamos por consola del resumen de datos hasta el momento
		 */
		System.out.println("                                               RESUMEN                                 \n");
		for (Usuario usuario : usuarios) {
			System.out.print("[" + usuario.getNombreU() + "]" + usuario.getPujasASubastasP() + ";" + usuario.getPujasP()
					+ ";" + usuario.getSubastasG() + ".\n");
		}

		int aux, datosNum,loginNum;
		String opcion, datos, login;
		Usuario u = null;
		do {
			
			do {
				opcion = JOptionPane.showInputDialog(
						"¡Bienvenido!¿Qué deseas hacer?\n0.Salir del programa\n1.Registrarme como usuario\n2.Crear una subasta(*)\n3.Hacer una puja en una subasta(*)\n4.Consultar las subastas abiertas\n5.Consultar mis subastas(*)\n6.Consultar mis pujas aceptadas(*)\n7.Consultar mis subastas ganadas(*)\n*Solo usuarios registrados");
				aux = Integer.parseInt(opcion);
			} while (aux < 0 || aux > 7);
			
			switch (aux) {
			case 1:
				datos = JOptionPane.showInputDialog("Introduce tu nombre y apellidos").toUpperCase();
				datosNum = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu crédito inicial"));
				u = new Usuario(datos, datosNum);
				JOptionPane.showMessageDialog(null, "¡Bienvenido a Amazon " + u.getNombreU()
						+ "!\nTu crédito inicial es de " + u.getCreditoU() + " €");
				break;
			case 2:
				login=JOptionPane.showInputDialog("Introduce tu nombre y apellidos").toUpperCase();
				loginNum=Integer.parseInt(JOptionPane.showInputDialog("Introduce tu crédito actual"));
				for (HashMap.Entry<String, Integer> entry : creditoUs.entrySet()) {
					if(entry.getKey()==login && entry.getValue()==loginNum) {
						u(entry)=entry;
					}  
				}
				datos=JOptionPane.showInputDialog("Introduce la descripción del producto que deseas subastar").toUpperCase();
				Subasta s=new Subasta(u,datos);
				JOptionPane.showMessageDialog(null, "Subasta creada por "+u.getNombreU());

			}
		
		} while (aux != 0);

	}
}
