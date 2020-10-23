import static org.junit.Assert.*;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void testGetTarjeta() {
		Cliente c = new Cliente("Tyler", "de Mier", 000000000, "Bilbao", 000000000, 123456789, true);
		assertEquals(123456789, c.getTarjeta());
	}
	
	@Test
	public void testGetEntrega() {
		Cliente c = new Cliente("Tyler", "de Mier", 000000000, "Bilbao", 000000000, 123456789, true);
		assertTrue(c.getEntrega());
	}
	
	@Test
	public void testSetTarjeta() {
		Cliente c = new Cliente("Tyler", "de Mier", 000000000, "Bilbao", 000000000, 123456789, true);
		c.setTarjeta(987654321);
		assertEquals(987654321, c.getTarjeta());
	}
	
	@Test
	public void testSetEntrega() {
		Cliente c = new Cliente("Tyler", "de Mier", 000000000, "Bilbao", 000000000, 123456789, true);
		c.setEntrega(false);
		assertFalse(c.getEntrega());
	}

}
