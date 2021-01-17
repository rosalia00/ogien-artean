package ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class VentanaEmpleadoPedidos extends JFrame {

	// Boton atras
	JButton atras;

	// Botones pedidos
	JLabel pedido0;
	JButton confirmar0;

	// Paneles
	JPanel arriba;
	JPanel centro;
	JPanel abajo;

	public VentanaEmpleadoPedidos(Logger logger, Connection conn, Statement stmt) {

		URL iconURL1 = getClass().getResource("/volver.png");
		// Boton atras
		atras = new JButton();
		atras.setIcon(new ImageIcon(iconURL1));
		atras.setContentAreaFilled(false);
		atras.setBorderPainted(false);
		atras.setFocusPainted(false);
		atras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaEmpleadoInicio(logger, conn, stmt);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton volver.");
			}
		});

		// Paneles
		// Panel Arriba
		arriba = new JPanel();
		arriba.setOpaque(false);

		// Panel centro
		centro = new JPanel();
		centro.setOpaque(false);
		centro.setSize(new Dimension(500, 300));

		// Creacion Tabla
		JTable tablaPedidos = new JTable(new DefaultTableModel(new Object[] { "DNI", "PEDIDO" }, 0));
		tablaPedidos.setPreferredScrollableViewportSize(new Dimension(500, 300));
		DefaultTableModel model = (DefaultTableModel) tablaPedidos.getModel();
		tablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(80);
		tablaPedidos.getColumnModel().getColumn(1).setPreferredWidth(700);
		String[] nomCol = { "DNI", "PEDIDO" };
		tablaPedidos.getColumn("DNI").setResizable(true);
		tablaPedidos.getColumn("DNI").setMaxWidth(70);
		model.addRow(nomCol);

		try {

			ResultSet rs = stmt.executeQuery("Select * from PEDIDO");

			while (rs.next()) {

				String dniGuardado = rs.getString("DNI");
				String pedidoGuardado = rs.getString("PEDIDO");

				Object[] cosos = { dniGuardado, pedidoGuardado };
				model.addRow(cosos);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		tablaPedidos.setEnabled(false);

		// Panel SemiAbajo
		JPanel semiabajo = new JPanel();
		semiabajo.setOpaque(false);
		File archivo = new File("tabla.csv");

		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		URL iconURL2 = getClass().getResource("/descargar.png");

		JButton botonDescargar = new JButton();
		botonDescargar.setIcon(new ImageIcon(iconURL2));
		botonDescargar.setContentAreaFilled(false);
		botonDescargar.setBorderPainted(false);
		botonDescargar.setFocusPainted(false);
		botonDescargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					PrintStream ps = new PrintStream(archivo);

					for (int i = 0; i < model.getRowCount(); i++) {
						for (int j = 0; j < model.getColumnCount(); j++) {
							ps.print(model.getValueAt(i, j));
							ps.print(";");
						}
						ps.println("");
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Se ha descargado la tabla.");

			}
		});
		semiabajo.add(botonDescargar);

		// Panel Abajo
		abajo = new JPanel();
		abajo.setOpaque(false);

		// Añadir a paneles atras
		centro.add(tablaPedidos);
		abajo.add(atras);

		URL iconURL3 = getClass().getResource("/fondo3.png");
		// Fondo
		setContentPane(new JLabel(new ImageIcon(iconURL3)));

		// Añadir paneles
		add(arriba);
		add(centro);
		add(semiabajo);
		add(abajo);

		URL iconURL4 = getClass().getResource("/octocat1.png");

		// Icono de pagina
		setIconImage(Toolkit.getDefaultToolkit().getImage(iconURL4));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("PEDIDOS");
		setSize(850, 500);
		setLayout(new GridLayout(4, 1));
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(true);

	}

}
