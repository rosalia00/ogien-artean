package ventanas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaMiCarro extends JFrame {
	
	JButton volver;
	JButton nombre;
	JTextPane coso;
	JButton comprar;
	
	JPanel abajo;
	
	public VentanaMiCarro() {
		
		nombre = new JButton();
		nombre.setIcon(new ImageIcon("imagenes/carro.png"));
		nombre.setContentAreaFilled(false);
		nombre.setBorderPainted(false);
		nombre.setFocusPainted(false);
		
		coso = new JTextPane();
		
		volver  = new JButton();
		volver.setIcon(new ImageIcon("imagenes/volver.png"));
		volver.setContentAreaFilled(false);
		volver.setBorderPainted(false);
		volver.setFocusPainted(false);
		
		comprar = new JButton();
		comprar.setIcon(new ImageIcon("imagenes/comprar.png"));
		comprar.setContentAreaFilled(false);
		comprar.setBorderPainted(false);
		comprar.setFocusPainted(false);
		comprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaClienteConfirmacionCompra();
				dispose();
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
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat.png"));
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("MI CARRO");
		setSize(550, 550);
		setLayout(new GridLayout(3, 1));
		setVisible(true);
		setResizable(false);
		
	}
	
	
}
