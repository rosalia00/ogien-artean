package ogienartean;

import static org.junit.Assert.*;

import org.junit.Test;

import ogienartean.Empleado;

public class EmpleadoTest {
	
	@Test
	public void testGetNomina() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, 1000000.0, "peter", "1234");
		assertEquals(1000000.0, e.getNomina(), 0);
	}
	
	@Test
	public void testGetUsuario() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, 1000000.0, "peter", "1234");
		assertEquals("peter", e.getUsuario());
	}
	
	@Test
	public void testGetContraseña() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, 1000000.0, "peter", "1234");
		assertEquals("1234", e.getContraseña());
	}

	@Test
	public void testSetNomina() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, 1000000.0, "peter", "1234");
		e.setNomina(0.0);
		assertEquals(0.0, e.getNomina(), 0);
	}
	
	@Test
	public void testSetUsuario() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, 1000000.0, "peter", "1234");
		e.setUsuario("retep");
		assertEquals("retep", e.getUsuario());
	}
	
	@Test
	public void testSetContraseña() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, 1000000.0, "peter", "1234");
		e.setContraseña("4321");
		assertEquals("4321", e.getContraseña());
	}
	
	@Test
	 public void testToString() {
	    Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, 1000000.0, "peter", "1234"); 
	    String expected = "Empleado [nomina=" + 1000000.0 + ", usuario=" + "peter" + ", contraseña=" + "1234" + "]"; 
	    assertEquals(expected, e.toString());
	  }

}
