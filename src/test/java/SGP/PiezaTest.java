package SGP;

import java.util.Date;

import junit.framework.TestCase;

public class PiezaTest extends TestCase {
	Pieza p;
	
	public PiezaTest() {
		p = new Pieza(new Tipo("muslo"),new Date(118,1,21));
	}
	
	public void testHashCode() {
		Pieza a = new Pieza(new Tipo("muslo"),new Date());
		assertNotSame(a.hashCode(),p.hashCode());
	}

	public void testGetTipoPieza() {
		assertEquals(p.getTipoPieza(),new Tipo("muslo"));
	}

	public void testGetFechaVencimiento() {
		assertNotSame(p.getFechaVencimiento(),new Date());
	}

	public void testEqualsObject() {
		Pieza a = new Pieza(new Tipo("muslo"),new Date());
		assertNotSame(a,p);
		
		Pieza b = new Pieza(new Tipo("vacio"),null);
		assertNotSame(b,p);
	}

	public void testToString() {
		assertEquals("muslo",p.toString());
	}

}
