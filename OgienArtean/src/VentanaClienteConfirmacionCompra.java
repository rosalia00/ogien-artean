import java.awt.*;

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

	public VentanaClienteConfirmacionCompra() {

		carro = new JButton("CARRO");
		perfil = new JButton("PERFIL");
		coso = new JTextPane();
		cancelar = new JButton("CANCELAR");
		confirmar = new JButton("CONFIRMAR");

		arriba = new JPanel();
		centro = new JPanel();
		abajo = new JPanel();

		arriba.add(carro);
		arriba.add(perfil);
		centro.add(coso);
		abajo.add(cancelar);
		abajo.add(confirmar);

		add(arriba);
		add(centro);
		add(abajo);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Confirmación compra");
		setSize(600, 300);
		setLayout(new GridLayout(3, 1, 0, 0));

		setVisible(true);

	}

}
