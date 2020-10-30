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
	
	JButton pedidoComun;
	
	public MiPerfil() {
		titulo = new JLabel("Mi Perfil");
		
		nombreYApellidos = new JLabel("BD");
		direccion = new JLabel("BD");
		cuenta = new JLabel("BD");
		
		datos = new JPanel();
		
		for (int i = 0; i < 3; i++) {
			pedidoComun = new JButton("BD");
			datos.add(pedidoComun);
			pedidoComun.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
		}
	}
}
