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
	
	public void testHashCode1() {
		Pieza a = new Pieza(new Tipo("muslo"),new Date(118,2,14));
		assertNotSame(a,p);
	}
	
	public void testHashCode2() {
		Pieza a = new Pieza(new Tipo("muslo"),new Date(118,2,14));
		assertNotSame(a.hashCode(),p.hashCode());
	}
	
	public void testHashCode3() {
		Pieza a = new Pieza(new Tipo("muslo"),new Date(118,2,14));
		assertNotSame(a.hashCode(),null);
	}
	
	public void testHashCode4() {
		Pieza a = new Pieza(null,new Date(118,2,14));
		assertNotSame(7, a.hashCode());
	}

	public void testHashCode5() {
		Pieza a = new Pieza(new Tipo("muslo"),null);
		assertEquals(104264302,a.hashCode());
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
	}

	
	public void testEquals2() {
		Pieza b = new Pieza(new Tipo("vacio"),null);
		assertNotSame(b,p);
	}
	
	public void testEquals3() {
		Pieza c = new Pieza(new Tipo(null),new Date());
		assertFalse(c.equals(p));
	}
	
	public void testEquals4() {
		Pieza c = new Pieza(new Tipo(null),new Date());
		assertNotSame(c,p);
	}
	
	public void testEquals5() {
		assertFalse(p.equals(null));
	}
	
	public void testEquals6() {
		assertFalse(p.equals(new Pieza(null,null)));
	}	
	
	public void testEquals7() {
		assertFalse((new Pieza(null,null).equals(p)));
	}	
	
	public void testToString() {
		assertEquals("muslo",p.toString());
	}
	
	public void testParser1() {
		Pieza p = new Pieza("pata1 05/25/09 l");
		assertEquals("pata1",p.getTipoPieza().toString());
	}
	
	public void testParser2() {
		Pieza p = new Pieza("pata1 05/25/09 l");
		assertEquals(new Date("05/25/09"),p.getFechaVencimiento());
	}
}
