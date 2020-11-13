package ventanas;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaIdentif extends JFrame{
	
	JButton iniciarSesion;
	JButton registrarse;
	
	public VentanaIdentif() {
		iniciarSesion = new JButton();
		iniciarSesion.setContentAreaFilled(false);
		iniciarSesion.setBorderPainted(false);
		iniciarSesion.setFocusPainted(false);
		iniciarSesion.setIcon(new ImageIcon("imagenes/cliente.png"));
		
		registrarse = new JButton();
		registrarse.setContentAreaFilled(false);
		registrarse.setBorderPainted(false);
		registrarse.setFocusPainted(false);
		registrarse.setIcon(new ImageIcon("imagenes/cliente.png"));
		
		
	}

}
