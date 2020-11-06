package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	public VentanaLoginEmpleado() {

		setTitle("Inicio");
		setSize(310, 260);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 1));
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);

		panelDecorativo = new JPanel();
		panelDecorativo.setLayout(new GridLayout(1, 1));
		panelDecorativo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); // TOC
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
		panelBotonera.add(aceptar);
		panelBotonera.setBackground(new Color(149, 194, 197));
		panelDatos.add(panelBotonera);

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

	public void changed() {
		if (contraseña.getText().equals("") || contraseña.getText().contains(" ") || usuario.getText().equals("")
				|| usuario.getText().contains(" ")) {
			aceptar.setEnabled(false);
		} else {
			aceptar.setEnabled(true);
		}
	}

}
