package SGP;

import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class TipoTest extends TestCase {

	public void testEqualsObject() {
		Tipo a = new Tipo("pata1");
		Tipo b = new Tipo("pata1");
		assertEquals(a,b);
		
		b= new Tipo("muslo");
		assertNotSame(a,b);
		
		assertNotSame(a, null);
		assertEquals(a,a);
		
		Tipo c= new Tipo(null);
		assertNotSame(a,c);
	}

	public void testToString() {
		Tipo a = new Tipo("muslo");
		assertEquals("muslo",a.toString());
	}

}
