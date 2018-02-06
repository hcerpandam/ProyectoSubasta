package proyecto;

import java.util.ArrayList;
import java.util.HashMap;
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
				ArrayList<Subasta> subastasAbiertas = new ArrayList<Subasta>();

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
				subastasAbiertas.add(s1);
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
				subastasAbiertas.remove(s1);
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
		try {

					int aux, datosNum, loginNum = 0;
					String opcion, opcion2, datos, login;
					Usuario u;

					do {

						do {
							opcion = JOptionPane.showInputDialog(
									"¡Bienvenido!¿Que deseas hacer?\n0.Salir del programa\n1.Registrarme como usuario\n2.Crear una subasta(*)\n3.Hacer una puja en una subasta(*)\n4.Consultar las subastas abiertas\n5.Consultar mis subastas(*)\n6.Consultar mis pujas aceptadas(*)\n7.Consultar mis subastas ganadas(*)\n*Solo usuarios registrados");
							aux = Integer.parseInt(opcion);
						} while (aux < 0 || aux > 7);

						switch (aux) {
						case 1:
							try {
								datos = JOptionPane.showInputDialog("Introduce tu nombre y apellidos").toUpperCase();
								for (int i = 0; i < usuarios.size(); i++) {
									while (datos.equals(usuarios.get(i).getNombreU())) {
										datos = JOptionPane.showInputDialog("Nombre en uso. Introduzca otro nombre de usuario")
												.toUpperCase();
									}
								}

								datosNum = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu credito inicial"));

								u = new Usuario(datos, datosNum);
								JOptionPane.showMessageDialog(null, "¡Bienvenido a Amazon " + u.getNombreU()
										+ "!\nTu credito inicial es de " + u.getCreditoU() + " euros");
								usuarios.add(u);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Su credito debe ser expresarse en numeros enteros");
							}
							break;
						case 2:
							if (!subastasAbiertas.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Ya hay una subasta en curso");
							} else if (usuarios.size() == 0) {
								JOptionPane.showMessageDialog(null, "Debes estar registrado");
							} else {
								login = JOptionPane.showInputDialog("Introduce tu nombre y apellidos").toUpperCase();
								try {
									loginNum = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu credito actual"));
								} catch (Exception e) {
								}
								for (int i = 0; i < usuarios.size(); i++) {
									if (login.equalsIgnoreCase(usuarios.get(i).getNombreU())
											&& loginNum == usuarios.get(i).getCreditoU()) {
										datos = JOptionPane
												.showInputDialog("Introduce la descripcion del producto que deseas subastar")
												.toUpperCase();
										Subasta s = new Subasta(usuarios.get(i), datos);
										JOptionPane.showMessageDialog(null, "El usuario " + usuarios.get(i).getNombreU()
												+ " ha abierto una subasta: " + s.getdescrS());
										subastasAbiertas.add(s);
										usuarios.get(i).addPujasASubastasP(null, s);
										i = usuarios.size();
									} else if ((login.equalsIgnoreCase(usuarios.get(i).getNombreU()) == false
											|| loginNum != usuarios.get(i).getCreditoU()) && i == usuarios.size() - 1) {
										JOptionPane.showMessageDialog(null, "Debes estar registrado");
									}
								}
							}
							break;
						case 3:
							if (subastasAbiertas.isEmpty()) {
								JOptionPane.showMessageDialog(null, "No hay subastas abiertas");
							} else {
								login = JOptionPane.showInputDialog("Introduce tu nombre y apellidos").toUpperCase();
								try {
									loginNum = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu credito actual"));
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, "El crédito debe ser de tipo entero");
								}
								for (int i = 0; i < usuarios.size(); i++) {
									if (login.equalsIgnoreCase(usuarios.get(i).getNombreU())
											&& loginNum == usuarios.get(i).getCreditoU()) {

										opcion2 = JOptionPane.showInputDialog("Introduce la cantidad que deseas pujar");
										aux = Integer.parseInt(opcion2);

										if (aux > usuarios.get(i).getCreditoU()) {
											JOptionPane.showMessageDialog(null, "Puja rechazada");break;
										} else {
											JOptionPane.showMessageDialog(null,
													subastasAbiertas.get(0).realizarPuja(usuarios.get(i), aux));
										}
									} else {
										JOptionPane.showMessageDialog(null, "Puja rechazada");break;
									}
								}
							}

							break;
						case 4:
							if (subastasAbiertas.isEmpty()) {
								JOptionPane.showMessageDialog(null, "No hay subastas abiertas");
							} else {
								for (Subasta s : subastasAbiertas) {
									JOptionPane.showMessageDialog(null, s.getdescrS() + ", ");
								}
							}
							break;
						case 5:
							try {
								login = JOptionPane.showInputDialog("Introduce tu nombre y apellidos").toUpperCase();
								loginNum = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu credito actual"));
								for (int i = 0; i < usuarios.size(); i++) {
									if (login.equalsIgnoreCase(usuarios.get(i).getNombreU())
											&& loginNum == usuarios.get(i).getCreditoU()) {
										JOptionPane.showMessageDialog(null, usuarios.get(i).getPujasASubastasP());
									} else {
										i = usuarios.size();
										JOptionPane.showMessageDialog(null, "Debes estar registrado");
									}
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null,
										"Tu subasta no se registrara hasta que no se valide la primera puja");
							}
							break;
						case 6:
							login = JOptionPane.showInputDialog("Introduce tu nombre y apellidos").toUpperCase();
							loginNum = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu credito actual"));
							for (int i = 0; i < usuarios.size(); i++) {
								if (login.equalsIgnoreCase(usuarios.get(i).getNombreU())
										&& loginNum == usuarios.get(i).getCreditoU()) {
									JOptionPane.showMessageDialog(null, usuarios.get(i).getPujasP());
								} else {
									i = usuarios.size();
									JOptionPane.showMessageDialog(null, "Debes estar registrado");
								}
							}
							break;
						case 7:
							login = JOptionPane.showInputDialog("Introduce tu nombre y apellidos").toUpperCase();
							loginNum = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu credito actual"));
							for (int i = 0; i < usuarios.size(); i++) {
								if (login.equalsIgnoreCase(usuarios.get(i).getNombreU())
										&& loginNum == usuarios.get(i).getCreditoU()) {
									JOptionPane.showMessageDialog(null, usuarios.get(i).getSubastasG());
								} else {
									i = usuarios.size();
									JOptionPane.showMessageDialog(null, "Debes estar registrado");
								}
							}
							break;

						}
					} while (aux != 0);
				} catch (Exception x) {
					JOptionPane.showMessageDialog(null, "¡Esperamos que vuelvas pronto!");
				}
			}

		}
		
