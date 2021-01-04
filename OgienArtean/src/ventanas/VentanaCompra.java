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
	SpinnerModel model = new SpinnerNumberModel(0, 0, 25, 1);
	
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
	
	public ArrayList<Pasteleria> getAllPasteles() throws Exception{
		ArrayList<Pasteleria> pasteles = new ArrayList<Pasteleria>();
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT NOMBRE, PRECIO FROM PASTELERIA");
			while(rs.next()) {
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

	public ArrayList<Comida> getAllComidas() throws Exception{
		ArrayList<Comida> comidas = new ArrayList<Comida>();
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM COMIDA");
			while(rs.next()) {
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
	
	
	public ArrayList<Pan> getAllPanes() throws Exception{
		ArrayList<Pan> panes = new ArrayList<Pan>();
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
		try (Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("SELECT * FROM PAN");
			while(rs.next()) {
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
	
	public ArrayList<PanDisplay> getPanesDisplay() throws Exception{
		ArrayList<Pan> panes = getAllPanes();
		System.out.println(panes);
		ArrayList<PanDisplay> productosPan = new ArrayList();
		
		for (Pan pan : panes) {
			PanDisplay p = new PanDisplay(pan, boton = new JButton(),cantidad = new JSpinner(model), nombre = new JLabel());
			productosPan.add(p);
		}
		return productosPan;
	}
	
	public ArrayList<PasteleriaDisplay> getPasteleriaDisplay() throws Exception{
		ArrayList<Pasteleria> pasteles = getAllPasteles();
		System.out.println(pasteles);
		ArrayList<PasteleriaDisplay> productosPasteles = new ArrayList();
		
		for (Pasteleria pastel : pasteles) {
			PasteleriaDisplay q = new PasteleriaDisplay(pastel, boton = new JButton(),cantidad = new JSpinner(model), nombre = new JLabel());
		}
		return productosPasteles;
	}
	
	public ArrayList<ComidaDisplay> getComidaDisplay() throws Exception {
		ArrayList<Comida> comidas = getAllComidas();
		System.out.println(comidas);
		ArrayList<ComidaDisplay> productosComida = new ArrayList();
		for (Comida comida : comidas) {
			ComidaDisplay c = new ComidaDisplay(comida, boton = new JButton(), cantidad = new JSpinner(model), nombre = new JLabel());
			productosComida.add(c);
		}
		return productosComida;
	}
	
	public VentanaCompra(String s, Logger logger) throws Exception {
		
		

		carro = new JButton();
		carro.setIcon(new ImageIcon("imagenes/carro.png"));
		carro.setContentAreaFilled(false);
		carro.setBorderPainted(false);
		carro.setFocusPainted(false);
		carro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMiCarro(logger);
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
				new VentanaPerfil(logger);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton perfil.");
			}
		});

		comprar = new JButton();
		comprar.setIcon(new ImageIcon("imagenes/comprar.png"));
		comprar.setContentAreaFilled(false);
		comprar.setBorderPainted(false);
		comprar.setFocusPainted(false);
		comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				anyadido = new JOptionPane();
				anyadido.setFocusable(false);
				anyadido.showMessageDialog(null, "Su compra se ha a�adido al Carro");
				dispose();
				new VentanaClienteInicio(logger);
				logger.log(Level.INFO, "Ha funcionado el boton volver.");;
				logger.log(Level.INFO, "Ha funcionado el boton compro.");
			}
		});

		volver = new JButton();
		volver.setIcon(new ImageIcon("imagenes/volver.png"));
		volver.setContentAreaFilled(false);
		volver.setBorderPainted(false);
		volver.setFocusPainted(false);
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaClienteInicio(logger);
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
			ArrayList<PanDisplay> panes = getPanesDisplay();
			System.out.println(panes);
			int numeroPanel = 0;
			for (PanDisplay p : panes) {
				productoDisplay = new JPanel();
				p.getL().setText(p.getP().getNombre() + " " + p.getP().getPrecio() + " �");
				p.getL().setBackground(Color.WHITE);
				p.getL().setOpaque(true);
				productoDisplay.add(p.getL());
				p.getB().setText("COMPRAR");
				productoDisplay.add(p.getB());
				p.getS().setEnabled(false);
				productoDisplay.add(p.getS());
				productoDisplay.setOpaque(false);
				p.getB().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(p.getB().getText() == "COMPRAR") {
							p.getB().setText("RETIRAR");
							p.getS().setEnabled(true);
						} else {
							p.getB().setText("COMPRAR");
							p.getS().setEnabled(false);
							p.getS().setValue(0);
						}
					}
				});
				
					if(i == 4 || i == 9 || i == 14) {
						panelesCentro.get(numeroPanel).add(productoDisplay);
						numeroPanel ++;
						i++;
						System.out.println(i);
					} else if(i == panes.size()-1) {
						panelesCentro.get(numeroPanel).add(productoDisplay);
						if(0 <= i && i < 5) {
							 diferencia = 4-i;
						} else if(5 <= i && i < 10) {
							 diferencia = 9-i;
						} else if (10 <= i && i < 15){
							 diferencia = 14-i;
						} else {
							 diferencia = 19-i;
						}
						for (int j = 0; j < diferencia; j++) {
							JPanel vacio = new JPanel();
							vacio.setVisible(false);
							panelesCentro.get(numeroPanel).add(vacio);
						}
					}
					else {
						panelesCentro.get(numeroPanel).add(productoDisplay);
						i++;
					}
			}
			
		}
		else if (s == "pasteleria") {
			ArrayList<PasteleriaDisplay> pasteles = getPasteleriaDisplay();
			int numeroPanel = 0;
			for (PasteleriaDisplay q : pasteles) {
				productoDisplay = new JPanel();
				q.getL().setText(q.getQ().getNombre() + " " + q.getQ().getPrecio() + " �");
				productoDisplay.add(q.getL());
				q.getB().setText("COMPRAR");
				productoDisplay.add(q.getB());
				
				q.getS().setEnabled(false);
				productoDisplay.add(q.getS());
				q.getB().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(q.getB().getText() == "COMPRAR") {
							q.getB().setText("RETIRAR");
							q.getS().setEnabled(true);
						} else {
							q.getB().setText("COMPRAR");
							q.getS().setEnabled(false);
							q.getS().setValue(0);
						}
					}
				});
				
					if(i == 4 || i == 9 || i == 14) {
						panelesCentro.get(numeroPanel).add(productoDisplay);
						numeroPanel ++;
						i++;
						System.out.println(i);
					} else if(i == pasteles.size()-1) {
						panelesCentro.get(numeroPanel).add(productoDisplay);
						if(0 <= i && i < 5) {
							 diferencia = 4-i;
						} else if(5 <= i && i < 10) {
							 diferencia = 9-i;
						} else if (10 <= i && i < 15){
							 diferencia = 14-i;
						} else {
							 diferencia = 19-i;
						}
						for (int j = 0; j < diferencia; j++) {
							JButton vacioBoton = new JButton();
							vacioBoton.setVisible(false);
							vacioBoton.setEnabled(false);
							JPanel vacio = new JPanel();
							//vacio.add(vacioBoton);
							panelesCentro.get(numeroPanel).add(vacio);
						}
					}
					else {
						panelesCentro.get(numeroPanel).add(productoDisplay);
						i++;
					}
			}
		}
		else if (s == "comida") {
			ArrayList<ComidaDisplay> comidas = getComidaDisplay();
			int numeroPanel = 0;
			for (ComidaDisplay c : comidas) {
				productoDisplay = new JPanel();
				c.getL().setText(c.getC().getNombre() + " " + c.getC().getPrecio() + " �");
				productoDisplay.add(c.getL());
				c.getB().setText("COMPRAR");
				productoDisplay.add(c.getB());
				
				c.getS().setEnabled(false);
				productoDisplay.add(c.getS());
				c.getB().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(c.getB().getText() == "COMPRAR") {
							c.getB().setText("RETIRAR");
							c.getS().setEnabled(true);
						} else {
							c.getB().setText("COMPRAR");
							c.getS().setEnabled(false);
							c.getS().setValue(0);
						}
					}
				});
				
					if(i == 4 || i == 9 || i == 14) {
						panelesCentro.get(numeroPanel).add(productoDisplay);
						numeroPanel ++;
						i++;
						System.out.println(i);
					} else if(i == comidas.size()-1) {
						panelesCentro.get(numeroPanel).add(productoDisplay);
						if(0 <= i && i < 5) {
							 diferencia = 4-i;
						} else if(5 <= i && i < 10) {
							 diferencia = 9-i;
						} else if (10 <= i && i < 15){
							 diferencia = 14-i;
						} else {
							 diferencia = 19-i;
						}
						for (int j = 0; j < diferencia; j++) {
							JPanel vacio = new JPanel();
							panelesCentro.get(numeroPanel).add(vacio);
						}
					}
					else {
						panelesCentro.get(numeroPanel).add(productoDisplay);
						i++;
					}
			}
			
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
