package ventanas;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.*;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.LogManager;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

import java.awt.event.*;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;

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

	public VentanaClienteInicio(Logger logger, ArrayList<String> tickets, String dni, Connection conn, Statement stmt) {

		URL iconURL1 = getClass().getResource("/panaderia.png");

		panaderia = new JButton();
		panaderia.setContentAreaFilled(false);
		panaderia.setBorderPainted(false);
		panaderia.setFocusPainted(false);
		panaderia.setIcon(new ImageIcon(iconURL1));
		panaderia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s = "pan";
				try {
					System.out.println(tickets);
					VentanaCompra a = new VentanaCompra(s, logger, tickets, dni, conn, stmt);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton panaderia.");
			}
		});

		URL iconURL2 = getClass().getResource("/pasteleria.png");

		pasteleria = new JButton();
		pasteleria.setContentAreaFilled(false);
		pasteleria.setBorderPainted(false);
		pasteleria.setFocusPainted(false);
		pasteleria.setIcon(new ImageIcon(iconURL2));
		pasteleria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s = "pasteleria";
				try {
					VentanaCompra a = new VentanaCompra(s, logger, tickets, dni, conn, stmt);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton pasteleria.");
			}
		});

		URL iconURL3 = getClass().getResource("/cocina.png");

		cocina = new JButton();
		cocina.setContentAreaFilled(false);
		cocina.setBorderPainted(false);
		cocina.setFocusPainted(false);
		cocina.setIcon(new ImageIcon(iconURL3));
		cocina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s = "comida";
				try {
					VentanaCompra a = new VentanaCompra(s, logger, tickets, dni, conn, stmt);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton cocina.");
			}
		});

		URL iconURL4 = getClass().getResource("/carro.png");

		miCarro = new JButton();
		miCarro.setContentAreaFilled(false);
		miCarro.setBorderPainted(false);
		miCarro.setFocusPainted(false);
		miCarro.setIcon(new ImageIcon(iconURL4));
		miCarro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaMiCarro a = new VentanaMiCarro(logger, tickets, dni, conn, stmt);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton mi carro.");
			}
		});

		URL iconURL5 = getClass().getResource("/perfil.png");

		perfil = new JButton();
		perfil.setContentAreaFilled(false);
		perfil.setBorderPainted(false);
		perfil.setFocusPainted(false);
		perfil.setIcon(new ImageIcon(iconURL5));
		perfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPerfil a = new VentanaPerfil(logger, conn, stmt, dni);
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

		URL iconURL6 = getClass().getResource("/fondo3.png");

		setContentPane(new JLabel(new ImageIcon(iconURL6)));

		abajo.add(panaderia);
		abajo.add(pasteleria);
		abajo.add(cocina);
		centro.add(textoInicio);
		arriba.add(miCarro);
		arriba.add(perfil);

		add(arriba);
		add(centro);
		add(abajo);

		URL iconURL7 = getClass().getResource("/octocat1.png");

		setIconImage(Toolkit.getDefaultToolkit().getImage(iconURL7));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("INICIO");
		setSize(1000, 600);
		setLayout(new GridLayout(3, 1, 0, 0));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}
}
