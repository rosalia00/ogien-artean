
public class Persona {
	String nombre;
	String apellido;
	int dni;
	String direccion;
	int telefono;

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Persona(String nombre, String apellido, int dni, String direccion, int telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Persona() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.dni = 0;
		this.direccion = "";
		this.telefono = 0;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}

}
