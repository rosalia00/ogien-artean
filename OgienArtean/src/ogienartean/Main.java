package ogienartean;

import java.io.File;
import java.net.URL;
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

			VentanaInicio i = new VentanaInicio(logger, conn, stmt);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
