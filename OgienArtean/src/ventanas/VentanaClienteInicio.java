package ventanas;
import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

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
	
	private static Logger logger = Logger.getLogger(VentanaClienteInicio.class.getName());
	
	public VentanaClienteInicio() {
		
		panaderia = new JButton();
		panaderia.setContentAreaFilled(false);
		panaderia.setBorderPainted(false);
		panaderia.setFocusPainted(false);
		panaderia.setIcon(new ImageIcon("imagenes/panaderia.png"));
		panaderia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCompra a = new VentanaCompra();
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton panaderia.");
			}
		});
		
		pasteleria = new JButton();
		pasteleria.setContentAreaFilled(false);
		pasteleria.setBorderPainted(false);
		pasteleria.setFocusPainted(false);
		pasteleria.setIcon(new ImageIcon("imagenes/pasteleria.png"));
		pasteleria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCompra a = new VentanaCompra();
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton pasteleria.");
			}
		});
		
		cocina = new JButton();
		cocina.setContentAreaFilled(false);
		cocina.setBorderPainted(false);
		cocina.setFocusPainted(false);
		cocina.setIcon(new ImageIcon("imagenes/cocina.png"));
		cocina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCompra a = new VentanaCompra();
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton cocina.");
			}
		});
		
		miCarro = new JButton();
		miCarro.setContentAreaFilled(false);
		miCarro.setBorderPainted(false);
		miCarro.setFocusPainted(false);
		miCarro.setIcon(new ImageIcon("imagenes/carro.png"));
		miCarro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaMiCarro a = new VentanaMiCarro();
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton mi carro.");
			}
		});
		
		perfil = new JButton();
		perfil.setContentAreaFilled(false);
		perfil.setBorderPainted(false);
		perfil.setFocusPainted(false);
		perfil.setIcon(new ImageIcon("imagenes/perfil.png"));
		perfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPerfil a = new VentanaPerfil();
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton perfil.");
			}
		});
		
		textoInicio = new JLabel("Seleccione que clase de producto desea comprar, por favor:");
		
		arriba = new JPanel();
		arriba.setOpaque(false);
		centro = new JPanel();
		centro.setOpaque(false);
		abajo = new JPanel();
		abajo.setOpaque(false);
		
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));
		
		abajo.add(panaderia);
		abajo.add(pasteleria);
		abajo.add(cocina);
		centro.add(textoInicio);
		arriba.add(miCarro);
		arriba.add(perfil);
		
		add(arriba);
		add(centro);
		add(abajo);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("INICIO");
		setSize(1000, 600);
		setLayout(new GridLayout(3, 1, 0, 0));
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}
}
