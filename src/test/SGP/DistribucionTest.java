package test.SGP;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;
import main.SGP.Distribucion;
import main.SGP.Pieza;

public class DistribucionTest extends TestCase {
	private Distribucion d;
	private Pieza p1;
	private Pieza p2;
	private List<Pieza>l;
	
	public DistribucionTest() {
		d = new Distribucion();
		p1 = new Pieza("pata1");
		p2 = new Pieza("pata2");
		l = new LinkedList<Pieza>();
		l.add(p1);
		l.add(p2);
	}
	
	public void testDistribucionVacia() {
		assertTrue(d.distribucionVacia());
	}

	public void testAgregarPieza() {
		d.agregarPieza(p1);
		assertEquals(d.getCantidadPiezas(),1);
	}

	public void testQuitarPieza() {
		d.agregarPieza(p1);
		d.agregarPieza(p2);
		d.quitarPieza(p1);
		assertEquals(d.getCantidadPiezas(),1);
	}

	public void testAgregarPiezas() {
		d.agregarPiezas(l);
		assertEquals(d.getCantidadPiezas(),2);
	}

	public void testQuitarPiezas() {
		d.agregarPieza(p1);
		d.agregarPiezas(l);
		d.quitarPiezas(l);
		assertEquals(d.getCantidadPiezas(),1);
	}

	public void testGetCantidadPiezas() {
		d.agregarPiezas(l);
		d.agregarPiezas(l);
		assertEquals(d.getCantidadPiezas(),4);
	}

	public void testGetDistribucion() {
		d.agregarPieza(p1);
		assertEquals(d.getDistribucion().size(),1);
	}

}
