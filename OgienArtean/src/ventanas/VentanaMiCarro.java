package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Logger;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.*;

public class VentanaMiCarro extends JFrame {

	JButton volver;
	JButton nombre;
	JTextPane coso;
	JButton comprar;

	JPanel abajo;

	public VentanaMiCarro(Logger logger, ArrayList<String> tickets, String dni, Connection conn, Statement stmt) {

		nombre = new JButton();
		nombre.setIcon(new ImageIcon("imagenes/carro.png"));
		nombre.setContentAreaFilled(false);
		nombre.setBorderPainted(false);
		nombre.setFocusPainted(false);

		coso = new JTextPane();
		coso.setEnabled(false);
		for (String ticket : tickets) {
			String texto = coso.getText() + "\n" + ticket;
			coso.setText(texto);
		}

		volver = new JButton();
		volver.setIcon(new ImageIcon("imagenes/volver.png"));
		volver.setContentAreaFilled(false);
		volver.setBorderPainted(false);
		volver.setFocusPainted(false);
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = null;
				try {
					new VentanaCompra(s, logger, tickets, dni, conn, stmt);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		comprar = new JButton();
		comprar.setIcon(new ImageIcon("imagenes/comprar.png"));
		comprar.setContentAreaFilled(false);
		comprar.setBorderPainted(false);
		comprar.setFocusPainted(false);
		comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaClienteConfirmacionCompra(logger, tickets, dni, conn, stmt);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton comprar.");
			}
		});

		abajo = new JPanel();
		abajo.setOpaque(false);

		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));

		abajo.add(volver);
		abajo.add(comprar);
		add(nombre);
		add(coso);
		add(abajo);

		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("CARRO");
		setSize(550, 550);
		setLayout(new GridLayout(3, 1));
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

	}
}
