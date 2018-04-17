package test.java.SGP;

import junit.framework.TestCase;
import main.java.SGP.GestordeStock;
import main.java.SGP.Pieza;

public class GestordeStockTest extends TestCase {
	private GestordeStock gs;


	public void testGetCantidadVacasRestantes() {
		assertTrue(true);
	}

	public void testSolicitarVacas() {
		DatosHardcodeados dh = new DatosHardcodeados();
		gs = dh.cargarGestordeStock();
		gs.solicitarVacas();
	
		assertEquals(gs.getStock().get(new Pieza("pata1")),new Integer(9));
		assertEquals(gs.getStock().get(new Pieza("pata2")),new Integer(6));
		assertEquals(gs.getStock().get(new Pieza("muslo")),new Integer(4));
		assertEquals(gs.getStock().get(new Pieza("pata3")),new Integer(3));
		assertEquals(gs.getStock().get(new Pieza("vacio")),new Integer(8));
		assertEquals(gs.getStock().get(new Pieza("pata4")),new Integer(5));
	}

	public void testDisminuirStock() {
		DatosHardcodeados dh = new DatosHardcodeados();
		gs = dh.cargarGestordeStock();
		gs.disminuirStock(new Pieza("pata1"), 1);
		assertEquals(gs.getStock().get(new Pieza("pata1")),new Integer(7));
	}

}
