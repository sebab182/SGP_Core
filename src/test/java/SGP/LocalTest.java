package SGP;

import SGP.Pedidos.Local;
import junit.framework.TestCase;

public class LocalTest extends TestCase {

	public void testGetNombreLocal() {
		assertEquals(new Local("UNGS","test@test.com.ar").getNombreLocal(),"UNGS");
	}

	public void testGetEmail() {
		assertEquals(new Local("UNGS","test@test.com.ar").getEmail(),"test@test.com.ar");
	}
	
	public void testEquals(){
		assertTrue(new Local("UNGS","test@test.com.ar").equals(new Local("UNGS","test@test.com.ar")));
	}
	
	public void testHashCode() {
		assertEquals(-331903846,new Local("UNGS","test@test.com.ar").hashCode());
	}
}
