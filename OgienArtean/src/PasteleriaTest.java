import static org.junit.Assert.*;

import org.junit.Test;

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

}
