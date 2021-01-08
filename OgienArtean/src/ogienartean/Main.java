package ogienartean;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.dbutils.DbUtils;

import ventanas.*;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {

		// LOGGER
		try {
			FileHandler fH = new FileHandler("logs/MyLogFile.log", 8096, 1, true);
			for (Handler handler : logger.getHandlers()) {
				logger.removeHandler(handler);
			}
			SimpleFormatter formatter = new SimpleFormatter();
			fH.setFormatter(formatter);
			logger.addHandler(fH);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
			Statement stmt = (Statement) conn.createStatement();

			// ArrayList<String> tickets = new ArrayList();
			// VENTANAS
			// VentanaClienteConfirmacionCompra z = new
			// VentanaClienteConfirmacionCompra(logger);
			// VentanaClienteInicio a = new VentanaClienteInicio(logger, tickets);
			// VentanaCompra d = new VentanaCompra(logger);
			// VentanaCrearCliente as = new VentanaCrearCliente(logger);
			// VentanaCrearEmpleado asd = new VentanaCrearEmpleado(logger);
			// VentanaEmpleadoAdministrar c = new VentanaEmpleadoAdministrar(logger, conn,
			// stmt);
			// VentanaEmpleadoInicio v = new VentanaEmpleadoInicio(logger);
			 VentanaEmpleadoPedidos c = new VentanaEmpleadoPedidos(logger, conn, stmt);
			// VentanaIdentif d = new VentanaIdentif(logger);
			//VentanaInicio i = new VentanaInicio(logger, conn, stmt);
			// VentanaLoginCliente i = new VentanaLoginCliente(logger);
			// VentanaLoginEmpleado i = new VentanaLoginEmpleado(logger);
			// VentanaMiCarro f = new VentanaMiCarro(logger);
			// VentanaPerfil a = new VentanaPerfil(logger);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
