package SGP;

import java.util.Date;

import SGP.Stock.Pieza;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class PiezaTest extends TestCase {
	Pieza p;
	
	public PiezaTest() {
		p = new Pieza(new Tipo("muslo"),new Date(118,1,21));
	}
	
	public void testHashCode() {
		Pieza a = new Pieza(new Tipo("muslo"),new Date());
		assertNotSame(a.hashCode(),p.hashCode());
		assertNotSame(a.hashCode(),null);
	}

	public void testGetTipoPieza() {
		assertEquals(p.getTipoPieza(),new Tipo("muslo"));
	}

	public void testGetFechaVencimiento() {
		assertNotSame(p.getFechaVencimiento(),new Date());
	}

	public void testEquals() {
		Pieza a = new Pieza(new Tipo("muslo"),new Date());
		assertNotSame(a,p);

		Pieza b = new Pieza(new Tipo("vacio"),null);
		assertNotSame(b,p);
		
		Pieza c = new Pieza(new Tipo(null),new Date());
		assertNotSame(c,p);
		
		assertFalse(p.equals(null));
		
		assertFalse(p.equals(new Pieza(null,null)));
		
		assertFalse((new Pieza(null,null).equals(p)));
	}

	public void testToString() {
		assertEquals("muslo",p.toString());
	}
	
	public void testParser() {
		Pieza p = new Pieza("pata1 05/25/09");
		assertEquals("pata1",p.getTipoPieza().toString());
		assertEquals(new Date("05/25/09"),p.getFechaVencimiento());
	}
}
