package ogienartean;

import javax.swing.JButton;

public class Producto {
	String nombre;
	double precio;
	boolean celiaco;
	JButton boton;
	
	
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public boolean isCeliaco() {
		return celiaco;
	}
	
	public JButton getBoton() {
		return boton;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setCeliaco(boolean celiaco) {
		this.celiaco = celiaco;
	}
	public void setBoton(JButton boton) {
		this.boton = boton;
	}
	
	public Producto(String nombre, double precio, boolean celiaco, JButton boton) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.celiaco = celiaco;
		this.boton = boton;
	}
	
	public Producto() {
		super();
		this.nombre = "";
		this.precio = 0.0;
		this.celiaco = false;
		this.boton = null;
	}
	
	
}
