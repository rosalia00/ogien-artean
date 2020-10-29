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
	
	//JPaneles vacios para el orden del gridlayout
	JPanel vacio1;
	JPanel vacio2;
	JPanel vacio3;
	JPanel vacio4;
	JPanel vacio5;
	JPanel vacio6;
	JPanel vacio7;
	JPanel vacio8;
	JPanel vacio9;
	
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
		
		vacio1 = new JPanel();
		vacio2 = new JPanel();
		vacio3 = new JPanel();
		vacio4 = new JPanel();
		vacio5 = new JPanel();
		vacio6 = new JPanel();
		vacio7 = new JPanel();
		vacio8 = new JPanel();
		vacio9 = new JPanel();
		
		add(vacio1);
		add(vacio2);
		add(vacio3);
		add(miCarro);
		add(perfil);
		add(vacio4);
		add(textoInicio);
		add(vacio5);
		add(vacio6);
		add(vacio7);
		add(vacio8);
		add(panaderia);
		add(pasteleria);
		add(cocina);
		add(vacio9);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cliente Inicio");
		setSize(600, 500);
		setLayout(new GridLayout(3, 5));
		setVisible(true);
		
	}
}
