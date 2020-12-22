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
		//LOGGER
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
		
		//VENTANAS
		//VentanaClienteConfirmacionCompra z = new VentanaClienteConfirmacionCompra(logger);
		//VentanaClienteInicio a = new VentanaClienteInicio(logger);
		//VentanaCompra d = new VentanaCompra(logger);
		//VentanaCrearCliente as = new VentanaCrearCliente(logger);
		//VentanaCrearEmpleado asd = new VentanaCrearEmpleado(logger);
		
		//VentanaLoginEmpleado i = new VentanaLoginEmpleado();
		//VentanaLoginCliente i = new VentanaLoginCliente();
		//VentanaMiCarro f = new VentanaMiCarro();
		//VentanaEmpleadoAdministrar c = new VentanaEmpleadoAdministrar();
		//VentanaEmpleadoInicio v = new VentanaEmpleadoInicio();
		//VentanaEmpleadoPedidos c = new VentanaEmpleadoPedidos();
		//VentanaPerfil a = new VentanaPerfil();
		//VentanaInicio i = new VentanaInicio();
		
	}
	
}
