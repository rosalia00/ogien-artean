package ogienartean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Empleado extends Persona {
	double nomina;
	String usuario;
	String contrase�a;

	public double getNomina() {
		return nomina;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setNomina(double nomina) {
		this.nomina = nomina;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public Empleado(String nombre, String apellido, int dni, String direccion, int telefono, double nomina,
			String usuario, String contrase�a) {
		super(nombre, apellido, dni, direccion, telefono);
		this.nomina = nomina;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	@Override
	public String toString() {
		return "Empleado [nomina=" + nomina + ", usuario=" + usuario + ", contrase�a=" + contrase�a + "]";
	}
	
	


}
