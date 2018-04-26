package SGP;

import junit.framework.TestCase;

public class TipoTest extends TestCase {

	public void testEqualsObject() {
		Tipo a = new Tipo("pata1");
		Tipo b = new Tipo("pata1");
		assertEquals(a,b);
		
		b= new Tipo("muslo");
		assertNotSame(a,b);
	}

	public void testToString() {
		Tipo a = new Tipo("muslo");
		assertEquals("muslo",a.toString());
	}

}
