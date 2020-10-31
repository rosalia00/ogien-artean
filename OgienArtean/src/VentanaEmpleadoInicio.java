import java.awt.GridLayout;
import javax.swing.*;

public class VentanaEmpleadoInicio extends JFrame {
	//Botones opciones de empleado
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
		
		//Boton horas
		horas = new JButton();
			horas.setIcon(new ImageIcon("horas.png"));
			horas.setContentAreaFilled(false);
			horas.setBorderPainted(false);
			horas.setFocusPainted(false);
		
		//Boton perfil
		perfil = new JButton();
			perfil.setIcon(new ImageIcon("perfil.png"));
			perfil.setContentAreaFilled(false);
			perfil.setBorderPainted(false);
			perfil.setFocusPainted(false);
		
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
		setSize(1000, 600);
		setLayout(new GridLayout(2,1));
		
		setVisible(true);
	}
}
