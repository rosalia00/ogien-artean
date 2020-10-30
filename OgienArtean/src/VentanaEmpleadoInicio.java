import java.awt.GridLayout;
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
		
		horas = new JButton("HORAS");
		perfil = new JButton("PERFIL");
		
		arriba = new JPanel();
		abajo = new JPanel();
		
		arriba.add(horas);
		arriba.add(perfil);
		abajo.add(administrar);
		abajo.add(pedidos);
		abajo.add(registro);
		
		add(arriba);
		add(abajo);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Empleado Inicio");
		setSize(600, 300);
		setLayout(new GridLayout(2,1));
		
		setVisible(true);
	}
}
