import java.awt.Dimension;
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
		//Panel Arriba
		arriba = new JPanel();
		arriba.setOpaque(false);
		
		//Panel Centro 1
		centro1 = new JPanel();
		centro1.setLayout(new GridLayout(1,2));
		centro1.setOpaque(false);
		//centro1.setMaximumSize(new Dimension(400,400));
		
		//Panel Centro 2
		centro2 = new JPanel();
		centro2.setLayout(new GridLayout(1,2));
		centro2.setOpaque(false);
		//centro2.setMaximumSize(new Dimension(400,400));
		
		//Panel Centro 3
		centro3 = new JPanel();
		centro3.setLayout(new GridLayout(1,2));
		centro3.setOpaque(false);
		//centro3.setMaximumSize(new Dimension(400,400));
		
		//Panel Centro 4
		centro4 = new JPanel();
		centro4.setLayout(new GridLayout(1,2));
		centro4.setOpaque(false);
		//centro4.setMaximumSize(new Dimension(400,400));
		
		//Panel Abajo
		abajo = new JPanel();
		abajo.setOpaque(false);

		//Añadir a paneles las horas, perfil, atras
		arriba.add(horas);
		arriba.add(perfil);
		abajo.add(atras);		
		
				
		//Botones pedidos primera fila 
		for (int i = 0; i <= 5; i++) {
			pedido0 = new JLabel("PEDIDO");
			confirmar0 = new JButton("CONFIRMAR");
			confirmar0.setPreferredSize(new Dimension(20,20));
			
			centro1.add(pedido0);
			centro2.add(confirmar0);
		}
		
		//Botones pedidos segunda fila 
		for (int i = 0; i <= 5; i++) {
			pedido0 = new JLabel("PEDIDO");
			confirmar0 = new JButton("CONFIRMAR");
			confirmar0.setPreferredSize(new Dimension(20,20));
			
			centro3.add(pedido0);
			centro4.add(confirmar0);
		}
		
		//Fondo 
		setContentPane(new JLabel(new ImageIcon("fondo3.png")));
				
		//Añadir paneles
		add(arriba);
		add(centro1);
		add(centro2);
		add(centro3);
		add(centro4);
		add(abajo);
				
		//Icono de pagina
		setIconImage(Toolkit.getDefaultToolkit().getImage("octocat.png"));
				
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Empleado Pedidos");
		setSize(1000,600);
		setLayout(new GridLayout(6,1));
		setVisible(true);
		setResizable(false);

	}
	
}
