package SGP;

import junit.framework.TestCase;

public class ClienteTest extends TestCase {

	public void testGetNombre() {
		Cliente c= new Cliente("Pepe");
		assertEquals("Pepe",c.getNombre());
		assertNotSame("Luis",c.getNombre());
	}

	public void testEqualsObject() {
		Cliente a = new Cliente("Pepe");
		Cliente b = new Cliente("Luis");
		Cliente c = new Cliente("Pepe");
		assertNotSame(a,b);
		assertEquals(a,c);
		assertEquals(a,a);
	}

}
