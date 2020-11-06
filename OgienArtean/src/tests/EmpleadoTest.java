package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ogienartean.Empleado;

public class EmpleadoTest {

	@Test
	public void testGetTipo() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, "Cajero", 1000000.0);
		assertEquals("Cajero", e.getTipo());
	}
	
	@Test
	public void testGetNomina() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, "Cajero", 1000000.0);
		assertEquals(1000000.0, e.getNomina(), 0);
	}

	@Test
	public void testSetTipo() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, "Cajero", 1000000.0);
		e.setTipo("Limpiador");
		assertEquals("Limpiador", e.getTipo());
	}

	@Test
	public void testSetNomina() {
		Empleado e = new Empleado("Tyler", "de Mier", 00000000, "Bilbao", 000000000, "Cajero", 1000000.0);
		e.setNomina(0.0);
		assertEquals(0.0, e.getNomina(), 0);
	}

}
