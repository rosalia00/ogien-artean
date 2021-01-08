package ventanas;

import java.awt.*;

import java.awt.event.*;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

import java.io.*;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.*;

public class VentanaPerfil extends JFrame {

	JPanel tituloPanel;
	JButton titulo;

	JLabel nombreYApellidos;
	JLabel direccion;
	JLabel cuenta;

	JPanel datos;

	JOptionPane confirmar;

	public VentanaPerfil(Logger logger, Connection conn, Statement stmt) {
		tituloPanel = new JPanel();
		tituloPanel.setOpaque(false);

		titulo = new JButton();
		titulo.setIcon(new ImageIcon("imagenes/miperfil.png"));
		titulo.setContentAreaFilled(false);
		titulo.setBorderPainted(false);
		titulo.setFocusPainted(false);
		tituloPanel.add(titulo);

		nombreYApellidos = new JLabel("BD");
		direccion = new JLabel("BD");
		cuenta = new JLabel("BD");

		datos = new JPanel();
		datos.add(nombreYApellidos);
		datos.add(direccion);
		datos.add(cuenta);
		datos.setOpaque(false);


		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));
		add(tituloPanel);
		add(datos);

		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("PERFIL");
		setSize(300, 400);
		setLayout(new GridLayout(3, 1));
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
