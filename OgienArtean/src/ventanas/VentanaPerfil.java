package ventanas;

import java.awt.*;

import java.awt.event.*;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import ogienartean.Cliente;

public class VentanaPerfil extends JFrame {

	JPanel tituloPanel;
	JButton titulo;

	JLabel nombreYApellidos;
	JLabel direccion;
	JLabel cuenta;

	JPanel datos;

	JOptionPane confirmar;

	public VentanaPerfil(Logger logger, Connection conn, Statement stmt, String dni) {
		tituloPanel = new JPanel();
		tituloPanel.setOpaque(false);

		URL iconURL = getClass().getResource("/miperfil.png");

		titulo = new JButton();
		titulo.setIcon(new ImageIcon(iconURL));
		titulo.setContentAreaFilled(false);
		titulo.setBorderPainted(false);
		titulo.setFocusPainted(false);
		tituloPanel.add(titulo);

		try {
			String instruccion = "SELECT * FROM CLIENTE WHERE DNI = " + dni;
			ResultSet rs = stmt.executeQuery(instruccion);

			String nomap = "    " + rs.getString("NOMBRE") + " " + rs.getString("APELLIDO");
			nombreYApellidos = new JLabel(nomap);
			String direcc = "    " + rs.getString("DIRECCION");
			direccion = new JLabel(direcc);
			String cuen = "    " + rs.getString("USUARIO");
			cuenta = new JLabel(cuen);

		} catch (Exception e) {
			// TODO: handle exception
		}

		datos = new JPanel();
		datos.setLayout(new GridLayout(3, 1, 5, 5));
		datos.add(nombreYApellidos);
		datos.add(direccion);
		datos.add(cuenta);
		datos.setOpaque(true);

		URL iconURL2 = getClass().getResource("/fondo3.png");

		setContentPane(new JLabel(new ImageIcon(iconURL2)));
		add(tituloPanel);
		add(datos);

		URL iconURL3 = getClass().getResource("/octocat1.png");

		setIconImage(Toolkit.getDefaultToolkit().getImage(iconURL3));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("PERFIL");
		setSize(300, 400);
		setLayout(new GridLayout(3, 1));
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
