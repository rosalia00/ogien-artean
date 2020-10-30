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
	JLabel a�adir;
	public VentanaEmpleadoAdministrar() {
		
		horas = new JButton("Horas");
		perfil = new JButton("Perfil");
		
		empleados = new JPanel();
		
		for (int i = 0; i < 10; i++) {
			empleadoPerfil = new JPanel();
			
			fotoEmpleado = new JPanel();
			nombreYApellidos = new JLabel("BD");
			opcion = new JComboBox();
			
			empleadoPerfil.add(fotoEmpleado);
			empleadoPerfil.add(nombreYApellidos);
			empleadoPerfil.add(opcion);	
			
			empleados.setLayout(new GridLayout(2, 5));
			empleados.add(empleadoPerfil);
		} 
		
		botones = new JPanel(new FlowLayout());
		botones.add(horas);
		botones.add(perfil);
		
		add(botones);
		add(empleados);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Administrar Empleados");
		setSize(500, 300);
		setLayout(new GridLayout(2, 1));
		setVisible(true);
	}
}
