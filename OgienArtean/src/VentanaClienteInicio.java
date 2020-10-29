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
		pasteleria = new JButton("Pastelería");
		cocina = new JButton("Cocina");
		
		miCarro = new JButton("Mi Carro");
		perfil = new JButton("Perfil");
		
		textoInicio = new JLabel("Seleccione que clase de producto desea comprar por favor:");
	}
}
