import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaEmpleadoInicio extends JFrame {
	//Botones opciones de empleado
	JButton administrar;
	JButton pedidos;
	JButton registro;
	
	//Botones de perfil del empleado
	JButton horas;
	JButton perfil;
	
	//Paneles
	JPanel arriba;
	JPanel abajo;
	
	public VentanaEmpleadoInicio() {
		//Boton administrar
		administrar = new JButton();
			administrar.setIcon(new ImageIcon("administracion.png"));
			administrar.setContentAreaFilled(false);
			administrar.setBorderPainted(false);
			administrar.setFocusPainted(false);
			administrar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new VentanaEmpleadoAdministrar();
					dispose();					
				}
				
			});
			
		//Boton pedidos
		pedidos = new JButton();
			pedidos.setIcon(new ImageIcon("pedidos.png"));
			pedidos.setContentAreaFilled(false);
			pedidos.setBorderPainted(false);
			pedidos.setFocusPainted(false);
			pedidos.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new VentanaEmpleadoPedidos();
					dispose();
				}
			});
		
		//Boton registro
		registro = new JButton();
			registro.setIcon(new ImageIcon("registro.png"));
			registro.setContentAreaFilled(false);
			registro.setBorderPainted(false);
			registro.setFocusPainted(false);
			
		
		
		//Boton horas
		horas = new JButton();
			horas.setIcon(new ImageIcon("horas1.png"));
			horas.setContentAreaFilled(false);
			horas.setBorderPainted(false);
			horas.setFocusPainted(false);
		
		//Boton perfil
		perfil = new JButton();
			perfil.setIcon(new ImageIcon("perfil1.png"));
			perfil.setContentAreaFilled(false);
			perfil.setBorderPainted(false);
			perfil.setFocusPainted(false);


		arriba = new JPanel();
		arriba.setOpaque(false);
		abajo = new JPanel();
		abajo.setOpaque(false);
		
		//Fondo
		setContentPane(new JLabel(new ImageIcon("fondo3.png")));
		
		//Añadir a los panels 
		arriba.add(horas);
		arriba.add(perfil);
		abajo.add(pedidos);
		abajo.add(registro);
		abajo.add(administrar);
		
		//Añadir a la pagina
		add(arriba);
		add(abajo);
		
		//Icono de paginas
		setIconImage(Toolkit.getDefaultToolkit().getImage("octocat.ong"));
		
		//Final
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Empleado Inicio");
		setSize(500, 300);
		setLayout(new GridLayout(2,1));
		setResizable(false);
		setVisible(true);
	}
}
