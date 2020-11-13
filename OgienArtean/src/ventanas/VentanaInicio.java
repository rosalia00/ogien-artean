package ventanas;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class VentanaInicio extends JFrame{
	
	JButton cliente;
	JButton empleado;
	
	public VentanaInicio() {
		
		cliente = new JButton("cliente");
		cliente.setContentAreaFilled(false);
		cliente.setBorderPainted(false);
		cliente.setFocusPainted(false);
		cliente.setIcon(new ImageIcon("imagenes/cliente.png"));
		
		empleado = new JButton("empleado");
		empleado.setContentAreaFilled(false);
		empleado.setBorderPainted(false);
		empleado.setFocusPainted(false);
		empleado.setIcon(new ImageIcon("imagenes/empleado.png"));
		
		add(cliente);
		add(empleado);
		
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Inicio");
		setSize(500, 250);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		setVisible(true);
	}

}
