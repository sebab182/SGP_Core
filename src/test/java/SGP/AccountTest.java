package SGP;

import SGP.Email.Account;
import junit.framework.TestCase;

public class AccountTest extends TestCase {
	
	public void testAccount() {
		assertEquals(new Account(),new Account("pp2tpungs2018@gmail.com","pp2tpungs2018","pp2_ungs","smtp.gmail.com","25"));
	}
	
	public void testAccountArroba() {
		assertTrue(new Account().getDireccionMail().contains("@"));
	}
	
	public void testAccountContrasena() {
		assertFalse(new Account().getContrasena().isEmpty());
	}

	public void testHashCode() {
		Account a = new Account("test@test.com.ar","Test","PP2","smtp.gmail.com","45");
		assertEquals(-255568297,a.hashCode());
	}

	public void testGetDireccionMail() {
		assertEquals("test@test.com.ar",new Account("test@test.com.ar","Test","PP2","smtp.gmail.com","45").getDireccionMail());
	}

	public void testGetUsuario() {
		assertEquals("Test",new Account("test@test.com.ar","Test","PP2","smtp.gmail.com","45").getUsuario());
	}

	public void testGetContrasena() {
		assertNotSame("PP2 ",new Account("test@test.com.ar","Test","PP2","smtp.gmail.com","45").getContrasena());
	}

	public void testGetHost() {
		assertEquals("smtp.gmail.com",new Account("test@test.com.ar","Test","PP2","smtp.gmail.com","45").getHost());
	}

	public void testGetPuerto() {
		assertEquals("45",new Account("test@test.com.ar","Test","PP2","smtp.gmail.com","45").getPuerto());
	}

	public void testEqualsObject() {
		assertEquals(new Account("test@test.com.ar","Test","PP2","smtp.gmail.com","45"),new Account("test@test.com.ar","Test","PP2","smtp.gmail.com","45"));
	}
	
	public void testEqualsObject1() {
		assertNotSame(new Account("test@test.com.ar","Test","PP2","smtp.gmail.com","45"),null);
	}
	
	public void testEqualsObject2() {
		assertNotSame(new Account("test@test.com.ar","Test","PP2","smtp.gmail.com","45"),new Account(null,null,null,null,null));
	}

}
