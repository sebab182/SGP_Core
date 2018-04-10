package test.SGP;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;
import main.SGP.Pieza;
import main.SGP.Stock;

public class StockTest extends TestCase {
	private Stock s;
	private Pieza p1;
	private Pieza p2;
	private List<Pieza>l;
	
	public StockTest() {
		//Armo contexto
		s = new Stock();
		p1 = new Pieza("pata1");
		p2 = new Pieza("pata2");
		l = new LinkedList<Pieza>();
		l.add(p1);
		l.add(p2);
	}

	public void testStockVacio() {
		assertTrue(s.stockVacio());
	}

	public void testAgregarPieza() {
		s.agregarPieza(p1);
		assertEquals(s.getCantidadPiezas(), 1);
	}

	public void testQuitarPieza() {
		s.agregarPieza(p1);
		s.agregarPieza(p2);
		s.quitarPieza(p1);
		assertEquals(s.getCantidadPiezas(), 1);
	}

	public void testAgregarPiezas() {
		s.agregarPiezas(l);
		assertEquals(s.getCantidadPiezas(), 2);
	}

	public void testQuitarPiezas() {
		s.agregarPiezas(l);
		s.quitarPiezas(l);
		s.agregarPieza(p1);
		assertEquals(s.getCantidadPiezas(), 1);
	}

	public void testGetCantidadPiezas() {
		s.agregarPieza(p1);
		s.agregarPieza(p2);
		s.agregarPiezas(l);
		assertEquals(s.getCantidadPiezas(), 4);
	}
	
	public void testVaciarStock() {
		s.agregarPieza(p1);
		s.agregarPieza(p2);
		s.agregarPiezas(l);
		s.vaciarStock();
		assertTrue(s.stockVacio());
	}

}
