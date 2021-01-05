package ventanas;

import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;

import java.awt.event.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.ConnectionPoolDataSource;
import javax.swing.*;

import org.apache.commons.dbutils.DbUtils;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

import ogienartean.Comida;
import ogienartean.Pan;
import ogienartean.Pasteleria;
import ogienartean.Producto;

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
	JButton cBoton;
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
	JButton bBoton;
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
	JButton pBoton;
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

	JButton nombrehilo;

	private static LinkedList<String> lista = new LinkedList<>();

	private static LinkedList<Pasteleria> pastelerias = new LinkedList<>();
	private static LinkedList<Pan> panes = new LinkedList<>();
	private static LinkedList<Comida> comidas = new LinkedList<>();

	private boolean haCambiadoDePagina = false;

	private HashMap<Integer, JPanel> hashPaginas = new HashMap<>();

	public VentanaEmpleadoAdministrar(Logger logger) {

		try {
			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");

			Statement stmt = (Statement) conn.createStatement();

			String instruccion = "SELECT * FROM PAN";

			ResultSet rs = stmt.executeQuery(instruccion);

			while (rs.next()) {

				String nombreGuardado = rs.getString("NOMBRE");
				Double precioGuardado = rs.getDouble("PRECIO");
				boolean celiacoGuardado = rs.getBoolean("CELIACO");
				String ingredientesGuardados = rs.getString("INGREDIENTES");

				String[] ingredientesMuyGuardados;
				String stringTocho = "";
				for (Character letra : ingredientesGuardados.toCharArray()) {
					if (letra.equals('[') || letra.equals(']')) {
						continue;
					} else {
						stringTocho = stringTocho + letra;
					}
				}
				ingredientesMuyGuardados = stringTocho.split(",");

				ArrayList<String> ingredientesDemasiadoGuardados = new ArrayList<String>();
				for (int i = 0; i < ingredientesMuyGuardados.length; i++) {
					ingredientesDemasiadoGuardados.add(ingredientesMuyGuardados[i]);
				}

				boolean salGuardada = rs.getBoolean("SAL");
				Pan p = new Pan(nombreGuardado, precioGuardado, celiacoGuardado, ingredientesDemasiadoGuardados,
						salGuardada);

				panes.add(p);
			}

			rs.close();

			String instruccion2 = "SELECT * FROM PASTELERIA";

			ResultSet rs2 = stmt.executeQuery(instruccion2);

			while (rs2.next()) {

				String nombreGuardado = rs.getString("NOMBRE");
				Double precioGuardado = rs.getDouble("PRECIO");
				boolean celiacoGuardado = rs.getBoolean("CELIACO");
				String tipoGuardado = rs.getString("TIPO");

				Pasteleria p = new Pasteleria(nombreGuardado, precioGuardado, celiacoGuardado, tipoGuardado);

				pastelerias.add(p);
			}

			String instruccion3 = "SELECT * FROM COMIDA";

			ResultSet rs3 = stmt.executeQuery(instruccion3);

			while (rs3.next()) {

				String nombreGuardado = rs.getString("NOMBRE");
				Double precioGuardado = rs.getDouble("PRECIO");
				boolean celiacoGuardado = rs.getBoolean("CELIACO");
				String tipoGuardado = rs.getString("TIPO");
				boolean calienteGuardado = rs.getBoolean("CALIENTE");

				Comida c = new Comida(nombreGuardado, precioGuardado, celiacoGuardado, tipoGuardado, calienteGuardado);

				comidas.add(c);
			}

			// stmt.close();
			// conn.close();

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
					cargarABaseDeDatos(conn, stmt);
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
			cBoton = new JButton();
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
					Comida c = new Comida(cNombre.getText(), Double.parseDouble(bPrecio.getValue() + ""),
							bCeliaco.isSelected(), (String) cTipo.getSelectedItem(), cCaliente.isSelected());
					comidas.add(c);
					prepararPanel(izquierda, true);
					haCambiadoDePagina = true;
					izquierda.repaint();
					izquierda.validate();
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
					Pan p = new Pan(bNombre.getText(), Double.parseDouble(bPrecio.getValue() + ""),
							bCeliaco.isSelected(), bLista, bSal.isSelected());
					panes.add(p);
					prepararPanel(izquierda, true);
					haCambiadoDePagina = true;
					izquierda.repaint();
					izquierda.validate();

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
			pBoton = new JButton();
			pTipo = new JComboBox<String>();
			pTipo.addItem("Tarta");
			pTipo.addItem("Pastel");
			pTipo.addItem("Galleta");
			pTipoLabel = new JLabel("TIPO: ");
			pAñadir = new JButton("AÑADIR");
			pAñadir.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Pasteleria p = new Pasteleria(pNombre.getText(), Double.parseDouble(pPrecio.getValue() + ""),
							pCeliaco.isSelected(), (String) pTipo.getSelectedItem());
					pastelerias.add(p);
					prepararPanel(izquierda, true);
					haCambiadoDePagina = true;
					izquierda.repaint();
					izquierda.validate();

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
						prepararPanel(izquierda, true);
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
						prepararPanel(izquierda, true);
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
						prepararPanel(izquierda, true);
						mover.gridx = 0;
						mover.gridy = 1;
						mover.weighty = 3;
						derecha.add(cPanel, mover);
						derecha.remove(bPanel);
						derecha.remove(pPanel);
						repaint();
						validate();
					}

					haCambiadoDePagina = true;
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
						prepararPanel(izquierda, true);
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
						prepararPanel(izquierda, true);
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
						prepararPanel(izquierda, true);
						mover.gridx = 0;
						mover.gridy = 1;
						mover.weighty = 3;
						derecha.add(cPanel, mover);
						derecha.remove(bPanel);
						derecha.remove(pPanel);
						repaint();
						validate();
					}

					haCambiadoDePagina = true;
				}

			});

			hilo = new Thread(new Runnable() {

				@Override
				public void run() {

					try {

						while (true) {

							izquierda.repaint();
							izquierda.validate();

							if (opcionLabel.getText().matches("COMIDA") && haCambiadoDePagina) {

								haCambiadoDePagina = false;

								crearPanelesComida();

							} else if (opcionLabel.getText().matches("PAN") && haCambiadoDePagina) {

								haCambiadoDePagina = false;

								crearPanelPanes();

							} else if (opcionLabel.getText().matches("PASTELERIA") && haCambiadoDePagina) {

								haCambiadoDePagina = false;

								crearPanelesPasteleria();
							}
						}

					} catch (Exception e) {

						e.printStackTrace();

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

		} catch (ClassNotFoundException e3) {
			e3.printStackTrace();
		} catch (SQLException e3) {
			e3.printStackTrace();
		} finally {
			try {
				SQLiteConnectionPoolDataSource coso = new SQLiteConnectionPoolDataSource();
				coso.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void prepararPanel(JPanel panel, Boolean booleano) {
		if (booleano) {
			try {
				panel.remove(panel.getComponent(0));
				prepararPanel(panel, true);
				repaint();
				validate();
			} catch (Exception e) {
				prepararPanel(panel, false);
			}
		}
	}

	public void crearPanelPanes() {
		for (Pan pan : panes) {
			JPanel panel = new JPanel();
			JLabel label = new JLabel(pan.getNombre());
			JButton boton = new JButton("Eliminar");
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					panes.remove(pan);
					prepararPanel(izquierda, true);
					haCambiadoDePagina = true;

				}
			});

			panel.add(label);
			panel.add(boton);
			izquierda.add(panel);
		}
	}

	public void crearPanelesComida() {
		for (Comida comida : comidas) {
			JPanel panel = new JPanel();
			JLabel label = new JLabel(comida.getNombre());
			JButton boton = new JButton("Eliminar");
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					comidas.remove(comida);
					prepararPanel(izquierda, true);
					haCambiadoDePagina = true;

				}
			});

			panel.add(label);
			panel.add(boton);
			izquierda.add(panel);
			lista.add(label.getText());

		}
	}

	public void crearPanelesPasteleria() {
		for (Pasteleria pastel : pastelerias) {
			JPanel panel = new JPanel();
			JLabel label = new JLabel(pastel.getNombre());
			JButton boton = new JButton("Eliminar");
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					pastelerias.remove(pastel);
					prepararPanel(izquierda, true);
					haCambiadoDePagina = true;

				}
			});

			panel.add(label);
			panel.add(boton);
			izquierda.add(panel);
			lista.add(label.getText());

		}
	}

	public void cargarABaseDeDatos(Connection conn, Statement stmt) {
		try {
			ResultSet r2 = stmt.executeQuery("SELECT NOMBRE FROM PAN;");
			LinkedList<String> nombres = new LinkedList<>();
			while (r2.next()) {
				String nombre = r2.getString("NOMBRE");
				nombres.add(nombre);
			}

			for (String nombre : nombres) {
				String instruccion = "DELETE FROM PAN WHERE NOMBRE = '" + nombre + "';";
				int delete = stmt.executeUpdate(instruccion);
			}

			for (Pan b : panes) {
				String instruccion = "INSERT INTO PAN VALUES('" + b.getNombre() + "', " + b.getPrecio() + ", '"
						+ b.isCeliaco() + "', '" + b.getIngredientes() + "', '" + b.getSal() + "');";

				int r3 = stmt.executeUpdate(instruccion);
			}

			ResultSet r7 = stmt.executeQuery("SELECT NOMBRE FROM PASTELERIA;");
			LinkedList<String> nombres2 = new LinkedList<>();
			while (r7.next()) {
				String nombre = r7.getString("NOMBRE");
				nombres2.add(nombre);
			}

			for (String nombre : nombres2) {
				String instruccion = "DELETE FROM PASTELERIA WHERE NOMBRE = '" + nombre + "';";
				int delete = stmt.executeUpdate(instruccion);
			}

			for (Pasteleria p : pastelerias) {
				String instruccion = "INSERT INTO PASTELERIA VALUES('" + p.getNombre() + "', " + p.getPrecio() + ", '"
						+ p.isCeliaco() + "', '" + p.getTipo() + "');";

				int r5 = stmt.executeUpdate(instruccion);
			}

			ResultSet r6 = stmt.executeQuery("SELECT NOMBRE FROM COMIDA;");
			LinkedList<String> nombres3 = new LinkedList<>();
			while (r6.next()) {
				String nombre = r6.getString("NOMBRE");
				nombres3.add(nombre);
			}

			for (String nombre : nombres3) {
				String instruccion = "DELETE FROM COMIDA WHERE NOMBRE = '" + nombre + "';";
				int delete = stmt.executeUpdate(instruccion);
			}

			for (Comida c : comidas) {
				String instruccion = "INSERT INTO COMIDA VALUES(" + "'" + c.getNombre() + "', " + c.getPrecio() + ", '"
						+ c.isCeliaco() + "', '" + c.getTipo() + "', '" + c.isCaliente() + "');";

				int r8 = stmt.executeUpdate(instruccion);
			}

			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
