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
		
	}

	public void testResolverPedidos() {
		d = new Distribuidor();
		d.resolverPedidos(cargarPedidosTestPedidos(), cargarStockTestPedidos());
		assertEquals(1,d.getPedidosAceptados().size());
		assertEquals(1,d.getPedidosRechazados().size());
	}

	public void testResolverPedidosNivelAprobacion() {
		d = new Distribuidor();
		d.resolverPedidosNivelAprobacion(cargarPedidosTestNiveles(), cargarStockTestNiveles());
		assertEquals(1,d.getPedidosAceptados().size());
	}

	public void testGetPedidosRechazados() {
		d = new Distribuidor();
		d.resolverPedidosNivelAprobacion(cargarPedidosTestNiveles(), cargarStockTestNiveles());
		assertEquals(2,d.getPedidosRechazados().size());
	}

	public void testGetPedidosAceptados() {
		d = new Distribuidor();
		d.resolverPedidosNivelAprobacion(cargarPedidosTestNiveles(), cargarStockTestNiveles());
		assertEquals(1,d.getPedidosAceptados().size());
	}
	
	private GestorStockPiezas cargarStockTestPedidos() {
		GestorStockPiezas gsp = new GestorStockPiezas();
		List<Pieza>piezas= new LinkedList<Pieza>();
		piezas.add(new Pieza("pata1 12/09/18 l"));
		piezas.add(new Pieza("pata1 10/09/18 l"));
		piezas.add(new Pieza("pata1 09/09/18 l"));
		
		piezas.add(new Pieza("muslo 08/06/18 l"));
		piezas.add(new Pieza("muslo 07/07/18 l"));
		piezas.add(new Pieza("muslo 06/08/18 l"));
		piezas.add(new Pieza("muslo 05/09/18 l"));
		
		piezas.add(new Pieza("vacio 12/09/18 l"));
		piezas.add(new Pieza("vacio 12/10/18 l"));
		gsp.agregarItems(piezas);
		return gsp;
	}

	private HashSet<Pedido<Tipo>> cargarPedidosTestPedidos() {
		GestorPedidosCarne gpc = new GestorPedidosCarne();
		
		Pedido<Tipo> a = new PedidoCarne();
		a.agregarItem(new Tipo("muslo"), 3);
		a.agregarItem(new Tipo("pata1"), 2);
		a.agregarItem(new Tipo("vacio"), 2);
		gpc.agregarPedido(a);
			
		Pedido<Tipo> b = new PedidoCarne();
		b.agregarItem(new Tipo("pata1"), 3);
		b.agregarItem(new Tipo("muslo"), 2);			
		gpc.agregarPedido(b);

		return gpc.get_pedidos();
	}

	public GestorStockPiezas cargarStockTestNiveles() {
		GestorStockPiezas gsp = new GestorStockPiezas();
		gsp.agregarItem(new Pieza("vacio 25/05/18 l"));
		return gsp;
	}
	
	public HashSet<Pedido<Tipo>> cargarPedidosTestNiveles() {
		GestorPedidosCarne gpc = new GestorPedidosCarne();
		Pedido<Tipo> a = new PedidoCarne(100);
		a.agregarItem(new Tipo("pata1"), 1);
		a.agregarItem(new Tipo("vacio"), 1);
		a.agregarItem(new Tipo("falda"), 1);
		gpc.agregarPedido(a);
		
		Pedido<Tipo> b = new PedidoCarne(50);
		b.agregarItem(new Tipo("pata1"), 1);
		b.agregarItem(new Tipo("vacio"), 1);
		b.agregarItem(new Tipo("falda"), 1);
		gpc.agregarPedido(b);		
		
		Pedido<Tipo> c = new PedidoCarne(30);
		c.agregarItem(new Tipo("pata1"), 1);
		c.agregarItem(new Tipo("vacio"), 1);
		c.agregarItem(new Tipo("muslo"), 1);

		gpc.agregarPedido(c);
		return gpc.get_pedidos();
	}

}
