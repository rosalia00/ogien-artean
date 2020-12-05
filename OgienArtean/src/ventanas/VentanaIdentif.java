package ventanas;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;
import javax.swing.*;

public class VentanaIdentif extends JFrame{
	
	JButton iniciarSesion;
	JButton registrarse;

	private static Logger logger = Logger.getLogger(VentanaIdentif.class.getName());
	
	public VentanaIdentif(String d) {
		
		iniciarSesion = new JButton("a");
		iniciarSesion.setContentAreaFilled(false);
		iniciarSesion.setBorderPainted(false);
		iniciarSesion.setFocusPainted(false);
		iniciarSesion.setIcon(new ImageIcon("imagenes/iniciarSesion.png"));
		iniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(d == "empleado") {
					VentanaLoginEmpleado a = new VentanaLoginEmpleado();
					logger.log(Level.INFO, "Se ha iniciado sesion como empleado.");
				} else if(d == "cliente") {
					VentanaLoginCliente b = new VentanaLoginCliente();
					logger.log(Level.INFO, "Se ha iniciado sesion como cliente.");
				}
			}
		});
		
		registrarse = new JButton("Registrarse");
		registrarse.setContentAreaFilled(false);
		registrarse.setBorderPainted(false);
		registrarse.setFocusPainted(false);
		registrarse.setIcon(new ImageIcon("imagenes/registrarse.png"));
		registrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(d == "empleado") {
					VentanaCrearEmpleado a = new VentanaCrearEmpleado();
					logger.log(Level.INFO, "Se ha registrado como empleado.");
				} else if(d == "cliente") {
					VentanaCrearCliente b = new VentanaCrearCliente();
					logger.log(Level.INFO, "Se ha registrado como cliente.");
				}
			}
		});
		
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));
		
		add(iniciarSesion);
		add(registrarse);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("INICIO");
		setSize(500, 250);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}

}
