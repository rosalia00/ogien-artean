package ventanas;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;
import javax.swing.*;

public class VentanaIdentif extends JFrame {

	JButton iniciarSesion;
	JButton registrarse;

	public VentanaIdentif(String d, Logger logger, Connection conn, Statement stmt) {

		URL iconURL1 = getClass().getResource("/iniciarSesion.png");

		iniciarSesion = new JButton();
		iniciarSesion.setContentAreaFilled(false);
		iniciarSesion.setBorderPainted(false);
		iniciarSesion.setFocusPainted(false);
		iniciarSesion.setIcon(new ImageIcon(iconURL1));
		iniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (d == "empleado") {
					VentanaLoginEmpleado a = new VentanaLoginEmpleado(logger, conn, stmt);
					logger.log(Level.INFO, "Se ha iniciado sesion como empleado.");
					dispose();
				} else if (d == "cliente") {
					VentanaLoginCliente b = new VentanaLoginCliente(logger, conn, stmt);
					logger.log(Level.INFO, "Se ha iniciado sesion como cliente.");
					dispose();
				}
			}
		});

		URL iconURL2 = getClass().getResource("/registrarse.png");

		registrarse = new JButton();
		registrarse.setContentAreaFilled(false);
		registrarse.setBorderPainted(false);
		registrarse.setFocusPainted(false);
		registrarse.setIcon(new ImageIcon(iconURL2));
		registrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (d == "empleado") {
					VentanaCrearEmpleado a = new VentanaCrearEmpleado(logger, conn, stmt);
					dispose();

					logger.log(Level.INFO, "Se ha registrado como empleado.");
				} else if (d == "cliente") {
					VentanaCrearCliente b = new VentanaCrearCliente(logger, conn, stmt);
					dispose();
					logger.log(Level.INFO, "Se ha registrado como cliente.");
				}
			}
		});

		URL iconURL3 = getClass().getResource("/fondo3.png");

		setContentPane(new JLabel(new ImageIcon(iconURL3)));

		add(iniciarSesion);
		add(registrarse);

		URL iconURL4 = getClass().getResource("/octocat1.png");

		setIconImage(Toolkit.getDefaultToolkit().getImage(iconURL4));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("INICIO");
		setSize(500, 400);
		setLayout(new GridLayout(1, 2));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

}
