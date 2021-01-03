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
	public void testGetContrase�a() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, 1000000.0, "peter", "1234");
		assertEquals("1234", e.getContrase�a());
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
	public void testSetContrase�a() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, 1000000.0, "peter", "1234");
		e.setContrase�a("4321");
		assertEquals("4321", e.getContrase�a());
	}
	
	@Test
	 public void testToString() {
	    Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, 1000000.0, "peter", "1234"); 
	    String expected = "Empleado [nomina=" + 1000000.0 + ", usuario=" + "peter" + ", contrase�a=" + "1234" + "]"; 
	    assertEquals(expected, e.toString());
	  }

}
