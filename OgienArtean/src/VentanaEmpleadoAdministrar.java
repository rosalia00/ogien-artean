import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class VentanaEmpleadoAdministrar {
	
	JLabel nombreYApellidos;
	JPanel fotoEmpleado;
	
	JButton horas;
	JButton perfil;
	
	JPanel empleadoPerfil;
	
	JComboBox opcion;
	
	JButton aceptar;
	
	JLabel eliminar;
	JLabel a�adir;
	public VentanaEmpleadoAdministrar() {
		
		for (int i = 0; i < 3; i++) {
			empleadoPerfil = new JPanel();
			empleadoPerfil.setLayout(new GridLayout(3, 1));
			fotoEmpleado = new JPanel();
			nombreYApellidos = new JLabel("BD");
			opcion = new JComboBox();
			opcion.add(eliminar = new JLabel("Eliminar"));
			opcion.add(a�adir = new JLabel("A�adir"));
			empleadoPerfil.add(fotoEmpleado);
			empleadoPerfil.add(nombreYApellidos);
			empleadoPerfil.add(opcion);	
		} 
	}
}
