import java.awt.GridLayout;

import javax.swing.*;

public class VentanaMiCarro extends JFrame {
	
	JPanel volver;
	JPanel nombre;
	JTextPane coso;
	JButton comprar;
	
	JPanel arriba;
	
	public VentanaMiCarro() {
		
		volver  = new JPanel();
		nombre = new JPanel();
		coso = new JTextPane();
		comprar = new JButton();
		arriba = new JPanel();
		
		arriba.add(volver);
		arriba.add(nombre);
		add(arriba);
		add(coso);
		add(comprar);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Mi Perfil");
		setSize(550, 550);
		setLayout(new GridLayout(3, 1));
		setVisible(true);
		
	}
	
	
}
