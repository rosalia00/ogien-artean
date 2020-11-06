package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ogienartean.Comida;

public class ComidaTest {

	@Test
	public void testGetTipo() {
		Comida c = new Comida("Bocadillo", 2.5, false, "de calamares", true);
		assertEquals("de calamares", c.getTipo());
	}

	@Test
	public void testSetTipo() {
		Comida c = new Comida("Bocadillo", 2.5, false, "de calamares", true);
		c.setTipo("mixto");
		assertEquals("mixto", c.getTipo());
	}

	@Test
	public void testGetCaliente() {
		Comida c = new Comida("Bocadillo", 2.5, false, "de calamares", true);
		assertTrue(c.getCaliente());
	}
	
	@Test
	public void testSetCaliente() {
		Comida c = new Comida("Bocadillo", 2.5, false, "de calamares", true);
		c.setCaliente(false);
		assertFalse(c.getCaliente());
	}

}
