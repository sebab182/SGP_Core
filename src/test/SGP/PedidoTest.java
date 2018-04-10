package test.SGP;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;
import main.SGP.Pedido;
import main.SGP.Pieza;

public class PedidoTest extends TestCase {
	private Pedido p;
	private Pieza p1;
	private Pieza p2;
	private List<Pieza>l;
	
	public PedidoTest() {
		p = new Pedido();
		p1 = new Pieza("pata1");
		p2 = new Pieza("pata2");
		l = new LinkedList<Pieza>();
		l.add(p1);
		l.add(p2);
	}
	
	public void testPedidoVacio() {
		assertTrue(p.pedidoVacio());
	}

	public void testAgregarPieza() {
		p.agregarPieza(p1);
		assertEquals(p.getCantidadPiezas(),1);
	}

	public void testAgregarPiezas() {
		p.agregarPiezas(l);
		p.agregarPiezas(l);
		assertEquals(p.getCantidadPiezas(),4);
	}

	public void testGetPedido() {
		p.agregarPieza(p1);
		assertEquals(p.getPedido().size(),1);
	}

	public void testGetCantidadPiezas() {
		p.agregarPieza(p1);
		p.agregarPieza(p2);
		assertEquals(p.getCantidadPiezas(),2);
	}

}
