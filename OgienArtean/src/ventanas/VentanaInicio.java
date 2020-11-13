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
		
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Inicio");
		setSize(1000, 600);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		setVisible(true);
	}

}
