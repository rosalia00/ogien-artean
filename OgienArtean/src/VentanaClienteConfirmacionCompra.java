import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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

	public VentanaClienteConfirmacionCompra() {

		carro = new JButton();
		carro.setIcon(new ImageIcon("imagenes/carro.png"));
		carro.setContentAreaFilled(false);
		carro.setBorderPainted(false);
		carro.setFocusPainted(false);
		carro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMiCarro();
				dispose();
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
				new VentanaPerfil();
				dispose();
			}
		});
		
		coso = new JTextPane();
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
					new VentanaClienteInicio();
					dispose();
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
				gracias  = new JOptionPane();
				gracias.setFocusable(false);
				gracias.showMessageDialog(null, "¡Gracias por comprar en OGIEN ARTEAN!");
				dispose();
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
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat.png"));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Confirmación compra");
		setSize(1000, 600);
		setLayout(new GridLayout(3, 1, 0, 0));
		setResizable(false);
		setVisible(true);

	}

}
