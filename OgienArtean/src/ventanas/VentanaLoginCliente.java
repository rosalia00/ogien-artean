package ventanas;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class VentanaLoginCliente extends JFrame {
	
	//Usuario
	private JTextField usuario;
	private JLabel labelUsuario = new JLabel("Usuario: ");
	private JPanel panelUsuario;
	
	//Contraseña
	private JPanel panelContraseña;
	private JPasswordField contraseña;
	private JLabel labelContraseña = new JLabel("Contraseña: ");
	
	//Boton aceptar
	private JButton aceptar;
	private JPanel panelBotones;
	
	//Panel datos
	private JPanel panelDatos;
	
	//Decoracion
	private JPanel panelDecorativo;
	private JLabel labelDecorativo;
	
	private static String usuarioEscogido;
	private String usuarioGuardado;
	private String contraseñaGuardada;
	
	private static VentanaClienteInicio vio;
	
	public VentanaLoginCliente() {
		//Imagen de icono
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		
		//Caracteristicas Ventana
		setTitle("Registro");
		setSize(310, 260);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);
		
		//Configuración panel de decoración
		panelDecorativo = new JPanel();
		panelDecorativo.setLayout(new GridLayout(1, 1));
		panelDecorativo.setBorder(BorderFactory.createEmptyBorder(10,0,20,0));
		labelDecorativo = new JLabel(new ImageIcon("imagenes/octocat.png"));
		panelDecorativo.setBackground(Color.WHITE);
		panelDecorativo.add(labelDecorativo);
		add(panelDecorativo);
		
		//Configuración del Panel de Datos
		panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(3, 1));
		panelDatos.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelDatos.setSize(new Dimension(100,100));
		panelDatos.setBackground(new Color(149, 194, 197));
		panelDatos.setPreferredSize(new Dimension(280,100));
		add(panelDatos);
		
		//Configuracion Panel Usuario
		panelUsuario = new JPanel();
		usuario = new JTextField();
		usuario.setPreferredSize(new Dimension(100,25));
		panelUsuario.add(labelUsuario);
		panelUsuario.add(usuario);
		panelUsuario.setBackground(new Color(149,194,197));
		panelDatos.add(panelUsuario);
		
		//Configuracion Panel Contraseña
		panelContraseña = new JPanel();
		contraseña = new JPasswordField();
		contraseña.setPreferredSize(new Dimension(100,25));
		panelContraseña.add(labelContraseña);
		panelContraseña.add(contraseña);
		panelContraseña.setBackground(new Color(149,194,197));
		panelDatos.add(panelContraseña);
		
		//Configuración Paneles Botones
		panelBotones = new JPanel();
		aceptar = new JButton("Iniciar Sesión");
		aceptar.setEnabled(false);
		
		panelBotones.add(aceptar);
		panelBotones.setBackground(new Color(149));
		panelDatos.add(panelBotones);
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comprobar()) {
					vio = new VentanaClienteInicio();
					dispose();
				} else {
					JOptionPane op = new JOptionPane();
					op.showMessageDialog(null,
							"Su usuario o contraseña no coinciden. Si cree que se trata de un error contacte con el administrador.",
							"ERROR", JOptionPane.ERROR_MESSAGE);
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
		
		public boolean comprobar() {

			try {
				Class.forName("org.sqlite.JDBC");

				Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from CLIENTE");

				while (rs.next()) {

					usuarioGuardado = rs.getString("USUARIO");
					contraseñaGuardada = rs.getString("CONTRASEÑA");

					if (usuarioGuardado.equals(usuario.getText()) && contraseñaGuardada.equals(contraseña.getText())) {
						usuarioEscogido = usuarioGuardado;
						return true;
					}
				}

			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
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
	

