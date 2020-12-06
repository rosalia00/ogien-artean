package ventanas;
import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class VentanaEmpleadoAdministrar extends JFrame{
	
	JTextField nombre;
	JSpinner precio;
	JTextField ingredientes;
	JButton añadirIngredientes;
	JRadioButton celiaco;
	JLabel celiacoNombre;
	JRadioButton sal;
	JLabel salNombre;
	
	JButton perfil;
	
	JPanel panPoner;
	
	JPanel botones;
	JPanel empleadoPerfil;
	JPanel empleados;
	
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
	JPanel cPanelAbajo;

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
		
		empleados = new JPanel();
		empleados.setOpaque(false);
		empleados.setLayout(new GridLayout(2, 5));
		
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
		cPanelAbajo = new JPanel();
		cPanelAbajo.setLayout(new GridLayout(2, 1));
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
		cPanelAbajo.add(cPanelArriba);
		cPanelAbajo.add(cAñadir);
		
		
		
		
		
		
		
		
		
		
		
		/* for (int i = 0; i < 8; i++) {
			panPoner = new JPanel();
			panPoner.setLayout(new GridLayout(5, 2));
			nombre = new JTextField();
			precio = new JSpinner();
			ingredientes = new JTextField();
			añadirIngredientes = new JButton("AÑADIR");
			celiaco = new JRadioButton();
			celiacoNombre = new JLabel("CELIACO");
			sal = new JRadioButton();
			salNombre = new JLabel("SAL");
			
			panPoner.add(nombre);
			panPoner.add(precio);
			panPoner.add(ingredientes);
			panPoner.add(añadirIngredientes);
			panPoner.add(celiaco);
			panPoner.add(celiacoNombre);
			panPoner.add(sal);
			panPoner.add(salNombre);
			
			empleados.add(panPoner);
			
		} */
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));
		
		botones = new JPanel(new FlowLayout());
		botones.add(perfil);
		botones.setOpaque(false);
		
		add(botones);
		add(empleados);
		
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
