
public class Cliente extends Persona{
	int tarjeta;
	Boolean entrega;
	
	public int getTarjeta() {
		return tarjeta;
	}
	public Boolean getEntrega() {
		return entrega;
	}
	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}
	public void setEntrega(Boolean entrega) {
		this.entrega = entrega;
	}
	
	protected Cliente(String nombre, String apellido, int dni, String direccion, int telefono, int tarjeta,
			Boolean entrega) {
		super(nombre, apellido, dni, direccion, telefono);
		this.tarjeta = tarjeta;
		this.entrega = entrega;
	}
	
	protected Cliente() {
		super();
		this.tarjeta = 0;
		this.entrega = false;
	}
	
	@Override
	public String toString() {
		return "Cliente [tarjeta=" + tarjeta + ", entrega=" + entrega + "]";
	}
	
}
