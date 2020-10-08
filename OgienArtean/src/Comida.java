import java.util.ArrayList;

public class Comida extends Producto {
	String tipo;
	boolean caliente;
	
	public String getTipo() {
		return tipo;
	}
	public boolean isCaliente() {
		return caliente;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setCaliente(boolean caliente) {
		this.caliente = caliente;
	}
	
	public Comida(String nombre, double precio, double pesoUnidad, ArrayList<String> ingredientes, String tipo,
			boolean caliente) {
		super(nombre, precio, pesoUnidad, ingredientes);
		this.tipo = tipo;
		this.caliente = caliente;
	}
	
	public Comida() {
		super();
		this.tipo = "";
		this.caliente = false;
	}
	@Override
	public String toString() {
		return "Comida [tipo=" + tipo + ", caliente=" + caliente + "]";
	}
	
	
	

}
