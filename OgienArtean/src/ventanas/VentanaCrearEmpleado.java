package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

import javax.swing.*;
import javax.swing.border.LineBorder;

import ogienartean.*;

public class VentanaCrearEmpleado extends JFrame {

	private JTextField nombreTexto;
	private JLabel nombreLabel;
	private JPanel nombrePanel;

	private JTextField apellidoTexto;
	private JLabel apellidoLabel;
	private JPanel apellidoPanel;

	private JTextField dniTexto;
	private JLabel dniLabel;
	private JPanel dniPanel;

	private JTextField direccionTexto;
	private JLabel direccionLabel;
	private JPanel direccionPanel;

	private JTextField telefonoTexto;
	private JLabel telefonoLabel;
	private JPanel telefonoPanel;

	private JTextField nominaTexto;
	private JLabel nominaLabel;
	private JPanel nominaPanel;

	private JTextField usuarioTexto;
	private JLabel usuarioLabel;
	private JPanel usuarioPanel;

	private JTextField contraseñaTexto;
	private JLabel contraseñaLabel;
	private JPanel contraseñaPanel;

	private JButton agregar;
	private JButton cancelar;
	private JPanel botones;

	private static Logger logger = Logger.getLogger(VentanaCrearEmpleado.class.getName());
	
	public VentanaCrearEmpleado() {
		nombreTexto = new JTextField();
		nombreTexto.setPreferredSize(new Dimension(250, 20));
		nombreTexto.setBorder(new LineBorder(new Color(115, 115, 115)));
		nombreLabel = new JLabel("NOMBRE: ");
		nombreLabel.setPreferredSize(new Dimension(100, 20));
		nombrePanel = new JPanel();
		nombrePanel.setBackground(Color.WHITE);

		apellidoTexto = new JTextField();
		apellidoTexto.setPreferredSize(new Dimension(250, 20));
		apellidoTexto.setBorder(new LineBorder(new Color(115, 115, 115)));
		apellidoLabel = new JLabel("APELLIDO: ");
		apellidoLabel.setPreferredSize(new Dimension(100, 20));
		apellidoPanel = new JPanel();
		apellidoPanel.setBackground(Color.WHITE);

		dniTexto = new JTextField();
		dniTexto.setPreferredSize(new Dimension(250, 20));
		dniTexto.setBorder(new LineBorder(new Color(115, 115, 115)));
		dniLabel = new JLabel("DNI: ");
		dniLabel.setPreferredSize(new Dimension(100, 20));
		dniPanel = new JPanel();
		dniPanel.setBackground(Color.WHITE);

		direccionTexto = new JTextField();
		direccionTexto.setPreferredSize(new Dimension(250, 20));
		direccionTexto.setBorder(new LineBorder(new Color(115, 115, 115)));
		direccionLabel = new JLabel("DIRECCION: ");
		direccionLabel.setPreferredSize(new Dimension(100, 20));
		direccionPanel = new JPanel();
		direccionPanel.setBackground(Color.WHITE);

		telefonoTexto = new JTextField();
		telefonoTexto.setPreferredSize(new Dimension(250, 20));
		telefonoTexto.setBorder(new LineBorder(new Color(115, 115, 115)));
		telefonoLabel = new JLabel("TELEFONO: ");
		telefonoLabel.setPreferredSize(new Dimension(100, 20));
		telefonoPanel = new JPanel();
		telefonoPanel.setBackground(Color.WHITE);

		nominaTexto = new JTextField();
		nominaTexto.setPreferredSize(new Dimension(250, 20));
		nominaTexto.setBorder(new LineBorder(new Color(115, 115, 115)));
		nominaLabel = new JLabel("NOMINA: ");
		nominaLabel.setPreferredSize(new Dimension(100, 20));
		nominaPanel = new JPanel();
		nominaPanel.setBackground(Color.WHITE);
		
		usuarioTexto = new JTextField();
		usuarioTexto.setPreferredSize(new Dimension(250, 20));
		usuarioTexto.setBorder(new LineBorder(new Color(115, 115, 115)));
		usuarioLabel = new JLabel("USUARIO: ");
		usuarioLabel.setPreferredSize(new Dimension(100, 20));
		usuarioPanel = new JPanel();
		usuarioPanel.setBackground(Color.WHITE);

		contraseñaTexto = new JTextField();
		contraseñaTexto.setPreferredSize(new Dimension(250, 20));
		contraseñaTexto.setBorder(new LineBorder(new Color(115, 115, 115)));
		contraseñaLabel = new JLabel("CONTRASEÑA: ");
		contraseñaLabel.setPreferredSize(new Dimension(100, 20));
		contraseñaPanel = new JPanel();
		contraseñaPanel.setBackground(Color.WHITE);

		agregar = new JButton("AGREGAR");
		agregar.setPreferredSize(new Dimension(100, 30));
		cancelar = new JButton("CANCELAR");
		cancelar.setPreferredSize(new Dimension(130, 30));
		botones = new JPanel();
		botones.setBackground(new Color(149, 194, 197));

		nombrePanel.add(nombreLabel);
		nombrePanel.add(nombreTexto);
		add(nombrePanel);
		apellidoPanel.add(apellidoLabel);
		apellidoPanel.add(apellidoTexto);
		add(apellidoPanel);
		dniPanel.add(dniLabel);
		dniPanel.add(dniTexto);
		add(dniPanel);
		direccionPanel.add(direccionLabel);
		direccionPanel.add(direccionTexto);
		add(direccionPanel);
		telefonoPanel.add(telefonoLabel);
		telefonoPanel.add(telefonoTexto);
		add(telefonoPanel);
		nominaPanel.add(nominaLabel);
		nominaPanel.add(nominaTexto);
		add(nominaPanel);
		usuarioPanel.add(usuarioLabel);
		usuarioPanel.add(usuarioTexto);
		add(usuarioPanel);
		contraseñaPanel.add(contraseñaLabel);
		contraseñaPanel.add(contraseñaTexto);
		add(contraseñaPanel);

		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton cancelar.");
			}
		});

		agregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Empleado empleado = new Empleado(nombreTexto.getText(), apellidoTexto.getText(),
							Integer.parseInt(dniTexto.getText()), direccionTexto.getText(),
							Integer.parseInt(telefonoTexto.getText()), Double.parseDouble(nominaTexto.getText()),
							usuarioTexto.getText(), contraseñaTexto.getText());

					Class.forName("org.sqlite.JDBC");

					Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
					Statement stmt = (Statement) conn.createStatement();
					String instruccion = "INSERT INTO EMPLEADO VALUES(" + "'" + empleado.getNombre() + "'" + ", " + "'"
							+ empleado.getApellido() + "'" + "," + empleado.getDni() + "," + "'"
							+ empleado.getDireccion() + "'" + "," + empleado.getTelefono() + "," + empleado.getNomina()
							+ "," + "'" + empleado.getUsuario() + "'" + "," + "'" + empleado.getContraseña() + "'"
							+ ");";

					stmt.executeUpdate(instruccion);
					stmt.close();
					conn.commit();
					conn.close();

					logger.log(Level.INFO, "Ha funcionado el boton agregar.");
					
				} catch (Exception e2) {
					// TODO: handle exception

					logger.log(Level.SEVERE, "No se ha podido acceder a la base de datos.");
				}

			}
		});

		botones.add(cancelar);
		botones.add(agregar);
		add(botones);
		
		setBackground(Color.WHITE);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("REGISTRAR NUEVO EMPLEADO");
		setSize(450, 600);
		setLayout(new GridLayout(9, 1));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
