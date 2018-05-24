package SGP;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import SGP.Pedidos.GestorPedidosCarne;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.Distribuidor;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class DistribuidorTest extends TestCase {
	private Distribuidor d;
	
	public DistribuidorTest() {
		d = new Distribuidor();
	}

	public void testResolverPedidos() {
		d.resolverPedidos(cargarPedidosTestPedidos(), cargarStockTestPedidos());
		assertEquals(3,d.getPedidosAceptados().size());
	}

	public void testResolverPedidosNivelAprobacion() {
		d.resolverPedidosNivelAprobacion(cargarPedidosTestNiveles(), cargarStockTestNiveles());
		assertEquals(1,d.getPedidosAceptados().size());
	}

	public void testGetPedidosRechazados() {
		d.resolverPedidosNivelAprobacion(cargarPedidosTestNiveles(), cargarStockTestNiveles());
		assertEquals(2,d.getPedidosRechazados().size());
	}

	public void testGetPedidosAceptados() {
		d.resolverPedidosNivelAprobacion(cargarPedidosTestNiveles(), cargarStockTestNiveles());
		assertEquals(1,d.getPedidosAceptados().size());
	}
	
	private GestorStockPiezas cargarStockTestPedidos() {
		GestorStockPiezas gsp = new GestorStockPiezas();
		List<Pieza>piezas= new LinkedList<Pieza>();
		piezas.add(new Pieza("vacio 25/09/18"));
		piezas.add(new Pieza("falda 15/09/18"));
		piezas.add(new Pieza("pata1 12/09/18"));
		piezas.add(new Pieza("pata3 12/02/19"));
		piezas.add(new Pieza("pata1 22/09/18"));
		piezas.add(new Pieza("pata1 25/09/18"));
		piezas.add(new Pieza("pata2 11/02/19"));
		piezas.add(new Pieza("pata3 03/02/19"));
		piezas.add(new Pieza("muslo 25/05/18"));
		piezas.add(new Pieza("falda 15/09/18"));
		piezas.add(new Pieza("pata1 26/09/18"));
		piezas.add(new Pieza("pata1 28/09/18"));
		piezas.add(new Pieza("pata1 18/09/18"));
		piezas.add(new Pieza("vacio 18/09/18"));
		gsp.agregarItems(piezas);
		return gsp;
	}

	private HashSet<Pedido<Tipo>> cargarPedidosTestPedidos() {
		GestorPedidosCarne gpc = new GestorPedidosCarne();
		
		Pedido<Tipo> a = new PedidoCarne();
		a.agregarItem(new Tipo("muslo"), 1.0);
		a.agregarItem(new Tipo("pata1"), 2.0);
		a.agregarItem(new Tipo("falda"), 1.0);
		gpc.agregarPedido(a);
			
		Pedido<Tipo> b = new PedidoCarne();
		b.agregarItem(new Tipo("vacio"), 1.0);
		b.agregarItem(new Tipo("falda"), 1.0);
		b.agregarItem(new Tipo("pata1"), 1.0);
		b.agregarItem(new Tipo("pata3"), 1.0);			
		gpc.agregarPedido(b);

		Pedido<Tipo> c = new PedidoCarne();
		c.agregarItem(new Tipo("pata1"), 2.0);
		c.agregarItem(new Tipo("pata2"), 1.0);
		c.agregarItem(new Tipo("pata3"), 1.0);			
		gpc.agregarPedido(c);
		return gpc.get_pedidos();
	}

	public GestorStockPiezas cargarStockTestNiveles() {
		GestorStockPiezas gsp = new GestorStockPiezas();
		gsp.agregarItem(new Pieza("muslo 25/05/18"));
		return gsp;
	}
	
	public HashSet<Pedido<Tipo>> cargarPedidosTestNiveles() {
		GestorPedidosCarne gpc = new GestorPedidosCarne();
		Pedido<Tipo> a = new PedidoCarne(100);
		a.agregarItem(new Tipo("muslo"), 1.0);
		a.agregarItem(new Tipo("pata1"), 1.0);
		a.agregarItem(new Tipo("falda"), 1.0);
		gpc.agregarPedido(a);
		
		Pedido<Tipo> a1 = new PedidoCarne(50);
		a1.agregarItem(new Tipo("muslo"), 1.0);
		a1.agregarItem(new Tipo("pata1"), 1.0);
		a1.agregarItem(new Tipo("falda"), 1.0);
		gpc.agregarPedido(a1);		
		
		Pedido<Tipo> a2 = new PedidoCarne(30);
		a2.agregarItem(new Tipo("muslo"), 1.0);
		a2.agregarItem(new Tipo("pata1"), 1.0);
		a2.agregarItem(new Tipo("falda"), 1.0);
		gpc.agregarPedido(a2);
		return gpc.get_pedidos();
	}

}
