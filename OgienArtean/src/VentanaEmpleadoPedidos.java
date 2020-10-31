import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class VentanaEmpleadoPedidos extends JFrame{
	//Botones de perfil del empleado
	JButton horas;
	JButton perfil;
	
	//Boton atras
	JButton atras; 
	
	//Botones pedidos
	JLabel pedido0;
	JButton confirmar0;
	
	//Paneles
	JPanel arriba;
	JPanel centro1;
	JPanel centro2;
	JPanel centro3;
	JPanel centro4;
	JPanel abajo;
	
	public VentanaEmpleadoPedidos() {
		//Botones de perfil del empleado
		//Boton horas
		horas = new JButton();
			horas.setIcon(new ImageIcon("horas.png"));
			horas.setContentAreaFilled(false);
			horas.setBorderPainted(false);
			horas.setFocusPainted(false);
		//Boton perfil
		perfil = new JButton();
			perfil.setIcon(new ImageIcon("perfil.png"));
			perfil.setContentAreaFilled(false);
			perfil.setBorderPainted(false);
			perfil.setFocusPainted(false);
		
		//Boton atras
		atras = new JButton();
			atras.setIcon(new ImageIcon("volver.png"));
			atras.setContentAreaFilled(false);
			atras.setBorderPainted(false);
			atras.setFocusPainted(false);
		
		//Paneles
		arriba = new JPanel();
		centro1 = new JPanel();
		centro1.setLayout(new GridLayout(1,2));
		centro2 = new JPanel();
		centro2.setLayout(new GridLayout(1,2));
		centro3 = new JPanel();
		centro3.setLayout(new GridLayout(1,2));
		centro4 = new JPanel();
		centro4.setLayout(new GridLayout(1,2));
		abajo = new JPanel();
		
		//Añadir a paneles las horas, perfil, atras
		arriba.add(horas);
		arriba.add(perfil);
		abajo.add(atras);

		//Botones pedidos primera fila 
		for (int i = 0; i <= 5; i++) {
			pedido0 = new JLabel("PEDIDO");
			confirmar0 = new JButton("CONFIRMAR");
			 
			centro1.add(pedido0);
			centro2.add(confirmar0);
		}
		
		//Botones pedidos segunda fila 
		for (int i = 0; i <= 5; i++) {
			pedido0 = new JLabel("PEDIDO");
			confirmar0 = new JButton("CONFIRMAR");
			 
			centro3.add(pedido0);
			centro4.add(confirmar0);
		}
		
		add(arriba);
		add(centro1);
		add(centro2);
		add(centro3);
		add(centro4);
		add(abajo);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("octocat.png"));
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Empleado Pedidos");
		setSize(1500,800);
		setLayout(new GridLayout(6,1));
		setVisible(true);
		setResizable(false);

	}
	
}
