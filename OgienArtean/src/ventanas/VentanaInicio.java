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

public class VentanaInicio extends JFrame {

	JButton cliente;
	JButton empleado;

	public VentanaInicio(Logger logger, Connection conn, Statement stmt) {

		cliente = new JButton();
		cliente.setContentAreaFilled(false);
		cliente.setBorderPainted(false);
		cliente.setFocusPainted(false);
		cliente.setIcon(new ImageIcon("imagenes/cliente.png"));
		cliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaIdentif a = new VentanaIdentif("cliente", logger, conn, stmt);
				logger.log(Level.INFO, "Ha funcionado el boton cliente.");
				dispose();
			}
		});

		empleado = new JButton();
		empleado.setContentAreaFilled(false);
		empleado.setBorderPainted(false);
		empleado.setFocusPainted(false);
		empleado.setIcon(new ImageIcon("imagenes/empleado.png"));
		empleado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaIdentif a = new VentanaIdentif("empleado", logger, conn, stmt);
				logger.log(Level.INFO, "Ha funcionado el boton empleado.");
				dispose();
			}
		});

		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));

		add(cliente);
		add(empleado);

		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("INICIO");
		setSize(500, 400);
		setLayout(new GridLayout(1, 2));
		setLocationRelativeTo(null);

		setVisible(true);
	}

}
