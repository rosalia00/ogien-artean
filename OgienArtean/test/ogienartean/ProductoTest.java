package ogienartean;

import static org.junit.Assert.*;

import org.junit.Test;

import ogienartean.Producto;

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
	
	@Test
	public void testSetNombre() {
		Producto p = new Producto("Leche", 0.41, false);
		p.setNombre("Empanada");
		assertEquals("Empanada", p.getNombre());
	}
	
	@Test
	public void testSetPrecio() {
		Producto p = new Producto("Leche", 0.41, false);
		p.setPrecio(5.21);
		assertEquals(5.21, p.getPrecio(), 0);
	}

	@Test
	public void testSetIsCeliaco() {
		Producto p = new Producto("Leche", 0.41, false);
		p.setCeliaco(true);
		assertEquals(true, p.isCeliaco());
	}
	
	@Test
	 public void testToStringVacio() {
		Producto p = new Producto();
		String expected = "Producto [nombre=" + "" + ", precio=" + 0.0 + ", celiaco=" + false + "]";
		assertEquals(expected, p.toString());
		
	}

	@Test
	 public void testToString() {
		Producto p = new Producto("Leche", 0.41, false);
		String expected = "Producto [nombre=" + "Leche" + ", precio=" + 0.41 + ", celiaco=" + false + "]";
		assertEquals(expected, p.toString());
	 }
}
