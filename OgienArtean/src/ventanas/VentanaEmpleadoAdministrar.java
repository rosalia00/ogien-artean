package ventanas;

import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class VentanaEmpleadoAdministrar extends JFrame {

	JButton perfil;

	JPanel botones;

	JButton aceptar;

	JLabel eliminar;
	JLabel añadir;

	JTextField cNombre;
	JLabel cNombreLabel;
	JSpinner cPrecio;
	JLabel cPrecioLabel;
	JRadioButton cCeliaco;
	JLabel cCeliacoLabel;
	JRadioButton cCaliente;
	JLabel cCalienteLabel;
	JComboBox<String> cTipo;
	JLabel cTipoLabel;
	JButton cAñadir;
	JPanel cPanelArriba;
	JPanel cPanel;

	JTextField bNombre;
	JLabel bNombreLabel;
	JSpinner bPrecio;
	JLabel bPrecioLabel;
	JRadioButton bCeliaco;
	JLabel bCeliacoLabel;
	JPanel bIngredientesPanel;
	JTextField bIngredientes;
	JLabel bIngredientesLabel;
	JButton bIngredientesButon;
	JRadioButton bSal;
	JLabel bSalLabel;
	JButton bAñadir;
	JPanel bPanelArriba;
	JPanel bPanel;

	JTextField pNombre;
	JLabel pNombreLabel;
	JSpinner pPrecio;
	JLabel pPrecioLabel;
	JRadioButton pCeliaco;
	JLabel pCeliacoLabel;
	JComboBox<String> pTipo;
	JLabel pTipoLabel;
	JButton pAñadir;
	JPanel pPanelArriba;
	JPanel pPanel;

	private int numero = 1;
	JButton izquierda;
	JLabel opcion;
	JButton derecha;
	JPanel derechaAbajo;

	private static Logger logger = Logger.getLogger(VentanaEmpleadoAdministrar.class.getName());

	public VentanaEmpleadoAdministrar() {

		perfil = new JButton();
		perfil.setContentAreaFilled(false);
		perfil.setBorderPainted(false);
		perfil.setFocusPainted(false);
		perfil.setIcon(new ImageIcon("imagenes/perfil.png"));
		perfil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VentanaPerfil a = new VentanaPerfil();
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton perfil.");
			}
		});

		cNombre = new JTextField();
		cNombreLabel = new JLabel("NOMBRE: ");
		cPrecio = new JSpinner(new SpinnerNumberModel(0, 0.00, 99.99, 0.01));
		cPrecioLabel = new JLabel("PRECIO: ");
		cCeliaco = new JRadioButton("Sí");
		cCeliacoLabel = new JLabel("CELIACO: ");
		cCaliente = new JRadioButton("Sí");
		cCalienteLabel = new JLabel("CALIENTE: ");
		cTipo = new JComboBox<String>();
		cTipo.addItem("Pizza");
		cTipo.addItem("Bocadillo");
		cTipo.addItem("Empanada");
		cTipoLabel = new JLabel("TIPO: ");
		cAñadir = new JButton("AÑADIR");
		cPanelArriba = new JPanel();
		cPanelArriba.setLayout(new GridLayout(5, 2));
		cPanel = new JPanel();
		cPanel.setLayout(new GridLayout(2, 1));
		cPanelArriba.add(cNombreLabel);
		cPanelArriba.add(cNombre);
		cPanelArriba.add(cPrecioLabel);
		cPanelArriba.add(cPrecio);
		cPanelArriba.add(cCeliacoLabel);
		cPanelArriba.add(cCeliaco);
		cPanelArriba.add(cCalienteLabel);
		cPanelArriba.add(cCaliente);
		cPanelArriba.add(cTipoLabel);
		cPanelArriba.add(cTipo);
		cPanel.add(cPanelArriba);
		cPanel.add(cAñadir);

		bNombre = new JTextField();
		bNombreLabel = new JLabel("NOMBRE: ");
		bPrecio = new JSpinner(new SpinnerNumberModel(0, 0.00, 99.99, 0.01));
		bPrecioLabel = new JLabel("PRECIO: ");
		bCeliaco = new JRadioButton("Sí");
		bCeliacoLabel = new JLabel("CELIACO: ");
		bIngredientesPanel = new JPanel(new GridLayout(1, 2));
		bIngredientes = new JTextField();
		bIngredientesLabel = new JLabel("INGREDIENTES: ");
		bIngredientesButon = new JButton("AÑADIR");
		bIngredientesPanel.add(bIngredientes);
		bIngredientesPanel.add(bIngredientesButon);
		bSal = new JRadioButton("Sí");
		bSalLabel = new JLabel("SAL: ");
		bAñadir = new JButton("AÑADIR");
		bPanelArriba = new JPanel(new GridLayout(5, 2));
		bPanel = new JPanel(new GridLayout(2, 1));
		bPanelArriba.add(bNombreLabel);
		bPanelArriba.add(bNombre);
		bPanelArriba.add(bPrecioLabel);
		bPanelArriba.add(bPrecio);
		bPanelArriba.add(bCeliacoLabel);
		bPanelArriba.add(bCeliaco);
		bPanelArriba.add(bIngredientesLabel);
		bPanelArriba.add(bIngredientesPanel);
		bPanelArriba.add(bSalLabel);
		bPanelArriba.add(bSal);
		bPanel.add(bPanelArriba);
		bPanel.add(bAñadir);

		pNombre = new JTextField();
		pNombreLabel = new JLabel("NOMBRE: ");
		pPrecio = new JSpinner(new SpinnerNumberModel(0, 0.00, 99.99, 0.01));
		pPrecioLabel = new JLabel("PRECIO: ");
		pCeliaco = new JRadioButton("Sí");
		pCeliacoLabel = new JLabel("CELIACO: ");
		pTipo = new JComboBox<String>();
		pTipo.addItem("Tarta");
		pTipo.addItem("Pastel");
		pTipo.addItem("Galleta");
		pTipoLabel = new JLabel("TIPO: ");
		pAñadir = new JButton("AÑADIR");
		pPanelArriba = new JPanel();
		pPanelArriba.setLayout(new GridLayout(4, 2));
		pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(2, 1));
		pPanelArriba.add(pNombreLabel);
		pPanelArriba.add(pNombre);
		pPanelArriba.add(pPrecioLabel);
		pPanelArriba.add(pPrecio);
		pPanelArriba.add(pCeliacoLabel);
		pPanelArriba.add(pCeliaco);
		pPanelArriba.add(pTipoLabel);
		pPanelArriba.add(pTipo);
		pPanel.add(pPanelArriba);
		pPanel.add(pAñadir);

		izquierda = new JButton("<");
		opcion = new JLabel("ELECCION");
		derecha = new JButton(">");

		izquierda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (numero == 1) {
					opcion.setText("PAN");
				} else if (numero == 2) {
					opcion.setText("PASTELERIA");
				} else if (numero == 0) {
					opcion.setText("COMIDA");
				}

				if (numero <= 2 && numero >= 1) {
					numero--;
				} else if (numero == 0) {
					numero = 2;
				}

			}
		});

		derecha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (numero == 1) {
					opcion.setText("PAN");
				} else if (numero == 2) {
					opcion.setText("PASTELERIA");
				} else if (numero == 0) {
					opcion.setText("COMIDA");
				}

				if (numero < 2 && numero >= 0) {
					numero++;
				} else if (numero == 2) {
					numero = 0;
				}

			}
		});

		derechaAbajo = new JPanel();
		derechaAbajo.add(izquierda);
		derechaAbajo.add(opcion);
		derechaAbajo.add(derecha);

		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));

		botones = new JPanel(new FlowLayout());
		botones.add(perfil);
		botones.setOpaque(false);

		add(botones);
		add(derechaAbajo);

		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("ADMINISTRACION");
		setSize(700, 600);
		setLayout(new GridLayout(2, 1));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
