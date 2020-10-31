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

	public VentanaClienteConfirmacionCompra() {

		carro = new JButton();
		carro.setIcon(new ImageIcon("carro.png"));
		carro.setContentAreaFilled(false);
		carro.setBorderPainted(false);
		carro.setFocusPainted(false);
		
		perfil = new JButton();
		perfil.setIcon(new ImageIcon("perfil.png"));
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
		cancelar.setIcon(new ImageIcon("cancelar.png"));
		cancelar.setContentAreaFilled(false);
		cancelar.setBorderPainted(false);
		cancelar.setFocusPainted(false);
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelarSeguro = new JOptionPane();
				cancelarSeguro.showConfirmDialog(null, "�QUIERE CANCELAR EL PEDIDO?", "CANCELAR", JOptionPane.YES_NO_OPTION);

			}
		});
		
		confirmar = new JButton();
		confirmar.setIcon(new ImageIcon("confirmar.png"));
		confirmar.setContentAreaFilled(false);
		confirmar.setBorderPainted(false);
		confirmar.setFocusPainted(false);
		

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
		
		setContentPane(new JLabel(new ImageIcon("fondo3.png")));

		add(arriba);
		add(centro);
		add(abajo);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("octocat.png"));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Confirmaci�n compra");
		setSize(1500, 800);
		setLayout(new GridLayout(3, 1, 0, 0));
		setResizable(false);
		setVisible(true);

	}

}
