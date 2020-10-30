import java.awt.GridLayout;

import javax.swing.*;

public class VentanaCompra extends JFrame {

	JButton carro;
	JButton perfil;

	JButton item0;
	JLabel itemLabel0;
	JSpinner itemSpinner0;

	JButton comprar;

	JPanel arriba;
	JPanel centro;
	JPanel centro1;
	JPanel centro2;
	JPanel abajo;

	public VentanaCompra() {

		carro = new JButton("CARRO");
		perfil = new JButton("PERFIL");

		comprar = new JButton("COMPRAR");

		arriba = new JPanel();
		centro = new JPanel();
		centro.setLayout(new GridLayout(2, 1));
		centro1 = new JPanel();
		centro1.setLayout(new GridLayout(3, 1));
		centro2 = new JPanel();
		centro2.setLayout(new GridLayout(3, 1));
		abajo = new JPanel();

		arriba.add(carro);
		arriba.add(perfil);

		for (int i = 0; i <= 5; i++) {
			item0 = new JButton("COSO");
			itemLabel0 = new JLabel("NOMBRE COSO");
			itemSpinner0 = new JSpinner();

			centro1.add(item0);
			centro1.add(itemLabel0);
			centro1.add(itemSpinner0);
		}

		for (int i = 0; i <= 5; i++) {
			item0 = new JButton("COSO");
			itemLabel0 = new JLabel("NOMBRE COSO");
			itemSpinner0 = new JSpinner();

			centro2.add(item0);
			centro2.add(itemLabel0);
			centro2.add(itemSpinner0);
		}

		centro.add(centro1);
		centro.add(centro2);

		abajo.add(comprar);

		add(arriba);
		add(centro);
		add(abajo);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("COMPRA");
		setSize(600, 300);
		setLayout(new GridLayout(3, 1));
		setVisible(true);

	}

}
