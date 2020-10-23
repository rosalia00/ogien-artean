
public class Empleado extends Persona {
	String tipo;
	double nomina;

	public String getTipo() {
		return tipo;
	}

	public double getNomina() {
		return nomina;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setNomina(double nomina) {
		this.nomina = nomina;
	}

	public Empleado(String nombre, String apellido, int dni, String direccion, int telefono, String tipo,
			double nomina) {
		super(nombre, apellido, dni, direccion, telefono);
		this.tipo = tipo;
		this.nomina = nomina;
	}

	public Empleado() {
		super();
		this.tipo = "";
		this.nomina = 0.0;
	}

	@Override
	public String toString() {
		return "Empleado [tipo=" + tipo + ", nomina=" + nomina + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}

}
