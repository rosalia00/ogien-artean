package ogienartean;

import javax.swing.JButton;

public class Pasteleria extends Producto {
	String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	protected Pasteleria(String nombre, double precio, boolean celiaco, JButton boton, String tipo) {
		super(nombre, precio, celiaco, boton);
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
