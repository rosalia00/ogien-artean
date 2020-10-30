import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class MiPerfil extends JFrame{
	
	JLabel titulo;
	
	JLabel nombreYApellidos;
	JLabel direccion;
	JLabel cuenta;
	
	JPanel datos;
	JPanel pedidos;
	
	JButton pedidoComun;
	
	JOptionPane confirmar;
	public MiPerfil() {
		titulo = new JLabel("Mi Perfil");
		
		nombreYApellidos = new JLabel("BD");
		direccion = new JLabel("BD");
		cuenta = new JLabel("BD");
		
		datos = new JPanel();
		datos.add(nombreYApellidos);
		datos.add(direccion);
		datos.add(cuenta);
		
		pedidos = new JPanel();
		
		for (int i = 0; i < 3; i++) {
			pedidoComun = new JButton("BD");
			pedidos.add(pedidoComun);
			pedidoComun.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					confirmar = new JOptionPane();
					confirmar.showConfirmDialog(pedidoComun, "¿Quieres añadir este pedido a tu carro?");
				}
			});
		}
		
		add(titulo);
		add(datos);
		add(pedidos);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cliente Inicio");
		setSize(300, 600);
		setLayout(new FlowLayout());
		setVisible(true);
	}
}
