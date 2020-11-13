package ventanas;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaIdentif extends JFrame{
	
	JButton iniciarSesion;
	JButton registrarse;
	
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
				} else if(d == "cliente") {
					VentanaLoginEmpleado b = new VentanaLoginEmpleado();
				}
			}
		});
		
		registrarse = new JButton();
		registrarse.setContentAreaFilled(false);
		registrarse.setBorderPainted(false);
		registrarse.setFocusPainted(false);
		registrarse.setIcon(new ImageIcon("imagenes/registrarse.png"));
		registrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));
		
		add(iniciarSesion);
		add(registrarse);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Inicio");
		setSize(500, 250);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}

}
