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
	
	public void testEquals2(){
		assertFalse(new Local("UNGS","test@test.com.ar").equals(null));
	}
	
	public void testEquals3(){
		assertFalse(new Local("UNGS","test@test.com.ar").equals(new Local(null,"test@test.com.ar")));
	}
	
	public void testEquals4(){
		assertFalse(new Local("UNGS","test@test.com.ar").equals(new Local("UNGS",null)));
	}
	
	public void testEquals5(){
		assertFalse(new Local(null,"test@test.com.ar").equals(new Local("UNGS","test@test.com.ar")));
	}
	
	public void testEquals6(){
		assertFalse(new Local("UNGS",null).equals(new Local("UNGS","test@test.com.ar")));
	}
	
	public void testEquals7(){
		assertTrue(new Local("UNGS",null).equals(new Local("UNGS",null)));
	}
	
	public void testEquals8(){
		assertTrue(new Local(null,null).equals(new Local(null,null)));
	}
	
	public void testEquals9(){
		Local a =new Local("UNGS","test@test.com.ar");
		assertTrue(a.equals(a));
	}
	
	public void testEquals10(){
		Local a =new Local("UNGS","test@test.com.ar");
		assertFalse(a.equals(new Object()));
	}
	
	public void testHashCode() {
		assertEquals(-331903846,new Local("UNGS","test@test.com.ar").hashCode());
	}
}
