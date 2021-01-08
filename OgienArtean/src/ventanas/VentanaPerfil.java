package ventanas;

import java.awt.*;

import java.awt.event.*;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

import java.io.*;
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

		titulo = new JButton();
		titulo.setIcon(new ImageIcon("imagenes/miperfil.png"));
		titulo.setContentAreaFilled(false);
		titulo.setBorderPainted(false);
		titulo.setFocusPainted(false);
		tituloPanel.add(titulo);
		
		try {
			String instruccion = "SELECT * FROM CLIENTE WHERE DNI = " + dni;
			ResultSet rs = stmt.executeQuery(instruccion);

			String nomap = "    " + rs.getString("NOMBRE") + " " + rs.getString("APELLIDO");
			nombreYApellidos =  new JLabel(nomap);
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
