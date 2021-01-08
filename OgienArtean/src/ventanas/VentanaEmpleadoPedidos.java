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
	// Botones de perfil del empleado
	JButton perfil;

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
		// Botones de perfil del empleado
		// Boton perfil
		perfil = new JButton();
		perfil.setIcon(new ImageIcon("imagenes/perfil.png"));
		perfil.setContentAreaFilled(false);
		perfil.setBorderPainted(false);
		perfil.setFocusPainted(false);
		perfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaPerfil(logger, conn, stmt);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton perfil.");
			}
		});

		// Boton atras
		atras = new JButton();
		atras.setIcon(new ImageIcon("imagenes/volver.png"));
		atras.setContentAreaFilled(false);
		atras.setBorderPainted(false);
		atras.setFocusPainted(false);
		atras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaEmpleadoInicio(logger, conn, stmt);
				dispose();
				logger.log(Level.INFO, "Ha funcionado el boton atras.");
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
		centro.setLayout(new GridLayout(1, 1, 0, 6));
		JTable tablaPedidos = new JTable(new DefaultTableModel(new Object[] { "DNI", "PEDIDO" }, 0));
		tablaPedidos.setPreferredScrollableViewportSize(new Dimension(500, 300));
		DefaultTableModel model = (DefaultTableModel) tablaPedidos.getModel();
		String[] nomCol = { "DNI", "PEDIDO", "BORRAR" };
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

		JButton botonDescargar = new JButton("Descargar Tabla");
		botonDescargar.setIcon(new ImageIcon("imagenes/descargar.png"));
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

		// Añadir a paneles perfil, atras
		arriba.add(perfil);
		centro.add(tablaPedidos);
		abajo.add(atras);

		// Fondo
		setContentPane(new JLabel(new ImageIcon("imagenes/fondo3.png")));

		// Añadir paneles
		add(arriba);
		add(centro);
		add(semiabajo);
		add(abajo);

		// Icono de pagina
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/octocat1.png"));

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("PEDIDOS");
		setSize(1000, 600);
		setLayout(new GridLayout(4, 1));
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

	}

}
