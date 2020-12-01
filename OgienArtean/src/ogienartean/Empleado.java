package ogienartean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
	
	public void añadirPan() {
		try {
			
			Pan p = new Pan();
			Class.forName("org.sqlite.JDBC");
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:ogien_artean.db");
			Statement stmt = (Statement) conn.createStatement();
			
			String instruccion = "INSERT INTO PAN "
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
