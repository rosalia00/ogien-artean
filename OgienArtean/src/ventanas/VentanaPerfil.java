package ventanas;
import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class VentanaPerfil extends JFrame{
	
	JPanel tituloPanel;
	JLabel titulo;
	
	JLabel nombreYApellidos;
	JLabel direccion;
	JLabel cuenta;
	
	JPanel datos;
	JPanel pedidos;
	
	JButton pedidoComun;
	
	JOptionPane confirmar;
	public VentanaPerfil() {
		tituloPanel = new JPanel();
		tituloPanel.setOpaque(false);
		
		titulo = new JLabel("Mi Perfil");
		tituloPanel.add(titulo);
		
		nombreYApellidos = new JLabel("BD");
		direccion = new JLabel("BD");
		cuenta = new JLabel("BD");
		
		datos = new JPanel();
		datos.add(nombreYApellidos);
		datos.add(direccion);
		datos.add(cuenta);
		datos.setOpaque(false);
		
		pedidos = new JPanel();
		pedidos.setOpaque(false);
		
		int n = 0;
		for (int i = 0; i < 3; i++) {
			n +=1;
			pedidoComun = new JButton("BD" + n);
			pedidoComun.setBorderPainted(false);
			pedidoComun.setFocusPainted(false);
			pedidos.add(pedidoComun);
			pedidoComun.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					confirmar = new JOptionPane();
					confirmar.showConfirmDialog(pedidoComun, "¿Quieres añadir este pedido a tu carro?:");
				}
			});
		}
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));
		add(tituloPanel);
		add(datos);
		add(pedidos);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Mi Perfil");
		setSize(300, 400);
		setLayout(new GridLayout(3, 1));
		setVisible(true);
	}
}
