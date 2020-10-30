import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class VentanaEmpleadoAdministrar extends JFrame{
	
	JLabel nombreYApellidos;
	JPanel fotoEmpleado;
	
	JButton horas;
	JButton perfil;
	
	JPanel empleadoPerfil;
	JPanel empleados;
	
	JComboBox opcion;
	
	JButton aceptar;
	
	JLabel eliminar;
	JLabel añadir;
	public VentanaEmpleadoAdministrar() {
		
		horas = new JButton("Horas");
		perfil = new JButton("Perfil");
		
		for (int i = 0; i < 3; i++) {
			empleadoPerfil = new JPanel();
			empleadoPerfil.setLayout(new GridLayout(3, 1));
			
			fotoEmpleado = new JPanel();
			nombreYApellidos = new JLabel("BD");
			opcion = new JComboBox();
			
			opcion.add(eliminar = new JLabel("Eliminar"));
			opcion.add(añadir = new JLabel("Añadir"));
			
			empleadoPerfil.add(fotoEmpleado);
			empleadoPerfil.add(nombreYApellidos);
			empleadoPerfil.add(opcion);	
			
			empleados = new JPanel();
			empleadoPerfil.setLayout(new FlowLayout());
			empleados.add(empleadoPerfil);
		} 
		
		add(horas);
		add(perfil);
		add(empleados);
		
		
	}
}
