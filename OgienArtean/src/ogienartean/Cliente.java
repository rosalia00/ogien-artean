package ogienartean;

public class Cliente extends Persona {
	int tarjeta;
	Boolean entrega;
	String usuario;
	String contrase�a;

	public int getTarjeta() {
		return tarjeta;
	}

	public Boolean getEntrega() {
		return entrega;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}

	public void setEntrega(Boolean entrega) {
		this.entrega = entrega;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}


	public Cliente(String nombre, String apellido, int dni, String direccion, int telefono, int tarjeta,
			Boolean entrega, String usuario, String contrase�a) {
		super(nombre, apellido, dni, direccion, telefono);
		this.tarjeta = tarjeta;
		this.entrega = entrega;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	@Override
	public String toString() {
		return "Cliente [tarjeta=" + tarjeta + ", entrega=" + entrega + ", usuario=" + usuario + ", contrase�a="
				+ contrase�a + "]";
	}


}
