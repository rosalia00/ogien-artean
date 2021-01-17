package ventanas;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;
import javax.swing.*;

public class VentanaEmpleadoInicio extends JFrame {
	// Botones opciones de empleado
	JButton administrar;
	JButton pedidos;

	// Botones de perfil del empleado
	JButton perfil;

	// Paneles
	JPanel abajo;

	public VentanaEmpleadoInicio(Logger logger, Connection conn, Statement stmt) {

		URL iconURL = getClass().getResource("/administracion.png");
		// Boton administrar
		administrar = new JButton();
		administrar.setIcon(new ImageIcon(iconURL));
		administrar.setContentAreaFilled(false);
		administrar.setBorderPainted(false);
		administrar.setFocusPainted(false);
		administrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaEmpleadoAdministrar(logger, conn, stmt);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton administrar.");
			}

		});

		URL iconURL2 = getClass().getResource("/pedidos.png");
		// Boton pedidos
		pedidos = new JButton();
		pedidos.setIcon(new ImageIcon(iconURL2));
		pedidos.setContentAreaFilled(false);
		pedidos.setBorderPainted(false);
		pedidos.setFocusPainted(false);
		pedidos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaEmpleadoPedidos(logger, conn, stmt);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton pedidos.");
			}
		});

		abajo = new JPanel();
		abajo.setOpaque(false);
		abajo.setLayout(new GridLayout(1, 32));

		URL iconURL3 = getClass().getResource("/fondo3.png");
		// Fondo
		setContentPane(new JLabel(new ImageIcon(iconURL3)));

		// Añadir a los panels
		abajo.add(pedidos);
		abajo.add(administrar);

		// Añadir a la pagina
		add(abajo);

		URL iconURL4 = getClass().getResource("/octocat1.png");
		// Icono de paginas
		setIconImage(Toolkit.getDefaultToolkit().getImage(iconURL4));

		// Final
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("INICIO");
		setSize(600, 300);
		setLayout(new GridLayout(1, 1));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
