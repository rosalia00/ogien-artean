import java.awt.GridLayout;

import javax.swing.*;

public class VentanaEmpleadoPedidos extends JFrame {
	//Botones de perfil del empleado
	JButton horas;
	JButton perfil;
	
	//Boton atras
	JButton atras; 
	
	//Botones pedidos
	JTextField pedidos;
	JButton confirmar;
	
	//Paneles
	JPanel arriba;
	JPanel centro1;
	JPanel centro2;
	JPanel centro3;
	JPanel centro4;
	JPanel abajo;
	
	public VentanaEmpleadoPedidos() {
		//Botones de perfil del empleado
		horas = new JButton("HORAS");
		perfil = new JButton("PERFIL");
		
		//Boton atras
		atras = new JButton("<--"); 
		
		//Botones pedidos
		JTextField pedidos;
		JButton confirmar;
		
		//Paneles
		arriba = new JPanel();
		centro1 = new JPanel();
		centro1.setLayout(new GridLayout(2,1));
		centro2 = new JPanel();
		centro2.setLayout(new GridLayout(2,1));
		centro3 = new JPanel();
		centro3.setLayout(new GridLayout(2,1));
		centro4 = new JPanel();
		centro4.setLayout(new GridLayout(2,1));
		abajo = new JPanel();
		
		arriba.add(horas);
		arriba.add(perfil);
		abajo.add(atras);
	}
	
}
