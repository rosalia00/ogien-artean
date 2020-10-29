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
	
	//Paneles
	JPanel arriba;
	JPanel centro;
	JPanel abajo;
	JPanel vacio;
	
	public VentanaClienteInicio() {
		
		panaderia = new JButton("Panadería");
		pasteleria = new JButton("Pastelería");
		cocina = new JButton("Cocina");
		
		miCarro = new JButton("Mi Carro");
		perfil = new JButton("Perfil");
		
		textoInicio = new JLabel("Seleccione que clase de producto desea comprar, por favor:");
		
		arriba = new JPanel();
		centro = new JPanel();
		abajo = new JPanel();
		
		abajo.add(panaderia);
		abajo.add(pasteleria);
		abajo.add(cocina);
		centro.add(textoInicio);
		arriba.add(miCarro);
		arriba.add(perfil);
		
		add(arriba);
		add(centro);
		add(abajo);
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cliente Inicio");
		setSize(600, 300);
		setLayout(new GridLayout(3, 1, 0, 0));

		setVisible(true);
		
	}
}
