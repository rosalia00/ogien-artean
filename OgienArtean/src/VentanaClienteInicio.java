import java.awt.*;

import java.awt.event.*;

import java.io.*;


import javax.swing.*;

public class VentanaClienteInicio extends JFrame{
	
	//Botones de compra
	JButton panaderia;
	JButton pasteleria;
	JButton cocina;
	
	//Botones de usuario
	JButton miCarro;
	JButton perfil;
	
	//Texto
	JLabel textoInicio;
	
	public VentanaClienteInicio() {
		
		panaderia = new JButton("Panadería");
		panaderia.setBounds(0, 0, 200, 50);
		pasteleria = new JButton("Pastelería");
		pasteleria.setBounds(0, 0, 200, 50);
		cocina = new JButton("Cocina");
		cocina.setBounds(0, 0, 200, 50);
		
		miCarro = new JButton("Mi Carro");
		miCarro.setBounds(0, 0, 200, 50);
		perfil = new JButton("Perfil");
		perfil.setBounds(0, 0, 200, 50);
		
		textoInicio = new JLabel("Seleccione que clase de producto desea comprar, por favor:");
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cliente Inicio");
		setSize(600, 500);
		setLayout(new GridLayout(3, 5));
		setVisible(true);
		
	}
}
