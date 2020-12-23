package ventanas;

import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;

import java.awt.event.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import ogienartean.Comida;
import ogienartean.Pan;
import ogienartean.Pasteleria;

public class VentanaEmpleadoAdministrar extends JFrame {

	JButton perfil;

	JPanel botones;

	JButton aceptar;

	JLabel eliminar;
	JLabel añadir;

	JTextField cNombre;
	JLabel cNombreLabel;
	JSpinner cPrecio;
	JLabel cPrecioLabel;
	JRadioButton cCeliaco;
	JLabel cCeliacoLabel;
	JRadioButton cCaliente;
	JLabel cCalienteLabel;
	JComboBox<String> cTipo;
	JLabel cTipoLabel;
	JButton cAñadir;
	JButton cBorrar;
	JPanel cPanel;

	JTextField bNombre;
	JLabel bNombreLabel;
	JSpinner bPrecio;
	JLabel bPrecioLabel;
	JRadioButton bCeliaco;
	JLabel bCeliacoLabel;
	JPanel bIngredientesPanel;
	JTextField bIngredientes;
	JLabel bIngredientesLabel;
	JButton bIngredientesButon;
	JRadioButton bSal;
	JLabel bSalLabel;
	JButton bAñadir;
	JButton bBorrar;
	JPanel bPanelArriba;
	JPanel bPanel;

	JTextField pNombre;
	JLabel pNombreLabel;
	JSpinner pPrecio;
	JLabel pPrecioLabel;
	JRadioButton pCeliaco;
	JLabel pCeliacoLabel;
	JComboBox<String> pTipo;
	JLabel pTipoLabel;
	JButton pAñadir;
	JButton pBorrar;
	JPanel pPanelArriba;
	JPanel pPanel;

	private int numero = 1;
	JButton izquierdaButton;
	JLabel opcionLabel;
	JButton derechaButton;
	JPanel derechaAbajoPanel;

	JPanel derecha;

	JPanel izquierda;

	JPanel completo;

	Thread hilo;

	private static LinkedList<String> lista = new LinkedList<>();
	private static LinkedList<String> listaBorrados = new LinkedList<>();

