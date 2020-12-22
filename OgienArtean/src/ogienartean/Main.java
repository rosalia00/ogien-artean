package ogienartean;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import ventanas.*;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileHandler fH = new FileHandler("MyLogFile.log", 8096, 1, false);
			for (Handler handler : logger.getHandlers()) {
				logger.removeHandler(handler);
			}
			SimpleFormatter formatter = new SimpleFormatter();  
			fH.setFormatter(formatter);
			logger.addHandler(fH);


		} catch (Exception e) {
			e.printStackTrace();
		}
		//VentanaCrearCliente as = new VentanaCrearCliente();
		//VentanaCrearEmpleado asd = new VentanaCrearEmpleado();
		//VentanaLoginEmpleado i = new VentanaLoginEmpleado();
		//VentanaLoginCliente i = new VentanaLoginCliente();
		//VentanaMiCarro f = new VentanaMiCarro();
		//VentanaCompra d = new VentanaCompra();
		VentanaClienteConfirmacionCompra z = new VentanaClienteConfirmacionCompra(logger);
		//VentanaEmpleadoAdministrar c = new VentanaEmpleadoAdministrar();
		//VentanaEmpleadoInicio v = new VentanaEmpleadoInicio();
		//VentanaEmpleadoPedidos c = new VentanaEmpleadoPedidos();
		//VentanaClienteInicio a = new VentanaClienteInicio();
		//VentanaPerfil a = new VentanaPerfil();
		//VentanaInicio i = new VentanaInicio();
		
	}
	
}
