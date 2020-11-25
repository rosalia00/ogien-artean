package ogienartean;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import ogienartean.Pan;

public class PanTest {
	
	@Test
	public void testGetIngredientes() {
		ArrayList<String> ingredientes = new ArrayList<String>();
		ingredientes.add("harina");
		ingredientes.add("levadura");
		ingredientes.add("sal");
		ingredientes.add("agua");
		
		Pan p = new Pan("Baguette", 0.75, false, ingredientes, true);
		
		assertEquals("harina", p.getIngredientes().get(0));
	}
	
	@Test
	public void testSetIngredientes() {
		ArrayList<String> ingredientes = new ArrayList<String>();
		ingredientes.add("harina");
		ingredientes.add("levadura");
		ingredientes.add("sal");
		ingredientes.add("agua");
		
		Pan p = new Pan("Baguette", 0.75, false, ingredientes, true);
		Pan p2 = new Pan();
		p2.setIngredientes(p.getIngredientes());
		
		assertEquals("harina", p2.getIngredientes().get(0));
	}
	

	@Test
	public void testGetSal() {
		ArrayList<String> ingredientes = new ArrayList<String>();
		ingredientes.add("harina");
		ingredientes.add("levadura");
		ingredientes.add("sal");
		ingredientes.add("agua");
		
		Pan p = new Pan("Baguette", 0.75, false, ingredientes, true);
		
		assertTrue(p.getSal());
		
	}
	
	@Test
	public void testSetSal() {
		ArrayList<String> ingredientes = new ArrayList<String>();
		ingredientes.add("harina");
		ingredientes.add("levadura");
		ingredientes.add("sal");
		ingredientes.add("agua");
		
		Pan p = new Pan("Baguette", 0.75, false, ingredientes, true);
		p.setSal(false);
		
		assertFalse(p.getSal());
		
	}
	
	
	
	
	

}
