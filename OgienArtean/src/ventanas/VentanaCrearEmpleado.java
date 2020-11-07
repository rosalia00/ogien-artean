package ventanas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

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

	public VentanaCrearEmpleado() {
		nombreTexto = new JTextField();
		nombreTexto.setPreferredSize(new Dimension(250, 20));
		nombreLabel = new JLabel("NOMBRE: ");
		nombrePanel = new JPanel();

		apellidoTexto = new JTextField();
		apellidoTexto.setPreferredSize(new Dimension(250, 20));
		apellidoLabel = new JLabel("APELLIDO: ");
		apellidoPanel = new JPanel();

		dniTexto = new JTextField();
		dniTexto.setPreferredSize(new Dimension(250, 20));
		dniLabel = new JLabel("DNI: ");
		dniPanel = new JPanel();

		direccionTexto = new JTextField();
		direccionTexto.setPreferredSize(new Dimension(250, 20));
		direccionLabel = new JLabel("DIRECCION: ");
		direccionPanel = new JPanel();

		telefonoTexto = new JTextField();
		telefonoTexto.setPreferredSize(new Dimension(250, 20));
		telefonoLabel = new JLabel("TELEFONO: ");
		telefonoPanel = new JPanel();

		nominaTexto = new JTextField();
		nominaTexto.setPreferredSize(new Dimension(250, 20));
		nominaLabel = new JLabel("NOMINA: ");
		nominaPanel = new JPanel();

		usuarioTexto = new JTextField();
		usuarioTexto.setPreferredSize(new Dimension(250, 20));
		usuarioLabel = new JLabel("USUARIO: ");
		usuarioPanel = new JPanel();

		contraseñaTexto = new JTextField();
		contraseñaTexto.setPreferredSize(new Dimension(250, 20));
		contraseñaLabel = new JLabel("CONTRASEÑA: ");
		contraseñaPanel = new JPanel();

		agregar = new JButton("AGREGAR");
		cancelar = new JButton("CANCELAR");

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
					String instruccion = "INSERT INTO EMPLEADOS VALUES(" + empleado.getNombre() + ", "
							+ empleado.getApellido() + "," + empleado.getDni() + "," + empleado.getDireccion() + ","
							+ empleado.getTelefono() + "," + empleado.getUsuario() + "," + empleado.getContraseña()
							+ ");";
					System.out.println(instruccion);
					int rs = stmt.executeUpdate(instruccion);

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		
		add(cancelar);
		add(agregar);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Administrar Empleados");
		setSize(500, 600);
		setLayout(new FlowLayout());
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
