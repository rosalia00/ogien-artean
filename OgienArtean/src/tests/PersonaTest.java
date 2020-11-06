package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ogienartean.Persona;

public class PersonaTest {

	@Test
	public void testGetNombre() {
		Persona p = new Persona("Tyler", "de Mier", 00000000, "Casa", 00000000);
		assertEquals("Tyler", p.getNombre());
	}

	@Test
	public void testGetApellido() {
		Persona p = new Persona("Tyler", "de Mier", 00000000, "Casa", 00000000);
		assertEquals("de Mier", p.getApellido());
	}

	@Test
	public void testGetDni() {
		Persona p = new Persona("Tyler", "de Mier", 00000000, "Casa", 00000000);
		assertEquals(00000000, p.getDni());
	}

	@Test
	public void testGetDireccion() {
		Persona p = new Persona("Tyler", "de Mier", 00000000, "Casa", 00000000);
		assertEquals("Casa", p.getDireccion());
	}

	@Test
	public void testGetTelefono() {
		Persona p = new Persona("Tyler", "de Mier", 00000000, "Casa", 00000000);
		assertEquals(00000000, p.getTelefono());
	}

	@Test
	public void testSetNombre() {
		Persona p = new Persona("Tyler", "de Mier", 00000000, "Casa", 00000000);
		p.setNombre("Rosalia");
		assertEquals("Rosalia", p.getNombre());
	}

	@Test
	public void testSetApellido() {
		Persona p = new Persona("Tyler", "de Mier", 00000000, "Casa", 00000000);
		p.setApellido("Pérez");
		assertEquals("Pérez", p.getApellido());
	}

	@Test
	public void testSetDni() {
		Persona p = new Persona("Tyler", "de Mier", 00000000, "Casa", 00000000);
		p.setDni(111111111);
		assertEquals(111111111, p.getDni());
	}

	@Test
	public void testSetDireccion() {
		Persona p = new Persona("Tyler", "de Mier", 00000000, "Casa", 00000000);
		p.setDireccion("Vigo");
		assertEquals("Vigo", p.getDireccion());
	}

	@Test
	public void testSetTelefono() {
		Persona p = new Persona("Tyler", "de Mier", 00000000, "Casa", 00000000);
		p.setTelefono(111111111);
		assertEquals(111111111, p.getTelefono());
	}

}
