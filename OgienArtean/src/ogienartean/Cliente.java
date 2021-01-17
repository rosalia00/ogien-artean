package ogienartean;

public class Cliente extends Persona {
	long tarjeta;
	Boolean entrega;
	String usuario;
	String contraseña;

	public long getTarjeta() {
		return tarjeta;
	}

	public Boolean getEntrega() {
		return entrega;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setTarjeta(long tarjeta) {
		this.tarjeta = tarjeta;
	}

	public void setEntrega(Boolean entrega) {
		this.entrega = entrega;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public Cliente(String nombre, String apellido, int dni, String direccion, int telefono, long tarjeta,
			Boolean entrega, String usuario, String contraseña) {
		super(nombre, apellido, dni, direccion, telefono);
		this.tarjeta = tarjeta;
		this.entrega = entrega;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Cliente [tarjeta=" + tarjeta + ", entrega=" + entrega + ", usuario=" + usuario + ", contraseña="
				+ contraseña + "]";
	}


}