	public VentanaEmpleadoAdministrar(Logger logger) {

		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));

		perfil = new JButton();
		perfil.setContentAreaFilled(false);
		perfil.setBorderPainted(false);
		perfil.setFocusPainted(false);
		perfil.setIcon(new ImageIcon("imagenes/perfil.png"));
		perfil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VentanaPerfil a = new VentanaPerfil(logger);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton perfil.");
			}
		});

		cNombre = new JTextField();
		cNombreLabel = new JLabel("NOMBRE: ");
		cPrecio = new JSpinner(new SpinnerNumberModel(0, 0.00, 99.99, 0.01));
		cPrecioLabel = new JLabel("PRECIO: ");
		cCeliaco = new JRadioButton("Sí");
		cCeliacoLabel = new JLabel("CELIACO: ");
		cCaliente = new JRadioButton("Sí");
		cCalienteLabel = new JLabel("CALIENTE: ");
		cTipo = new JComboBox<String>();
		cTipo.addItem("Pizza");
		cTipo.addItem("Bocadillo");
		cTipo.addItem("Empanada");
		cTipoLabel = new JLabel("TIPO: ");
		cAñadir = new JButton("AÑADIR");
		cAñadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					Comida c = new Comida(cNombre.getText(), (double) cPrecio.getValue(), cCeliaco.isSelected(),
							(String) cTipo.getSelectedItem(), cCaliente.isSelected());

					Class.forName("org.sqlite.JDBC");
					Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
					Statement stmt = (Statement) conn.createStatement();

					String instruccion = "INSERT INTO COMIDA VALUES(" + "'" + c.getNombre() + "', " + c.getPrecio()
							+ ", '" + c.isCeliaco() + "', '" + c.getTipo() + "', '" + c.isCaliente() + "')";

					cNombre.setText(null);
					cPrecio.setValue(0);
					cCeliaco.setSelected(false);
					cCaliente.setSelected(false);

					stmt.executeUpdate(instruccion);
					stmt.close();
					conn.commit();
					conn.close();

				} catch (Exception e2) {

				}

			}
		});
		cBorrar = new JButton("BORRAR");
		cBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cNombre.setText(null);
				cPrecio.setValue(0);
				cCeliaco.setSelected(false);
				cCaliente.setSelected(false);
			}
		});
		cPanel = new JPanel();
		cPanel.setLayout(new GridLayout(6, 2));
		cPanel.add(cNombreLabel);
		cPanel.add(cNombre);
		cPanel.add(cPrecioLabel);
		cPanel.add(cPrecio);
		cPanel.add(cCeliacoLabel);
		cPanel.add(cCeliaco);
		cPanel.add(cCalienteLabel);
		cPanel.add(cCaliente);
		cPanel.add(cTipoLabel);
		cPanel.add(cTipo);
		cPanel.add(cBorrar);
		cPanel.add(cAñadir);

		bNombre = new JTextField();
		bNombreLabel = new JLabel("NOMBRE: ");
		bPrecio = new JSpinner(new SpinnerNumberModel(0, 0.00, 99.99, 0.01));
		bPrecioLabel = new JLabel("PRECIO: ");
		bCeliaco = new JRadioButton("Sí");
		bCeliacoLabel = new JLabel("CELIACO: ");
		bIngredientesPanel = new JPanel(new GridLayout(1, 2));
		bIngredientes = new JTextField();
		bIngredientesLabel = new JLabel("INGREDIENTES: ");
		bIngredientesButon = new JButton("AÑADIR");
		ArrayList<String> bLista = new ArrayList<String>();
		bIngredientesButon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bLista.add(bIngredientes.getText());
				bIngredientes.setText(null);
			}
		});
		bIngredientesPanel.add(bIngredientes);
		bIngredientesPanel.add(bIngredientesButon);
		bSal = new JRadioButton("Sí");
		bSalLabel = new JLabel("SAL: ");
		bAñadir = new JButton("AÑADIR");
		bAñadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					Pan b = new Pan(bNombre.getText(), (double) bPrecio.getValue(), bCeliaco.isSelected(), bLista,
							bSal.isSelected());

					Class.forName("org.sqlite.JDBC");

					Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
					Statement stmt = (Statement) conn.createStatement();

					String instruccion = "INSERT INTO PAN VALUES('" + b.getNombre() + "', " + b.getPrecio() + ", '"
							+ b.isCeliaco() + "', '" + b.getIngredientes() + "', '" + b.getSal() + "')";

					bNombre.setText(null);
					bPrecio.setValue(0);
					bCeliaco.setSelected(false);
					bSal.setSelected(false);
					bLista.removeAll(bLista);

					stmt.executeUpdate(instruccion);
					stmt.close();
					conn.commit();
					conn.close();

				} catch (Exception e2) {

				}

			}
		});
		bBorrar = new JButton("BORRAR");
		bBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				bNombre.setText(null);
				bPrecio.setValue(0);
				bCeliaco.setSelected(false);
				bSal.setSelected(false);
				bLista.removeAll(bLista);
			}
		});
		bPanel = new JPanel(new GridLayout(6, 2));
		bPanel.add(bNombreLabel);
		bPanel.add(bNombre);
		bPanel.add(bPrecioLabel);
		bPanel.add(bPrecio);
		bPanel.add(bCeliacoLabel);
		bPanel.add(bCeliaco);
		bPanel.add(bIngredientesLabel);
		bPanel.add(bIngredientesPanel);
		bPanel.add(bSalLabel);
		bPanel.add(bSal);
		bPanel.add(bBorrar);
		bPanel.add(bAñadir);

		pNombre = new JTextField();
		pNombreLabel = new JLabel("NOMBRE: ");
		pPrecio = new JSpinner(new SpinnerNumberModel(0, 0.00, 99.99, 0.01));
		pPrecioLabel = new JLabel("PRECIO: ");
		pCeliaco = new JRadioButton("Sí");
		pCeliacoLabel = new JLabel("CELIACO: ");
		pTipo = new JComboBox<String>();
		pTipo.addItem("Tarta");
		pTipo.addItem("Pastel");
		pTipo.addItem("Galleta");
		pTipoLabel = new JLabel("TIPO: ");
		pAñadir = new JButton("AÑADIR");
		pAñadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					Pasteleria p = new Pasteleria(pNombre.getText(), (double) pPrecio.getValue(), pCeliaco.isSelected(),
							(String) pTipo.getSelectedItem());

					Class.forName("org.sqlite.JDBC");

					Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
					Statement stmt = (Statement) conn.createStatement();

					String instruccion = "INSERT INTO PASTELERIA VALUES('" + p.getNombre() + "', " + p.getPrecio()
							+ ", '" + p.isCeliaco() + "', '" + p.getTipo() + "')";

					pNombre.setText(null);
					pPrecio.setValue(0);
					pCeliaco.setSelected(false);

					stmt.executeUpdate(instruccion);
					stmt.close();
					conn.commit();
					conn.close();

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		pBorrar = new JButton("BORRAR");
		pBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pNombre.setText(null);
				pPrecio.setValue(0);
				pCeliaco.setSelected(false);
			}
		});
		pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(5, 2));
		pPanel.add(pNombreLabel);
		pPanel.add(pNombre);
		pPanel.add(pPrecioLabel);
		pPanel.add(pPrecio);
		pPanel.add(pCeliacoLabel);
		pPanel.add(pCeliaco);
		pPanel.add(pTipoLabel);
		pPanel.add(pTipo);
		pPanel.add(pBorrar);
		pPanel.add(pAñadir);

		izquierdaButton = new JButton("<");
		opcionLabel = new JLabel("ELECCION");
		derechaButton = new JButton(">");

		derechaAbajoPanel = new JPanel();
		derechaAbajoPanel.add(izquierdaButton);
		derechaAbajoPanel.add(opcionLabel);
		derechaAbajoPanel.add(derechaButton);

		derecha = new JPanel(new GridBagLayout());

		GridBagConstraints mover = new GridBagConstraints();
		mover.weightx = 1;
		mover.weighty = 1;
		mover.fill = GridBagConstraints.HORIZONTAL;

		mover.gridx = 0;
		mover.gridy = 0;
		mover.weightx = 3;
		mover.weighty = 1;
		derecha.add(derechaAbajoPanel, mover);

		izquierda = new JPanel();

		completo = new JPanel(new GridLayout(1, 2));
		completo.add(izquierda);
		completo.add(derecha);

		izquierdaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (numero == 2 || numero == 1) {
					numero--;

				} else if (numero == 0) {
					numero = 2;
				}

				if (numero == 1) {
					opcionLabel.setText("PAN");
					bNombre.setText(null);
					bPrecio.setValue(0);
					bCeliaco.setSelected(false);
					bSal.setSelected(false);
					bLista.removeAll(bLista);
					mover.gridx = 0;
					mover.gridy = 1;
					mover.weighty = 3;
					derecha.add(bPanel, mover);
					derecha.remove(cPanel);
					derecha.remove(pPanel);
					repaint();
					validate();

				} else if (numero == 2) {
					opcionLabel.setText("PASTELERIA");
					mover.gridx = 0;
					mover.gridy = 1;
					mover.weighty = 3;
					mover.weightx = 4;
					derecha.add(pPanel, mover);
					derecha.remove(cPanel);
					derecha.remove(bPanel);
					repaint();
					validate();

				} else if (numero == 0) {
					opcionLabel.setText("COMIDA");
					mover.gridx = 0;
					mover.gridy = 1;
					mover.weighty = 3;
					derecha.add(cPanel, mover);
					derecha.remove(bPanel);
					derecha.remove(pPanel);
					repaint();
					validate();
				}

			}
		});

		derechaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (numero == 1 || numero == 0) {
					numero++;
				} else if (numero == 2) {
					numero = 0;
				}

				if (numero == 1) {
					opcionLabel.setText("PAN");
					bNombre.setText(null);
					bPrecio.setValue(0);
					bCeliaco.setSelected(false);
					bSal.setSelected(false);
					bLista.removeAll(bLista);
					mover.gridx = 0;
					mover.gridy = 1;
					mover.weighty = 3;
					derecha.add(bPanel, mover);
					derecha.remove(cPanel);
					derecha.remove(pPanel);
					repaint();
					validate();

				} else if (numero == 2) {
					opcionLabel.setText("PASTELERIA");
					mover.gridx = 0;
					mover.gridy = 1;
					mover.weighty = 3;
					derecha.add(pPanel, mover);
					derecha.remove(cPanel);
					derecha.remove(bPanel);
					repaint();
					validate();

				} else if (numero == 0) {
					opcionLabel.setText("COMIDA");
					mover.gridx = 0;
					mover.gridy = 1;
					mover.weighty = 3;
					derecha.add(cPanel, mover);
					derecha.remove(bPanel);
					derecha.remove(pPanel);
					repaint();
					validate();
				}

			}
		});

		hilo = new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					Class.forName("org.sqlite.JDBC");

					Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
					Statement stmt = (Statement) conn.createStatement();

					while (true) {

						if (opcionLabel.getText().matches("COMIDA")) {

							izquierda.removeAll();

							String instruccionComida = "SELECT NOMBRE FROM COMIDA";
							ResultSet rs = stmt.executeQuery(instruccionComida);

							while (rs.next()) {

								String nombreBD = rs.getString("NOMBRE");

								if (!lista.contains(nombreBD)) {
									lista.add(nombreBD);

									JPanel panel = new JPanel();
									JTextField nombre = new JTextField();
									nombre.setText(nombreBD);
									nombre.setEditable(false);
									JButton izqBorrar = new JButton("BORRAR");
									izqBorrar.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											try {

												String instruccionBorrar = "DELETE FROM COMIDA WHERE NOMBRE = '"
														+ nombreBD + "';";
												stmt.executeUpdate(instruccionBorrar);

												lista.remove(nombreBD);

											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}

										}
									});

									JButton izqEditar = new JButton("EDITAR");
									panel.add(nombre);
									panel.add(izqBorrar);
									panel.add(izqEditar);
									izquierda.add(panel);

								}

								repaint();
								validate();

							}

						} else if (opcionLabel.getText().matches("PAN")) {

							String instruccionPan = "SELECT NOMBRE FROM PAN";
							ResultSet rs = stmt.executeQuery(instruccionPan);

							while (rs.next()) {

								String nombreBD = rs.getString("NOMBRE");

								if (!lista.contains(nombreBD)) {

									lista.add(nombreBD);

									JPanel panel = new JPanel();
									JTextField nombre = new JTextField();
									nombre.setText(nombreBD);
									nombre.setEditable(false);
									JButton izqBorrar = new JButton("BORRAR");
									izqBorrar.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											try {

												String instruccionBorrar = "DELETE FROM PAN WHERE NOMBRE = '" + nombreBD
														+ "';";
												stmt.executeUpdate(instruccionBorrar);

												lista.remove(nombreBD);

											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}

										}
									});

									JButton izqEditar = new JButton("EDITAR");
									panel.add(nombre);
									panel.add(izqBorrar);
									panel.add(izqEditar);
									izquierda.add(panel);

								}

								repaint();
								validate();

							}

						} else if (opcionLabel.getText().matches("PASTELERIA")) {

							String instruccionPasteleria = "SELECT NOMBRE FROM PASTELERIA";
							ResultSet rs = stmt.executeQuery(instruccionPasteleria);

							while (rs.next()) {

								String nombreBD = rs.getString("NOMBRE");

								if (!lista.contains(nombreBD)) {

									lista.add(nombreBD);

									JPanel panel = new JPanel();
									JTextField nombre = new JTextField();
									nombre.setText(nombreBD);
									nombre.setEditable(false);
									JButton izqBorrar = new JButton("BORRAR");
									izqBorrar.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											try {

												String instruccionBorrar = "DELETE FROM PASTLERIA WHERE NOMBRE = '"
														+ nombreBD + "';";
												stmt.executeUpdate(instruccionBorrar);

												lista.remove(nombreBD);

											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}

										}
									});

									JButton izqEditar = new JButton("EDITAR");
									panel.add(nombre);
									panel.add(izqBorrar);
									panel.add(izqEditar);
									izquierda.add(panel);

								}

								repaint();
								validate();

							}

						}

					}

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});

		hilo.start();

		botones = new JPanel(new FlowLayout());
		botones.add(perfil);
		botones.setOpaque(false);

		add(botones);
		add(completo);

		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("ADMINISTRACION");
		setSize(700, 600);
		setLayout(new GridLayout(2, 1));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
