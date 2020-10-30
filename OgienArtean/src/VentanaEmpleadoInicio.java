import javax.swing.*;

public class VentanaEmpleadoInicio extends JFrame {
	//Botonees opciones de empleado
	JButton administrar;
	JButton pedidos;
	JButton registro;
	
	//Botones de perfil del empleado
	JButton horas;
	JButton perfil;
	
	//Paneles
	JPanel arriba;
	JPanel abajo;
	
	public VentanaEmpleadoInicio() {
		administrar = new JButton("Administrar");
		pedidos = new JButton("Pedidos");
		registro = new JButton("Registro");
		
		horas = new JButton("Horas");
		perfil = new JButton("Perfil");
		
		arriba = new JPanel();
		abajo = new JPanel();
		
		arriba.add(horas);
		arriba.add(perfil);
		abajo.add(administrar);
		abajo.add(pedidos);
		abajo.add(registro);
		
		add(arriba);
		add(abajo);
		
	}
}
