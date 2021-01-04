package ventanas;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.ArrayList;
import java.util.logging.Level;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VentanaLoginCliente extends JFrame {

	// Usuario
	private JTextField usuario;
	private JLabel labelUsuario = new JLabel("Usuario: ");
	private JPanel panelUsuario;

	// Contraseña
	private JPanel panelContraseña;
	private JPasswordField contraseña;
	private JLabel labelContraseña = new JLabel("Contraseña: ");

	// Boton aceptar
	private JButton aceptar;
	private JPanel panelBotones;

	// Panel datos
	private JPanel panelDatos;

	// Decoracion
	private JPanel panelDecorativo;
	private JLabel labelDecorativo;

	private static String usuarioEscogido;
	private String usuarioGuardado;
	private String contraseñaGuardada;

	private static VentanaClienteInicio vio;

	public VentanaLoginCliente(Logger logger) {
		// Imagen de icono
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));

		// Caracteristicas Ventana
		setTitle("LOGIN");
		setSize(310, 260);
		setLayout(new GridLayout(2, 1));
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);

		// Configuración panel de decoración
		panelDecorativo = new JPanel();
		panelDecorativo.setLayout(new GridLayout(1, 1));
		panelDecorativo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		labelDecorativo = new JLabel(new ImageIcon("imagenes/octocat.png"));
		panelDecorativo.setBackground(Color.WHITE);
		panelDecorativo.add(labelDecorativo);
		add(panelDecorativo);

		// Configuración del Panel de Datos
		panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(3, 1));
		panelDatos.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelDatos.setSize(new Dimension(100, 100));
		panelDatos.setBackground(new Color(149, 194, 197));
		panelDatos.setPreferredSize(new Dimension(280, 100));
		add(panelDatos);

		// Configuracion Panel Usuario
		panelUsuario = new JPanel();
		usuario = new JTextField();
		usuario.setPreferredSize(new Dimension(100, 25));
		panelUsuario.add(labelUsuario);
		panelUsuario.add(usuario);
		panelUsuario.setBackground(new Color(149, 194, 197));
		panelDatos.add(panelUsuario);

		// Configuracion Panel Contraseña
		panelContraseña = new JPanel();
		contraseña = new JPasswordField();
		contraseña.setPreferredSize(new Dimension(100, 25));
		panelContraseña.add(labelContraseña);
		panelContraseña.add(contraseña);
		panelContraseña.setBackground(new Color(149, 194, 197));
		panelDatos.add(panelContraseña);

		// Configuración Paneles Botones
		panelBotones = new JPanel();
		aceptar = new JButton("Iniciar Sesión");
		aceptar.setEnabled(false);

		panelBotones.add(aceptar);
		panelBotones.setBackground(new Color(149, 194, 197));
		panelDatos.add(panelBotones);

		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comprobar(logger)) {
					String dni = "";
					try {
						Class.forName("org.sqlite.JDBC");
						Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
						Statement stmt = conn.createStatement();
						System.out.println("SELECT DNI FROM CLIENTE WHERE USUARIO =" + usuario.getText() + ";");
						ResultSet rs = stmt.executeQuery("SELECT DNI FROM CLIENTE WHERE USUARIO = '" + usuario.getText() + "' ;");				
						dni = rs.getString("DNI");
						stmt.close();
						conn.close();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ArrayList<String> tickets = new ArrayList();
					vio = new VentanaClienteInicio(logger, tickets, dni);
					dispose();
					logger.log(Level.INFO, "Se ha loggeado el cliente.");
				} else {
					JOptionPane op = new JOptionPane();
					op.showMessageDialog(null,
							"Su usuario o contraseña no coinciden. Si cree que se trata de un error contacte con el administrador.",
							"ERROR", JOptionPane.ERROR_MESSAGE);

					logger.log(Level.INFO, "Ha habido un problema.");
				}
			}
		});

		usuario.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			public void insertUpdate(DocumentEvent e) {
				changed();

			}
		});

		contraseña.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
			}
		});

		setVisible(true);
	}

	public boolean comprobar(Logger logger) {

		try {
			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from CLIENTE");

			logger.log(Level.INFO, "Se ha cargado correctamente la base de datos.");

			while (rs.next()) {

				usuarioGuardado = rs.getString("USUARIO");
				contraseñaGuardada = rs.getString("CONTRASEÑA");

				if (usuarioGuardado.equals(usuario.getText()) && contraseñaGuardada.equals(contraseña.getText())) {
					usuarioEscogido = usuarioGuardado;
					logger.log(Level.INFO, "Ha comparado correctamente el usuario y la contraseña.");
					return true;

				}
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

			logger.log(Level.SEVERE, "Se ha producido un error.");
		} catch (SQLException e) {

			e.printStackTrace();
			logger.log(Level.SEVERE, "Se ha producido un error.");
		}
		return false;

	}

	public void changed() {
		if (contraseña.getText().equals("") || contraseña.getText().contains(" ") || usuario.getText().equals("")
				|| usuario.getText().contains(" ")) {
			aceptar.setEnabled(false);
		} else {
			aceptar.setEnabled(true);
		}
	};

}
