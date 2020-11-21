package ventanas;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	
	private JTextField entregaTexto;
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
		tarjetaLabel = new JLabel("TELEFONO: ");
		tarjetaPanel = new JPanel();

		entregaTexto = new JTextField();
		entregaTexto.setPreferredSize(new Dimension(250, 20));
		entregaLabel = new JLabel("TELEFONO: ");
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

		
		

	}

}
