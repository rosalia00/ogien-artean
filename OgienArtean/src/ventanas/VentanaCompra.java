package ventanas;
import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.ArrayList;
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
				pastel.setNombre(rs.getString("nombre"));
				pastel.setPrecio(rs.getDouble(0));
				pastel.setCeliaco(rs.getBoolean(0));
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
			ResultSet rs = stmt.executeQuery("SELECT NOMBRE, PRECIO FROM COMIDA");
			while(rs.next()) {
				Comida comida = new Comida();
				comida.setNombre(rs.getString("nombre"));
				comida.setPrecio(rs.getDouble(0));
				comida.setCeliaco(rs.getBoolean(0));
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
			ResultSet rs = stmt.executeQuery("SELECT NOMBRE, PRECIO FROM PAN");
			while(rs.next()) {
				Pan pan = new Pan();
				pan.setNombre(rs.getString("nombre"));
				pan.setPrecio(rs.getDouble(0));
				pan.setCeliaco(rs.getBoolean(0));
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
			PanDisplay p = new PanDisplay(pan, boton = new JButton(),cantidad = new JSpinner(), nombre = new JLabel());
		}
		return productosPan;
	}
	
	public ArrayList<PasteleriaDisplay> getPasteleriaDisplay() throws Exception{
		ArrayList<Pasteleria> pasteles = getAllPasteles();
		System.out.println(pasteles);
		ArrayList<PasteleriaDisplay> productosPasteles = new ArrayList();
		
		for (Pasteleria pastel : pasteles) {
			PasteleriaDisplay q = new PasteleriaDisplay(pastel, boton = new JButton(),cantidad = new JSpinner(), nombre = new JLabel());
		}
		return productosPasteles;
	}
	
	public ArrayList<ComidaDisplay> getComidaDisplay() throws Exception {
		ArrayList<Comida> comidas = getAllComidas();
		System.out.println(comidas);
		ArrayList<ComidaDisplay> productosComida = new ArrayList();
		for (Comida comida : comidas) {
			ComidaDisplay c = new ComidaDisplay(comida, boton = new JButton(), cantidad = new JSpinner(), nombre = new JLabel());
			productosComida.add(c);
		}
		return productosComida;
	}
	
	public VentanaCompra(String s, Logger logger) throws Exception {
		
	//borrar arraylist
	//if (s == "pan") {
	//	getAllPanes();
//	} else if (s == "comida") {
		
	//} else if (s == "pasteleria") {
		
	//}

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
				anyadido.showMessageDialog(null, "Su compra se ha añadido al Carro");
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
		centro0.setLayout(new GridLayout(1, 6, 5, 0));
		centro0.setOpaque(false);
		centro1 = new JPanel();
		centro1.setLayout(new GridLayout(1, 6, 5, 0));
		centro1.setOpaque(false);
		centro2 = new JPanel();
		centro2.setLayout(new GridLayout(1, 6, 5, 0));
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
		
		int productosPorFila = 5;
		
		if (s == "pan") {
			ArrayList<PanDisplay> panes = getPanesDisplay();
			for (PanDisplay panDisplay : panes) {
				
			}
		}
		else if (s == "pasteleria") {
			ArrayList<PasteleriaDisplay> pasteles = getPasteleriaDisplay();
		}
		else if (s == "comida") {
			ArrayList<ComidaDisplay> comidas = getComidaDisplay();
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
