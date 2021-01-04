package ventanas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import java.util.ArrayList;
import java.util.logging.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

public class VentanaClienteConfirmacionCompra extends JFrame {

	JButton carro;
	JButton perfil;
	JTextPane coso;
	JButton cancelar;
	JButton confirmar;
	JPanel arriba;
	JPanel centro;
	JPanel abajo;
	
	JOptionPane cancelarSeguro;
	JOptionPane gracias;
	
	
	public VentanaClienteConfirmacionCompra(Logger logger, ArrayList<String> tickets, String dni) {
		
		carro = new JButton();
		carro.setIcon(new ImageIcon("imagenes/carro.png"));
		carro.setContentAreaFilled(false);
		carro.setBorderPainted(false);
		carro.setFocusPainted(false);
		carro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMiCarro(logger, tickets, dni);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton carro.");
			}
		});
		
		perfil = new JButton();
		perfil.setIcon(new ImageIcon("imagenes/perfil.png"));
		perfil.setContentAreaFilled(false);
		perfil.setBorderPainted(false);
		perfil.setFocusPainted(false);
		perfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaPerfil(logger);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton perfil.");
			}
		});
		
		coso = new JTextPane();
		for (String ticket : tickets) {
			String texto = coso.getText() + "\n" + ticket;
			coso.setText(texto);
		}
		
		cancelar = new JButton();
		cancelar.setIcon(new ImageIcon("imagenes/cancelar.png"));
		cancelar.setContentAreaFilled(false);
		cancelar.setBorderPainted(false);
		cancelar.setFocusPainted(false);
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelarSeguro = new JOptionPane();
				int respuesta = cancelarSeguro.showConfirmDialog(null, "¿QUIERE CANCELAR EL PEDIDO?", "CANCELAR", JOptionPane.YES_NO_OPTION);
				if (respuesta == cancelarSeguro.YES_OPTION) {
					new VentanaClienteInicio(logger, tickets, dni);
					dispose();
					logger.log(Level.INFO, "Ha funcionado el boton cancelar.");
				}
			}
		});
		
		confirmar = new JButton();
		confirmar.setIcon(new ImageIcon("imagenes/confirmar.png"));
		confirmar.setContentAreaFilled(false);
		confirmar.setBorderPainted(false);
		confirmar.setFocusPainted(false);
		confirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.sqlite.JDBC");
					Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
					Statement stmt = conn.createStatement();
					
					String ticket = "";
					for (String string : tickets) {
						ticket = ticket + string;
					}
					System.out.println("INSERT INTO PEDIDO VALUES("+ dni +", '"+ ticket +"');");
					stmt.executeUpdate("INSERT INTO PEDIDO VALUES("+ dni +", '"+ ticket +"');");
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				gracias  = new JOptionPane();
				gracias.setFocusable(false);
				gracias.showMessageDialog(null, "¡Gracias por comprar en OGIEN ARTEAN!");
				ArrayList<String> vacio = new ArrayList<String>();
				VentanaClienteInicio v = new VentanaClienteInicio(logger, vacio, dni);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton confirmar.");
			}
		});
		

		arriba = new JPanel();
		arriba.setOpaque(false);
		centro = new JPanel();
		centro.setOpaque(false);
		abajo = new JPanel();
		abajo.setOpaque(false);

		arriba.add(carro);
		arriba.add(perfil);
		centro.add(coso);
		abajo.add(cancelar);
		abajo.add(confirmar);
		
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));

		add(arriba);
		add(centro);
		add(abajo);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("CONFIRMAR");
		setSize(800, 600);
		setLayout(new GridLayout(3, 1, 0, 0));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
