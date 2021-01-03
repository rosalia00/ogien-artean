package ogienartean;

import ogienartean.Cliente;
import static org.junit.Assert.*;
import org.junit.Test;

public class ClienteTest {

	@Test
	public void testGetTarjeta() {
		Cliente c = new Cliente("Rosalia","Perez", 000000000, "Bilbao",  000000000, 123456789, true, "ros","1234");
		assertEquals(123456789, c.getTarjeta());
	}
	
	@Test
	public void testGetEntrega() {
		Cliente c = new Cliente("Rosalia","Perez", 000000000, "Bilbao",  000000000, 123456789, true, "ros","1234");
		assertTrue(c.getEntrega());
	}
	
	@Test
	public void testGetUsuario() {
		Cliente c = new Cliente("Rosalia","Perez", 000000000, "Bilbao",  000000000, 123456789, true, "ros","1234");
		assertEquals("ros", c.getUsuario());
	}
	
	@Test
	public void testGetCOntraseña() {
		Cliente c = new Cliente("Rosalia","Perez", 000000000, "Bilbao",  000000000, 123456789, true, "ros","1234");
		assertEquals("1234", c.getContraseña());
	}
	
	@Test
	public void testSetTarjeta() {
		Cliente c = new Cliente("Rosalia","Perez", 000000000, "Bilbao",  000000000, 123456789, true, "ros","1234");
		c.setTarjeta(987654321);
		assertEquals(987654321, c.getTarjeta());
	}
	
	@Test
	public void testSetEntrega() {
		Cliente c = new Cliente("Rosalia","Perez", 000000000, "Bilbao",  000000000, 123456789, true, "ros","1234");
		c.setEntrega(false);
		assertFalse(c.getEntrega());
	}
	
	@Test
	public void testSetUsuario() {
		Cliente c = new Cliente("Rosalia","Perez", 000000000, "Bilbao",  000000000, 123456789, true, "ros","1234");
		c.setUsuario("eva");
		assertEquals("eva", c.getUsuario());
	}

	@Test
	public void testSetContraseña() {
		Cliente c = new Cliente("Rosalia","Perez", 000000000, "Bilbao",  000000000, 123456789, true, "ros","1234");
		c.setContraseña("012");
		assertEquals("012", c.getContraseña());
	}
	
	@Test
	public void testToString() { 
		Cliente c = new Cliente("Rosalia","Perez", 000000000, "Bilbao",  000000000, 123456789, true, "ros","1234");
		String expected = "Cliente [tarjeta=" + 123456789 + ", entrega=" + true + ", usuario=" + "ros" + ", contraseña="
				 + "1234"+ "]";
		assertEquals(expected , c.toString());
	}

}
