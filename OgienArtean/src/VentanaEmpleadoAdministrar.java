import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class VentanaEmpleadoAdministrar extends JFrame{
	
	JLabel nombreYApellidos;
	JPanel fotoEmpleado;
	
	JButton horas;
	JButton perfil;
	
	JPanel botones;
	JPanel empleadoPerfil;
	JPanel empleados;
	
	JComboBox opcion;
	
	JButton aceptar;
	
	JLabel eliminar;
	JLabel añadir;
	public VentanaEmpleadoAdministrar() {
		
		horas = new JButton();
		horas.setContentAreaFilled(false);
		horas.setBorderPainted(false);
		horas.setFocusPainted(false);
		horas.setIcon(new ImageIcon("horas.png"));
		
		perfil = new JButton();
		perfil.setContentAreaFilled(false);
		perfil.setBorderPainted(false);
		perfil.setFocusPainted(false);
		perfil.setIcon(new ImageIcon("perfil.png"));
		perfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		empleados = new JPanel();
		empleados.setOpaque(false);
		
		for (int i = 0; i < 10; i++) {
			empleadoPerfil = new JPanel();
			empleadoPerfil.setOpaque(false);
			fotoEmpleado = new JPanel();
			nombreYApellidos = new JLabel("BD");
			opcion = new JComboBox();
			opcion.addItem("Añadir");
			opcion.addItem("Eliminar");
			
			empleadoPerfil.add(fotoEmpleado);
			empleadoPerfil.add(nombreYApellidos);
			empleadoPerfil.add(opcion);
			
			empleados.setLayout(new GridLayout(2, 5));
			empleados.add(empleadoPerfil);
		} 
		setContentPane(new JLabel(new ImageIcon("fondo3.png")));
		
		botones = new JPanel(new FlowLayout());
		botones.add(horas);
		botones.add(perfil);
		botones.setOpaque(false);
		
		add(botones);
		add(empleados);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("octocat.png"));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Administrar Empleados");
		setSize(500, 300);
		setLayout(new GridLayout(2, 1));
		setVisible(true);
	}
}
