package test.java.SGP;

import java.util.Date;

import junit.framework.TestCase;
import main.java.SGP.Pieza;
import main.java.SGP.Tipo;

public class PiezaTest extends TestCase {
	private Pieza p;
	
	@SuppressWarnings("deprecation")
	public PiezaTest() {
		p = new Pieza(new Tipo("muslo"),new Date(118,1,21));
	}

	public void testEqualsObject() {
		Pieza aux = new Pieza(new Tipo("muslo"),new Date());
		assertEquals(aux,p);
	}

	public void testToString() {
		assertEquals("muslo",p.toString());
	}

}
