package ventanas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


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

	private JTextField contraseñaTexto;
	private JLabel contraseñaLabel;
	private JPanel contraseñaPanel;

	private JButton agregar;
	private JButton cancelar;

	public VentanaCrearCliente() {
	
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

		tarjetaTexto = new JTextField();
		tarjetaTexto.setPreferredSize(new Dimension(250, 20));
		tarjetaLabel = new JLabel("TARJETA: ");
		tarjetaPanel = new JPanel();

		entregaButton = new JRadioButton();
		entregaButton.setPreferredSize(new Dimension(250, 20));
		entregaLabel = new JLabel("ENTREGA");
		entregaPanel = new JPanel();
		

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
		tarjetaPanel.add(tarjetaLabel);
		tarjetaPanel.add(tarjetaTexto);
		add(tarjetaPanel);
		entregaPanel.add(entregaLabel);
		entregaPanel.add(entregaButton);
		add(entregaPanel);
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
			public void actionPerformed(ActionEvent arg0) {
				try {
					Cliente c = new Cliente(nombreTexto.getText(), apellidoTexto.getText(), Integer.parseInt(dniTexto.getText()), 
								direccionTexto.getText(), Integer.parseInt(telefonoTexto.getText()), Integer.parseInt(tarjetaTexto.getText()), entregaButton.isSelected(), 
								usuarioTexto.getText(), contraseñaTexto.getText());

					Class.forName("org.sqlite.JDBC");
					
					Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
					Statement stmt = (Statement) conn.createStatement();
					
					String instruccion = "INSERT INTO CLIENTE VALUES('" + c.getNombre() +"'" + "," + c.getApellido() +"'" + "," + 
					c.getDni() + ",'" + c.getDireccion() + "' ," + c.getTelefono() + "," + c.getTarjeta() + "," + c.getEntrega() + ", '" + 
					c.getUsuario() + "' , '" + c.getContraseña() + "');";
					
					stmt.executeUpdate(instruccion);
					
					stmt.close();
					conn.commit();
					conn.close();

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		add(cancelar);
		add(agregar);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Crear Cliente");
		setSize(500, 600);
		setLayout(new FlowLayout());
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);


	}

}
