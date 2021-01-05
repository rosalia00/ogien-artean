package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import ogienartean.Cliente;

public class VentanaCrearCliente extends JFrame {

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

	private JTextField tarjetaTexto;
	private JLabel tarjetaLabel;
	private JPanel tarjetaPanel;

	private JRadioButton entregaButton;
	private JLabel entregaLabel;
	private JPanel entregaPanel;

	private JTextField usuarioTexto;
	private JLabel usuarioLabel;
	private JPanel usuarioPanel;

	private JTextField contrase�aTexto;
	private JLabel contrase�aLabel;
	private JPanel contrase�aPanel;

	private JButton agregar;
	private JButton cancelar;
	private JPanel botones;

	public VentanaCrearCliente(Logger logger, Connection conn, Statement stmt) {

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

		tarjetaTexto = new JTextField();
		tarjetaTexto.setPreferredSize(new Dimension(250, 20));
		tarjetaTexto.setBorder(new LineBorder(new Color(115, 115, 115)));
		tarjetaLabel = new JLabel("TARJETA: ");
		tarjetaLabel.setPreferredSize(new Dimension(100, 20));
		tarjetaPanel = new JPanel();
		tarjetaPanel.setBackground(Color.WHITE);

		entregaButton = new JRadioButton("SI");
		entregaButton.setPreferredSize(new Dimension(250, 20));
		entregaButton.setBorder(new LineBorder(new Color(115, 115, 115)));
		entregaButton.setOpaque(false);
		entregaLabel = new JLabel("ENTREGA: ");
		entregaLabel.setPreferredSize(new Dimension(100, 20));
		entregaPanel = new JPanel();
		entregaPanel.setBackground(Color.WHITE);

		usuarioTexto = new JTextField();
		usuarioTexto.setPreferredSize(new Dimension(250, 20));
		usuarioTexto.setBorder(new LineBorder(new Color(115, 115, 115)));
		usuarioLabel = new JLabel("USUARIO: ");
		usuarioLabel.setPreferredSize(new Dimension(100, 20));
		usuarioPanel = new JPanel();
		usuarioPanel.setBackground(Color.WHITE);

		contrase�aTexto = new JTextField();
		contrase�aTexto.setPreferredSize(new Dimension(250, 20));
		contrase�aTexto.setBorder(new LineBorder(new Color(115, 115, 115)));
		contrase�aLabel = new JLabel("CONTRASE�A: ");
		contrase�aLabel.setPreferredSize(new Dimension(100, 20));
		contrase�aPanel = new JPanel();
		contrase�aPanel.setBackground(Color.WHITE);

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
		tarjetaPanel.add(tarjetaLabel);
		tarjetaPanel.add(tarjetaTexto);
		add(tarjetaPanel);
		entregaPanel.add(entregaLabel);
		entregaPanel.add(entregaButton);
		add(entregaPanel);
		usuarioPanel.add(usuarioLabel);
		usuarioPanel.add(usuarioTexto);
		add(usuarioPanel);
		contrase�aPanel.add(contrase�aLabel);
		contrase�aPanel.add(contrase�aTexto);
		add(contrase�aPanel);

		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton cancelar.");
			}
		});

		agregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					System.out.println("llega");

					Cliente c = new Cliente(nombreTexto.getText(), apellidoTexto.getText(),
							Integer.parseInt(dniTexto.getText()), direccionTexto.getText(),
							Integer.parseInt(telefonoTexto.getText()), Integer.parseInt(tarjetaTexto.getText()),
							entregaButton.isSelected(), usuarioTexto.getText(), contrase�aTexto.getText());

					System.out.println("llega0");

					Statement stmt = (Statement) conn.createStatement();

					String instruccion = "INSERT INTO CLIENTE VALUES('" + c.getNombre() + "'" + ", '" + c.getApellido()
							+ "'" + "," + c.getDni() + ",'" + c.getDireccion() + "' ," + c.getTelefono() + ","
							+ c.getTarjeta() + "," + c.getEntrega() + ", '" + c.getUsuario() + "' , '"
							+ c.getContrase�a() + "');";

					System.out.println(instruccion);

					stmt.executeUpdate(instruccion);

					logger.log(Level.INFO, "Ha funcionado la funcion agregar.");

				} catch (Exception e) {
					// TODO: handle exception

					logger.log(Level.SEVERE, "No se ha podido acceder a la base de datos.");
				}
				VentanaLoginCliente i = new VentanaLoginCliente(logger, conn, stmt);
				dispose();
			}

		});

		botones.add(cancelar);
		botones.add(agregar);
		add(botones);

		setBackground(Color.WHITE);

		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("REGISTRAR NUEVO CLIENTE");
		setSize(450, 600);
		setLayout(new GridLayout(10, 1));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
