package ventanas;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		// Boton administrar
		administrar = new JButton();
		administrar.setIcon(new ImageIcon("imagenes/administracion.png"));
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

		// Boton pedidos
		pedidos = new JButton();
		pedidos.setIcon(new ImageIcon("imagenes/pedidos.png"));
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

		// Fondo
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));

		// Añadir a los panels
		abajo.add(pedidos);
		abajo.add(administrar);

		// Añadir a la pagina
		add(abajo);

		// Icono de paginas
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));

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
