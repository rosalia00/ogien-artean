import java.util.ArrayList;

public class Pasteleria extends Producto {
	String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pasteleria(String nombre, double precio, double pesoUnidad, ArrayList<String> ingredientes, String tipo) {
		super(nombre, precio, pesoUnidad, ingredientes);
		this.tipo = tipo;
	}

	public Pasteleria() {
		super();
		this.tipo = "";
	}

	@Override
	public String toString() {
		return "Pasteleria [tipo=" + tipo + "]";
	}

	
}
