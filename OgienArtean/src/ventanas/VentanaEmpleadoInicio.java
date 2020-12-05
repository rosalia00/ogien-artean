package ventanas;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;
import javax.swing.*;

public class VentanaEmpleadoInicio extends JFrame {
	//Botones opciones de empleado
	JButton administrar;
	JButton pedidos;
	JButton registro;
	
	//Botones de perfil del empleado
	JButton perfil;
	
	//Paneles
	JPanel arriba;
	JPanel abajo;
	
	private static Logger logger = Logger.getLogger(VentanaEmpleadoInicio.class.getName());
	
	public VentanaEmpleadoInicio() {
		//Boton administrar
		administrar = new JButton();
			administrar.setIcon(new ImageIcon("imagenes/administracion.png"));
			administrar.setContentAreaFilled(false);
			administrar.setBorderPainted(false);
			administrar.setFocusPainted(false);
			administrar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new VentanaEmpleadoAdministrar();
					dispose();
					logger.log(Level.INFO, "Ha funcionado el boton administrar.");
				}
				
			});
			
		//Boton pedidos
		pedidos = new JButton();
			pedidos.setIcon(new ImageIcon("imagenes/pedidos.png"));
			pedidos.setContentAreaFilled(false);
			pedidos.setBorderPainted(false);
			pedidos.setFocusPainted(false);
			pedidos.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new VentanaEmpleadoPedidos();
					dispose();
					logger.log(Level.INFO, "Ha funcionado el boton pedidos.");
				}
			});
		
		//Boton registro
		registro = new JButton();
			registro.setIcon(new ImageIcon("imagenes/registro.png"));
			registro.setContentAreaFilled(false);
			registro.setBorderPainted(false);
			registro.setFocusPainted(false);
			
		
		
		
		//Boton perfil
		perfil = new JButton();
			perfil.setIcon(new ImageIcon("imagenes/perfil1.png"));
			perfil.setContentAreaFilled(false);
			perfil.setBorderPainted(false);
			perfil.setFocusPainted(false);


		arriba = new JPanel();
		arriba.setOpaque(false);
		abajo = new JPanel();
		abajo.setOpaque(false);
		
		//Fondo
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));
		
		//Añadir a los panels 
		arriba.add(perfil);
		abajo.add(pedidos);
		abajo.add(registro);
		abajo.add(administrar);
		
		//Añadir a la pagina
		add(arriba);
		add(abajo);
		
		//Icono de paginas
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		
		//Final
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("INICIO");
		setSize(500, 500);
		setLayout(new GridLayout(2,1));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
