package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VentanaLoginEmpleado extends JFrame {

	private JTextField usuario;
	private JLabel labelUsuario = new JLabel("        Usuario: ");
	private JPanel panelUsuario;

	private JPanel panelContraseña;
	private JPasswordField contraseña;
	private JLabel labelContraseña = new JLabel("  Contraseña: ");

	private JButton aceptar;
	private JPanel panelBotonera;

	private JPanel panelDatos;

	private JPanel panelDecorativo;
	private JLabel labelDecorativo;

	private static String usuarioEscogido;
	private String usuarioGuardado;
	private String contraseñaGuardada;

	private static VentanaEmpleadoInicio vei;

	public VentanaLoginEmpleado(Logger logger) {

		setTitle("LOGIN");
		setSize(310, 260);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 1));
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);

		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));

		panelDecorativo = new JPanel();
		panelDecorativo.setLayout(new GridLayout(1, 1));
		panelDecorativo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		labelDecorativo = new JLabel(new ImageIcon("imagenes/octocat.png"));
		panelDecorativo.setBackground(Color.WHITE);
		panelDecorativo.add(labelDecorativo);
		add(panelDecorativo);

		panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(3, 1));
		panelDatos.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelDatos.setSize(new Dimension(100, 100));
		panelDatos.setBackground(new Color(149, 194, 197));
		panelDatos.setPreferredSize(new Dimension(280, 100));
		add(panelDatos);

		panelUsuario = new JPanel();
		usuario = new JTextField();
		usuario.setPreferredSize(new Dimension(100, 25));
		panelUsuario.add(labelUsuario);
		panelUsuario.add(usuario);
		panelUsuario.setBackground(new Color(149, 194, 197));
		panelDatos.add(panelUsuario);

		panelContraseña = new JPanel();
		contraseña = new JPasswordField();
		contraseña.setPreferredSize(new Dimension(100, 25));
		panelContraseña.add(labelContraseña);
		panelContraseña.add(contraseña);
		panelContraseña.setBackground(new Color(149, 194, 197));
		panelDatos.add(panelContraseña);

		panelBotonera = new JPanel();
		aceptar = new JButton("Iniciar Sesión");
		aceptar.setEnabled(false);

		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comprobar(logger)) {
					vei = new VentanaEmpleadoInicio(logger);
					dispose();
					logger.log(Level.INFO, "Se ha loggineado el empleado.");
				} else {
					JOptionPane op = new JOptionPane();
					op.showMessageDialog(null,
							"Su usuario o contraseña no coinciden. Si cree que se trata de un error contacte con el administrador.",
							"ERROR", JOptionPane.ERROR_MESSAGE);
							logger.log(Level.INFO, "Ha habido un problema.");
				}
			}
		});

		panelBotonera.add(aceptar);
		panelBotonera.setBackground(new Color(149, 194, 197));
		panelDatos.add(panelBotonera);

		usuario.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
				logger.log(Level.INFO, "El documento se ha cambiado correctamente.");
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
				logger.log(Level.INFO, "El documento se ha borrado correctamente.");
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
				logger.log(Level.INFO, "El documento se ha insertado correctamente.");
			}
		});

		contraseña.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
				logger.log(Level.INFO, "El documento se ha cambiado correctamente.");
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
				logger.log(Level.INFO, "El documento se ha borrado correctamente.");
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
				logger.log(Level.INFO, "El documento se ha insertado correctamente.");
			}
		});

		setVisible(true);
	}

	public void changed() {
		if (contraseña.getText().equals("") || contraseña.getText().contains(" ") || usuario.getText().equals("")
				|| usuario.getText().contains(" ")) {
			aceptar.setEnabled(false);
		} else {
			aceptar.setEnabled(true);
		}
	};

	public boolean comprobar(Logger logger) {

		try {
			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from EMPLEADO");

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

}
