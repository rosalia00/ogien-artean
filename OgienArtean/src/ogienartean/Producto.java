package ogienartean;

import javax.swing.JButton;

public class Producto {
	String nombre;
	double precio;
	boolean celiaco;
	
	
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public boolean isCeliaco() {
		return celiaco;
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
	
	public Producto(String nombre, double precio, boolean celiaco) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.celiaco = celiaco;
	}
	
	public Producto() {
		super();
		this.nombre = "";
		this.precio = 0.0;
		this.celiaco = false;
	}
	
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", celiaco=" + celiaco + "]";
	}
	
	
}
