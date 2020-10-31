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
		panaderia.setContentAreaFilled(false);
		panaderia.setBorderPainted(false);
		panaderia.setFocusPainted(false);
		panaderia.setIcon(new ImageIcon("panaderia.png"));
		panaderia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCompra a = new VentanaCompra();
				dispose();
				
			}
		});
		
		pasteleria = new JButton("Pastelería");
		pasteleria.setContentAreaFilled(false);
		pasteleria.setBorderPainted(false);
		pasteleria.setFocusPainted(false);
		pasteleria.setIcon(new ImageIcon("pasteleria.png"));
		pasteleria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCompra a = new VentanaCompra();
				dispose();
				
			}
		});
		
		cocina = new JButton("Cocina");
		cocina.setContentAreaFilled(false);
		cocina.setBorderPainted(false);
		cocina.setFocusPainted(false);
		cocina.setIcon(new ImageIcon("cocina.png"));
		cocina.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCompra a = new VentanaCompra();
				dispose();
			}
		});
		
		miCarro = new JButton();
		miCarro.setContentAreaFilled(false);
		miCarro.setBorderPainted(false);
		miCarro.setFocusPainted(false);
		miCarro.setIcon(new ImageIcon("carro.png"));
		miCarro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaMiCarro a = new VentanaMiCarro();
				dispose();
				
			}
		});
		
		perfil = new JButton();
		perfil.setContentAreaFilled(false);
		perfil.setBorderPainted(false);
		perfil.setFocusPainted(false);
		perfil.setIcon(new ImageIcon("perfil1.png"));
		perfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentanaPerfil a = new VentanaPerfil();
				dispose();
				
			}
		});
		
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
