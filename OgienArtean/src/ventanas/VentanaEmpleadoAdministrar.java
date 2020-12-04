package ventanas;
import java.awt.*;

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
	
	JButton horas;
	JButton perfil;
	
	JPanel panPoner;
	
	JPanel botones;
	JPanel empleadoPerfil;
	JPanel empleados;
	
	JButton aceptar;
	
	JLabel eliminar;
	JLabel añadir;
	
	public VentanaEmpleadoAdministrar() {
		
		horas = new JButton();
		horas.setContentAreaFilled(false);
		horas.setBorderPainted(false);
		horas.setFocusPainted(false);
		horas.setIcon(new ImageIcon("imagenes/horas.png"));
		
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
				
			}
		});
		
		empleados = new JPanel();
		empleados.setOpaque(false);
		empleados.setLayout(new GridLayout(2, 5));
		
		for (int i = 0; i < 8; i++) {
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
			
		} 
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));
		
		botones = new JPanel(new FlowLayout());
		botones.add(horas);
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
