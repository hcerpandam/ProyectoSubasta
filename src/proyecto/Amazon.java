package proyecto;

import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Amazon {

	public static void main(String[] args) {
		HashMap<String, Integer> creditoUsuarios = new HashMap<String, Integer>();
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		Usuario u1 = new Usuario("Juan", 100);
		// Cambiar esto para que no tenga que poner el número de usuario
		JOptionPane.showMessageDialog(null,
				"Bienvenido " + u1.getNombreUsuario() + ". Tu crédito es de " + u1.getCreditoUsuario() + "€");
		Usuario u2 = new Usuario("Pedro", 150);
		// Cambiar esto para que no tenga que poner el número de usuario
		JOptionPane.showMessageDialog(null,
				"Bienvenido " + u2.getNombreUsuario() + ". Tu crédito es de " + u2.getCreditoUsuario() + "€");
		Usuario u3 = new Usuario("Enrique", 300);
		// Cambiar esto para que no tenga que poner el número de usuario
		JOptionPane.showMessageDialog(null,
				"Bienvenido " + u3.getNombreUsuario() + ". Tu crédito es de " + u3.getCreditoUsuario() + "€");
		Subasta s1 = new Subasta(u1, "Teléfono Móvil");
		JOptionPane.showMessageDialog(null,
				"El usuario " + u1.getNombreUsuario() + " ha abierto una subasta: " + s1.getDescripcionSubasta());
		s1.realizarPuja(u2, 100);
		JOptionPane.showMessageDialog(null, u2.getNombreUsuario() + ", confirmada tu puja por importe de "
				+ s1.getPujasAceptadas().getFirst().getCantidadPujada() + "€");
		JOptionPane.showMessageDialog(null, s1.pujaMayor());
		s1.realizarPuja(u3, 50);
		JOptionPane.showMessageDialog(null, u3.getNombreUsuario() + ", denegada tu puja");
		JOptionPane.showMessageDialog(null, s1.pujaMayor());
		s1.cerrarSubasta();
		s1.realizarPuja(u3, 200);
		JOptionPane.showMessageDialog(null, s1.pujaMayor() + " Subasta abierta: " + s1.consultarSubastaAbierta());
		JOptionPane.showMessageDialog(null,
				u3.getNombreUsuario() + ", denegada tu puja. La subasta ha sido cerrada");
		JOptionPane.showMessageDialog(null, s1.ejecutarSubasta());
		creditoUsuarios.put(u1.getNombreUsuario(), u1.getCreditoUsuario());// MODIFICAR ESTO PARA OBTENER DATOS CON FOR
																			// EN ARRAY
		creditoUsuarios.put(u2.getNombreUsuario(), u2.getCreditoUsuario());
		creditoUsuarios.put(u3.getNombreUsuario(), u3.getCreditoUsuario());
		creditoUsuarios.forEach((k, v) -> JOptionPane.showMessageDialog(null, "Usuario " + k + ", Crédito " + v));
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		for (Usuario usuario : usuarios)
			JOptionPane.showMessageDialog(null,
					usuario.getNombreUsuario() + "\n" + usuario.getPujasAceptadasEnSubastasPropias() + "\n"
							+ usuario.getPujasPropias() + "\n" + usuario.getSubastasGanadas());

	}

}
