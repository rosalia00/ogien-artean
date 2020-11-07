package ogienartean;

public class Empleado extends Persona {
	double nomina;
	String usuario;
	String contraseña;

	public double getNomina() {
		return nomina;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setNomina(double nomina) {
		this.nomina = nomina;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Empleado(String nombre, String apellido, int dni, String direccion, int telefono, double nomina,
			String usuario, String contraseña) {
		super(nombre, apellido, dni, direccion, telefono);
		this.nomina = nomina;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

}
