package ogienartean;

import static org.junit.Assert.*;

import org.junit.Test;

import ogienartean.Pasteleria;

public class PasteleriaTest {

	@Test
	public void testGetTipo() {
		Pasteleria p = new Pasteleria("Magdalena", 2, true, "de chocolate");
		assertEquals("de chocolate", p.getTipo());
	}
	
	@Test
	public void testSetTipo() {
		Pasteleria p = new Pasteleria("Magdalena", 2, true, "de chocolate");
		p.setTipo("de vainilla");
		assertEquals("de vainilla", p.getTipo());
	}

	@Test
	 public void testToStringVacio() {
		Pasteleria p = new Pasteleria();
		String expected = "Pasteleria [tipo=" + "" + "]"; 
	    assertEquals(expected, p.toString());
	 }
	
	@Test
	 public void testToString() {
		Pasteleria p = new Pasteleria("Magdalena", 2, true, "de chocolate");
		String expected = "Pasteleria [tipo=" + "de chocolate" + "]"; 
	    assertEquals(expected, p.toString());
	 }
}
