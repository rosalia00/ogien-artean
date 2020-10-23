import static org.junit.Assert.*;

import org.junit.Test;

public class ProductoTest {
	
	@Test
	public void testGetNombre() {
		Producto p = new Producto("Leche", 0.41, false);
		assertEquals("Leche", p.getNombre());
	}
	
	@Test
	public void testGetPrecio() {
		Producto p = new Producto("Leche", 0.41, false);
		assertEquals(0.41, p.getPrecio(), 0);
	}
	
	@Test
	public void testIsCeliaco() {
		Producto p = new Producto("Leche", 0.41, false);
		assertEquals(false, p.isCeliaco());
	}

}
