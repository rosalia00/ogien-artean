import java.util.ArrayList;

public class Producto {
	String nombre;
	double precio;
	double pesoUnidad;
	ArrayList<String> ingredientes;
	
	
	
	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public double getPesoUnidad() {
		return pesoUnidad;
	}

	public ArrayList<String> getIngredientes() {
		return ingredientes;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setPesoUnidad(double pesoUnidad) {
		this.pesoUnidad = pesoUnidad;
	}

	public void setIngredientes(ArrayList<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	protected Producto(String nombre, double precio, double pesoUnidad, ArrayList<String> ingredientes) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.pesoUnidad = pesoUnidad;
		this.ingredientes = ingredientes;
	}
	
	protected Producto() {
		super();
		this.nombre = "";
		this.precio = 0.0;
		this.pesoUnidad = 0.0;
		this.ingredientes = null;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", pesoUnidad=" + pesoUnidad + ", ingredientes="
				+ ingredientes + "]";
	}
	
}
