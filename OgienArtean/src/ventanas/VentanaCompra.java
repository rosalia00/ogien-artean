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

import ogienartean.*;

public class VentanaCompra extends JFrame {

	private Connection conn = null; 
	
	JButton carro;
	JButton perfil;

	JButton item0;
	JLabel itemLabel0;
	JSpinner itemSpinner0;

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
	
	
	private ArrayList<Pasteleria> pasteles = new ArrayList<Pasteleria>();
	
	private ArrayList<Comida> comidas = new ArrayList<Comida>();
	
	private static Logger logger = Logger.getLogger(VentanaCompra.class.getName());
	
	public ArrayList<Pan> getAllPanes() throws Exception{
		ArrayList<Pan> panes = new ArrayList<Pan>();
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
			throw new Exception("Error obteniendo todos los usuarios'", e);
		}
	}
	
	public VentanaCompra(String s) {
		
	//borrar arraylist
	if (s == "pan") {
		getAllPanes();
	} else if (s == "comida") {
		
	} else if (s == "pasteleria") {
		
	}

		carro = new JButton();
		carro.setIcon(new ImageIcon("imagenes/carro.png"));
		carro.setContentAreaFilled(false);
		carro.setBorderPainted(false);
		carro.setFocusPainted(false);
		carro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMiCarro();
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
				new VentanaPerfil();
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
				new VentanaClienteInicio();
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
				new VentanaClienteInicio();
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

		for (int i = 1; i <= 5; i++) {
			item0 = new JButton("COSO");
			item0.setOpaque(false);
			item0.setContentAreaFilled(false);
			item0.setBorderPainted(false);
			item0.setFocusPainted(false);
			itemLabel0 = new JLabel("NOMBRE COSO");
			itemSpinner0 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

			centro0.add(item0);
			centro1.add(itemLabel0);
			centro2.add(itemSpinner0);
		}

		for (int i = 1; i <= 5; i++) {
			item0 = new JButton("COSO");
			item0.setOpaque(false);
			item0.setContentAreaFilled(false);
			item0.setBorderPainted(false);
			item0.setFocusPainted(false);
			itemLabel0 = new JLabel("NOMBRE COSO");
			itemSpinner0 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

			centro00.add(item0);
			centro11.add(itemLabel0);
			centro22.add(itemSpinner0);
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
