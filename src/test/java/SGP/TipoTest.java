package SGP;

import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class TipoTest extends TestCase {

	public void testEqualsObject() {
		assertEquals(new Tipo("pata1"),new Tipo("pata1"));
	}
	public void testEquals2() {
		assertNotSame(new Tipo("pata1"),new Tipo("muslo"));
	}
	
	public void testEquals3() {
		assertNotSame(new Tipo("pata1"),null);
	}
	
	public void testEquals4() {
		assertNotSame(new Tipo("pata1"),new Object());
	}	
	
	public void testEquals5() {
		Tipo a= new Tipo("pata1");
		assertEquals(a,a);
	}		
	
	public void testEquals6() {
		assertNotSame(new Tipo("null"),new Tipo("pata1"));
	}	

	public void testToString() {
		Tipo a = new Tipo("muslo");
		assertEquals("muslo",a.toString());
	}

}
