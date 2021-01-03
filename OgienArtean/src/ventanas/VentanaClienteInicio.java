package ventanas;

import java.awt.*;
import java.util.logging.*;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.LogManager;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class VentanaClienteInicio extends JFrame {

	// Botones de compra
	JButton panaderia;
	JButton pasteleria;
	JButton cocina;

	// Botones de usuario
	JButton miCarro;
	JButton perfil;

	// Texto
	JLabel textoInicio;

	// Paneles
	JPanel arriba;
	JPanel centro;
	JPanel abajo;
	JPanel vacio;

	private String s;

	public VentanaClienteInicio(Logger logger) {

		panaderia = new JButton();
		panaderia.setContentAreaFilled(false);
		panaderia.setBorderPainted(false);
		panaderia.setFocusPainted(false);
		panaderia.setIcon(new ImageIcon("imagenes/panaderia.png"));
		panaderia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s = "pan";
				try {
					VentanaCompra a = new VentanaCompra(s, logger);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				s = "pasteleria";
				try {
					VentanaCompra a = new VentanaCompra(s, logger);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				s = "comida";
				try {
					VentanaCompra a = new VentanaCompra(s, logger);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				VentanaMiCarro a = new VentanaMiCarro(logger);
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
				VentanaPerfil a = new VentanaPerfil(logger);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton perfil.");
			}
		});

		textoInicio = new JLabel(
				"                                                                                                              Seleccione que clase de producto desea comprar, por favor:");
		textoInicio.setOpaque(true);

		arriba = new JPanel();
		arriba.setOpaque(false);
		centro = new JPanel();
		centro.setOpaque(true);
		centro.setLayout(new GridLayout(1, 1));
		abajo = new JPanel();
		abajo.setOpaque(false);
		abajo.setLayout(new GridLayout(1, 3));

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
		setResizable(false);
		setVisible(true);

	}
}
