package ventanas;

import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeParseException;

import javax.swing.*;

import org.junit.internal.runners.model.EachTestNotifier;

import componentes.PanDisplay;
import componentes.PasteleriaDisplay;
import componentes.ComidaDisplay;
import ogienartean.*;

public class VentanaCompra extends JFrame {

	private Connection conn = null;

	JButton carro;
	JButton perfil;

	JButton boton;
	JLabel nombre;
	JSpinner cantidad;

	JButton comprar;
	JButton volver;

	JPanel arriba;
	JPanel centro0;
	JPanel centro1;
	JPanel centro2;
	JPanel centro00;
	JPanel centro11;
	JPanel centro22;
	JPanel abajo;
	JPanel productoDisplay;

	JOptionPane anyadido;

	JButton a;

	public ArrayList<Pasteleria> getAllPasteles(Connection conn, Statement stmt) throws Exception {
		ArrayList<Pasteleria> pasteles = new ArrayList<Pasteleria>();
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM PASTELERIA;");
			while (rs.next()) {
				Pasteleria pastel = new Pasteleria();
				pastel.setNombre(rs.getString("NOMBRE"));
				pastel.setPrecio(rs.getDouble("PRECIO"));
				pastel.setCeliaco(rs.getBoolean("CELIACO"));
				pastel.setTipo(rs.getString("TIPO"));
				pasteles.add(pastel);
			}
			return pasteles;
		} catch (SQLException | DateTimeParseException e) {
			throw new Exception("Error obteniendo todas los pasteles", e);
		}
	}

	public ArrayList<Comida> getAllComidas(Connection conn, Statement stmt) throws Exception {
		ArrayList<Comida> comidas = new ArrayList<Comida>();
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM COMIDA;");
			while (rs.next()) {
				Comida comida = new Comida();
				comida.setNombre(rs.getString("NOMBRE"));
				comida.setPrecio(rs.getDouble("PRECIO"));
				comida.setCeliaco(rs.getBoolean("CELIACO"));
				comida.setTipo(rs.getString("TIPO"));
				comida.setCaliente(rs.getBoolean("CALIENTE"));
				comidas.add(comida);
			}
			return comidas;
		} catch (SQLException | DateTimeParseException e) {
			throw new Exception("Error obteniendo todas las comidas", e);
		}
	}

	public ArrayList<Pan> getAllPanes(Connection conn, Statement stmt) throws Exception {
		ArrayList<Pan> panes = new ArrayList<Pan>();
		Class.forName("org.sqlite.JDBC");
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM PAN;");
			while (rs.next()) {
				Pan pan = new Pan();
				pan.setNombre(rs.getString("NOMBRE"));
				pan.setPrecio(rs.getDouble("PRECIO"));
				pan.setCeliaco(rs.getBoolean("CELIACO"));
				ArrayList<String> ingredientes = new ArrayList<String>();
				String ingredientesLista = rs.getString("INGREDIENTES");
				ingredientes.add(ingredientesLista);
				pan.setIngredientes(ingredientes);
				pan.setSal(rs.getBoolean("SAL"));

				panes.add(pan);
			}
			return panes;
		} catch (SQLException | DateTimeParseException e) {
			throw new Exception("Error obteniendo todos los panes", e);
		}
	}

	public ArrayList<PanDisplay> getPanesDisplay(Connection conn, Statement stmt) throws Exception {
		ArrayList<Pan> panes = getAllPanes(conn, stmt);
		ArrayList<PanDisplay> productosPan = new ArrayList();

		for (Pan pan : panes) {
			PanDisplay p = new PanDisplay(pan, boton = new JButton(), cantidad = new JSpinner(), nombre = new JLabel());
			productosPan.add(p);
		}
		return productosPan;
	}

	public ArrayList<PasteleriaDisplay> getPasteleriaDisplay(Connection conn, Statement stmt) throws Exception {
		ArrayList<Pasteleria> pasteles = getAllPasteles(conn, stmt);
		ArrayList<PasteleriaDisplay> productosPasteles = new ArrayList();

		for (Pasteleria pastel : pasteles) {
			PasteleriaDisplay q = new PasteleriaDisplay(pastel, boton = new JButton(), cantidad = new JSpinner(),
					nombre = new JLabel());
		}
		return productosPasteles;
	}

	public ArrayList<ComidaDisplay> getComidaDisplay(Connection conn, Statement stmt) throws Exception {
		ArrayList<Comida> comidas = getAllComidas(conn, stmt);
		ArrayList<ComidaDisplay> productosComida = new ArrayList();
		for (Comida comida : comidas) {
			ComidaDisplay c = new ComidaDisplay(comida, boton = new JButton(), cantidad = new JSpinner(),
					nombre = new JLabel());
			productosComida.add(c);
		}
		return productosComida;
	}

	public VentanaCompra(String s, Logger logger, ArrayList<String> tickets, String dni, Connection conn,
			Statement stmt) throws Exception {

		carro = new JButton();
		carro.setIcon(new ImageIcon("imagenes/carro.png"));
		carro.setContentAreaFilled(false);
		carro.setBorderPainted(false);
		carro.setFocusPainted(false);
		carro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMiCarro(logger, tickets, dni, conn, stmt);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton carro.");
			}
		});

		perfil = new JButton();
		perfil.setIcon(new ImageIcon("imagenes/perfil.png"));
		perfil.setContentAreaFilled(false);
		perfil.setBorderPainted(false);
		perfil.setFocusPainted(false);
		perfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaPerfil(logger, conn, stmt);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton perfil.");
			}
		});

		comprar = new JButton();
		comprar.setIcon(new ImageIcon("imagenes/comprar.png"));
		comprar.setContentAreaFilled(false);
		comprar.setBorderPainted(false);
		comprar.setFocusPainted(false);

		volver = new JButton();
		volver.setIcon(new ImageIcon("imagenes/volver.png"));
		volver.setContentAreaFilled(false);
		volver.setBorderPainted(false);
		volver.setFocusPainted(false);
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaClienteInicio(logger, tickets, dni, conn, stmt);
				logger.log(Level.INFO, "Ha funcionado el boton volver.");
				dispose();
			}
		});

		arriba = new JPanel();
		arriba.setOpaque(false);
		centro0 = new JPanel();
		centro0.setLayout(new GridLayout(1, 5, 5, 0));
		centro0.setOpaque(false);
		centro1 = new JPanel();
		centro1.setLayout(new GridLayout(1, 5, 5, 0));
		centro1.setOpaque(false);
		centro2 = new JPanel();
		centro2.setLayout(new GridLayout(1, 5, 5, 0));
		centro2.setOpaque(false);

		centro00 = new JPanel();
		centro00.setLayout(new GridLayout(1, 6, 5, 0));
		centro00.setOpaque(false);
		centro11 = new JPanel();
		centro11.setLayout(new GridLayout(1, 6, 5, 0));
		centro11.setOpaque(false);
		centro22 = new JPanel();
		centro22.setLayout(new GridLayout(1, 6, 5, 0));
		centro22.setOpaque(false);
		abajo = new JPanel();
		abajo.setOpaque(false);

		arriba.add(carro);
		arriba.add(perfil);

		ArrayList<JPanel> panelesCentro = new ArrayList<>();
		panelesCentro.add(centro0);
		panelesCentro.add(centro1);
		panelesCentro.add(centro2);
		panelesCentro.add(centro00);
		panelesCentro.add(centro11);
		panelesCentro.add(centro22);

		int i = 0;
		int diferencia = 0;
		if (s == "pan") {
			ArrayList<PanDisplay> panes = getPanesDisplay(conn, stmt);
			int numeroPanel = 0;
			for (PanDisplay p : panes) {
				productoDisplay = new JPanel();
				p.getL().setText(p.getP().getNombre() + " " + p.getP().getPrecio() + " €");
				p.getL().setBackground(Color.WHITE);
				p.getL().setOpaque(true);
				productoDisplay.add(p.getL());
				p.getB().setText("COMPRAR");
				productoDisplay.add(p.getB());
				p.getS().setEnabled(false);
				SpinnerModel model = new SpinnerNumberModel(0, 0, 25, 1);
				p.getS().setModel(model);
				productoDisplay.add(p.getS());
				productoDisplay.setOpaque(false);
				p.getB().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (p.getB().getText() == "COMPRAR") {
							p.getB().setText("RETIRAR");
							p.getS().setEnabled(true);
							logger.log(Level.INFO, "Ha funcionado el boton comprar.");
						} else {
							p.getB().setText("COMPRAR");
							p.getS().setEnabled(false);
							p.getS().setValue(0);
							logger.log(Level.INFO, "Ha funcionado el boton retirar.");
						}
					}
				});

				if (i == 4 || i == 9 || i == 14) {
					panelesCentro.get(numeroPanel).add(productoDisplay);
					numeroPanel++;
					i++;
				} else if (i == panes.size() - 1) {
					panelesCentro.get(numeroPanel).add(productoDisplay);
					if (0 <= i && i < 5) {
						diferencia = 4 - i;
					} else if (5 <= i && i < 10) {
						diferencia = 9 - i;
					} else if (10 <= i && i < 15) {
						diferencia = 14 - i;
					} else {
						diferencia = 19 - i;
					}
					for (int j = 0; j < diferencia; j++) {
						JPanel vacio = new JPanel();
						vacio.setVisible(false);
						panelesCentro.get(numeroPanel).add(vacio);
					}
				} else {
					panelesCentro.get(numeroPanel).add(productoDisplay);
					i++;
				}

			}
			comprar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					for (PanDisplay pan : panes) {
						int comprado = (int) pan.getS().getValue();
						if (comprado > 0) {
							String ticket = "Nombre: "+ pan.getP().getNombre() + " Unidades: " + pan.getS().getValue() 
									+ " Precio: " + pan.getP().getPrecio() * (int) pan.getS().getValue() + " ";
							tickets.add(ticket);
						}
					}

					anyadido = new JOptionPane();
					anyadido.setFocusable(false);
					anyadido.showMessageDialog(null, "Su compra se ha añadido al Carro");
					dispose();
					new VentanaClienteInicio(logger, tickets, dni, conn, stmt);
					logger.log(Level.INFO, "Ha funcionado el boton volver.");
					;
					logger.log(Level.INFO, "Ha funcionado el boton compro.");
				}
			});

		} else if (s == "pasteleria") {
			ArrayList<PasteleriaDisplay> pasteles = getPasteleriaDisplay(conn, stmt);
			int numeroPanel = 0;
			for (PasteleriaDisplay q : pasteles) {
				productoDisplay = new JPanel();
				q.getL().setText(q.getQ().getNombre() + " " + q.getQ().getPrecio() + " €");
				productoDisplay.add(q.getL());
				q.getB().setText("COMPRAR");
				productoDisplay.add(q.getB());
				SpinnerModel model = new SpinnerNumberModel(0, 0, 25, 1);
				q.getS().setModel(model);
				q.getS().setEnabled(false);
				productoDisplay.add(q.getS());
				productoDisplay.setOpaque(false);
				q.getL().setOpaque(true);
				q.getB().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (q.getB().getText() == "COMPRAR") {
							q.getB().setText("RETIRAR");
							q.getS().setEnabled(true);
							logger.log(Level.INFO, "Ha funcionado el boton comprar.");
						} else {
							q.getB().setText("COMPRAR");
							q.getS().setEnabled(false);
							q.getS().setValue(0);
							logger.log(Level.INFO, "Ha funcionado el boton retirar.");
						}
					}
				});

				if (i == 4 || i == 9 || i == 14) {
					panelesCentro.get(numeroPanel).add(productoDisplay);
					numeroPanel++;
					i++;
				} else if (i == pasteles.size() - 1) {
					panelesCentro.get(numeroPanel).add(productoDisplay);
					if (0 <= i && i < 5) {
						diferencia = 4 - i;
					} else if (5 <= i && i < 10) {
						diferencia = 9 - i;
					} else if (10 <= i && i < 15) {
						diferencia = 14 - i;
					} else {
						diferencia = 19 - i;
					}
					for (int j = 0; j < diferencia; j++) {
						JPanel vacio = new JPanel();
						vacio.setVisible(false);
						// vacio.add(vacioBoton);
						panelesCentro.get(numeroPanel).add(vacio);
					}
				} else {
					panelesCentro.get(numeroPanel).add(productoDisplay);
					i++;
				}
			}
			comprar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					for (PasteleriaDisplay pastel : pasteles) {
						int comprado = (int) pastel.getS().getValue();
						if (comprado > 0) {
							String ticket = "Nombre: " + pastel.getQ().getNombre() + " Unidades: " + pastel.getS().getValue() 
									+ " Precio: " + pastel.getQ().getPrecio() * (int) pastel.getS().getValue() + " ";
							tickets.add(ticket);
						}
					}

					anyadido = new JOptionPane();
					anyadido.setFocusable(false);
					anyadido.showMessageDialog(null, "Su compra se ha añadido al Carro");
					dispose();
					new VentanaClienteInicio(logger, tickets, dni, conn, stmt);
					logger.log(Level.INFO, "Ha funcionado el boton volver.");
					;
					logger.log(Level.INFO, "Ha funcionado el boton compro.");
				}
			});
		} else if (s == "comida") {
			ArrayList<ComidaDisplay> comidas = getComidaDisplay(conn, stmt);
			int numeroPanel = 0;
			for (ComidaDisplay c : comidas) {
				productoDisplay = new JPanel();
				c.getL().setText(c.getC().getNombre() + " " + c.getC().getPrecio() + " €");
				productoDisplay.add(c.getL());
				c.getB().setText("COMPRAR");
				productoDisplay.add(c.getB());
				SpinnerModel model = new SpinnerNumberModel(0, 0, 25, 1);
				c.getS().setModel(model);
				c.getS().setEnabled(false);
				productoDisplay.add(c.getS());
				productoDisplay.setOpaque(false);
				c.getL().setOpaque(true);
				c.getB().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (c.getB().getText() == "COMPRAR") {
							c.getB().setText("RETIRAR");
							c.getS().setEnabled(true);
							logger.log(Level.INFO, "Ha funcionado el boton comprar.");
						} else {
							c.getB().setText("COMPRAR");
							c.getS().setEnabled(false);
							c.getS().setValue(0);
							logger.log(Level.INFO, "Ha funcionado el boton retirar.");
						}
					}
				});

				if (i == 4 || i == 9 || i == 14) {
					panelesCentro.get(numeroPanel).add(productoDisplay);
					numeroPanel++;
					i++;
				} else if (i == comidas.size() - 1) {
					panelesCentro.get(numeroPanel).add(productoDisplay);
					if (0 <= i && i < 5) {
						diferencia = 4 - i;
					} else if (5 <= i && i < 10) {
						diferencia = 9 - i;
					} else if (10 <= i && i < 15) {
						diferencia = 14 - i;
					} else {
						diferencia = 19 - i;
					}
					for (int j = 0; j < diferencia; j++) {
						JPanel vacio = new JPanel();
						vacio.setVisible(false);
						panelesCentro.get(numeroPanel).add(vacio);
					}
				} else {
					panelesCentro.get(numeroPanel).add(productoDisplay);
					i++;
				}
			}
			comprar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					for (ComidaDisplay comida : comidas) {
						int comprado = (int) comida.getS().getValue();
						if (comprado > 0) {
							String ticket = "Nombre: " + comida.getC().getNombre() + " Unidades: " + comida.getS().getValue()
									+ " Precio: " + comida.getC().getPrecio() * (int) comida.getS().getValue() + " ";
							tickets.add(ticket);
						}
					}

					anyadido = new JOptionPane();
					anyadido.setFocusable(false);
					anyadido.showMessageDialog(null, "Su compra se ha añadido al Carro");
					dispose();
					new VentanaClienteInicio(logger, tickets, dni, conn, stmt);
					logger.log(Level.INFO, "Ha funcionado el boton volver.");
					;
					logger.log(Level.INFO, "Ha funcionado el boton compro.");
				}
			});

		}
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));

		abajo.add(volver);
		abajo.add(comprar);

		add(arriba);
		add(centro0);
		add(centro1);
		add(centro2);
		add(centro00);
		add(centro11);
		add(centro22);
		add(abajo);

		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("COMPRA");
		setSize(1000, 600);
		setLayout(new GridLayout(8, 1));
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

	}

}
