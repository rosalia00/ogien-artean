package ventanas;

import java.awt.*;

import java.awt.event.*;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.*;

public class VentanaInicio extends JFrame {

	JButton cliente;
	JButton empleado;

	public VentanaInicio(Logger logger, Connection conn, Statement stmt) {

		URL iconURL4 = getClass().getResource("/cliente.png");

		cliente = new JButton();
		cliente.setContentAreaFilled(false);
		cliente.setBorderPainted(false);
		cliente.setFocusPainted(false);
		cliente.setIcon(new ImageIcon(iconURL4));
		cliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaIdentif a = new VentanaIdentif("cliente", logger, conn, stmt);
				logger.log(Level.INFO, "Ha funcionado el boton cliente.");
				dispose();
			}
		});

		URL iconURL3 = getClass().getResource("/empleado.png");

		empleado = new JButton();
		empleado.setContentAreaFilled(false);
		empleado.setBorderPainted(false);
		empleado.setFocusPainted(false);
		empleado.setIcon(new ImageIcon(iconURL3));
		empleado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaIdentif a = new VentanaIdentif("empleado", logger, conn, stmt);
				logger.log(Level.INFO, "Ha funcionado el boton empleado.");
				dispose();
			}
		});

		URL iconURL = getClass().getResource("/fondo3.png");

		setContentPane(new JLabel(new ImageIcon(iconURL)));

		add(cliente);
		add(empleado);

		URL iconURL2 = getClass().getResource("/octocat1.png");

		setIconImage(Toolkit.getDefaultToolkit().getImage(iconURL2));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("INICIO");
		setSize(500, 400);
		setLayout(new GridLayout(1, 2));
		setLocationRelativeTo(null);

		setVisible(true);
	}

}
