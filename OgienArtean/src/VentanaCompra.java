import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaCompra extends JFrame {

	JButton carro;
	JButton perfil;

	JButton item0;
	JLabel itemLabel0;
	JSpinner itemSpinner0;

	JButton comprar;
	JButton volver;

	JPanel arriba;
	JPanel centro0;
	JPanel centro1;
	JPanel centro2;
	JPanel centro00;
	JPanel centro11;
	JPanel centro22;

	JPanel abajo;

	public VentanaCompra() {

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

		comprar = new JButton();
		comprar.setIcon(new ImageIcon("comprar.png"));
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

		volver = new JButton();
		volver.setIcon(new ImageIcon("volver.png"));
		volver.setContentAreaFilled(false);
		volver.setBorderPainted(false);
		volver.setFocusPainted(false);
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaClienteInicio();
				dispose();
			}
		});

		arriba = new JPanel();
		arriba.setOpaque(false);
		centro0 = new JPanel();
		centro0.setLayout(new GridLayout(1, 6, 5, 0));
		centro0.setOpaque(false);
		centro1 = new JPanel();
		centro1.setLayout(new GridLayout(1, 6, 5, 0));
		centro1.setOpaque(false);
		centro2 = new JPanel();
		centro2.setLayout(new GridLayout(1, 6, 5, 0));
		centro2.setOpaque(false);

		centro00 = new JPanel();
		centro00.setLayout(new GridLayout(1, 6, 5, 0));
		centro00.setOpaque(false);
		centro11 = new JPanel();
		centro11.setLayout(new GridLayout(1, 6, 5, 0));
		centro11.setOpaque(false);
		centro22 = new JPanel();
		centro22.setLayout(new GridLayout(1, 6, 5, 0));
		centro22.setOpaque(false);
		abajo = new JPanel();
		abajo.setOpaque(false);

		arriba.add(carro);
		arriba.add(perfil);

		for (int i = 1; i <= 5; i++) {
			item0 = new JButton("COSO");
			item0.setOpaque(false);
			item0.setContentAreaFilled(false);
			item0.setBorderPainted(false);
			item0.setFocusPainted(false);
			itemLabel0 = new JLabel("NOMBRE COSO");
			itemSpinner0 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

			centro0.add(item0);
			centro1.add(itemLabel0);
			centro2.add(itemSpinner0);
		}

		for (int i = 1; i <= 5; i++) {
			item0 = new JButton("COSO");
			item0.setOpaque(false);
			item0.setContentAreaFilled(false);
			item0.setBorderPainted(false);
			item0.setFocusPainted(false);
			itemLabel0 = new JLabel("NOMBRE COSO");
			itemSpinner0 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

			centro00.add(item0);
			centro11.add(itemLabel0);
			centro22.add(itemSpinner0);
		}

		setContentPane(new JLabel(new ImageIcon("fondo3.png")));

		abajo.add(volver);
		abajo.add(comprar);

		add(arriba);
		add(centro0);
		add(centro1);
		add(centro2);
		add(centro00);
		add(centro11);
		add(centro22);
		add(abajo);

		setIconImage(Toolkit.getDefaultToolkit().getImage("octocat.png"));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("COMPRA");
		setSize(1000, 600);
		setLayout(new GridLayout(8, 1));
		setVisible(true);
		setResizable(false);

	}

}
