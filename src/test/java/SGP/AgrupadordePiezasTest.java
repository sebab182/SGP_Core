package SGP;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import SGP.Pedidos.AgrupadorPiezasPedidos;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class AgrupadordePiezasTest extends TestCase {
	private AgrupadorPiezasPedidos ap;
	
	public AgrupadordePiezasTest() {
		ap = new AgrupadorPiezasPedidos();
	}
	
	public void testAgruparPedidos() {
		Map<Tipo,Integer>agrupacion = ap.agruparPedidos(cargarPedidos());
		assertEquals(agrupacion.get(new Tipo("pata1")),new Integer(5));
	}
	
	public void testAgruparPedidos2() {
		Map<Tipo,Integer>agrupacion = ap.agruparPedidos(cargarPedidos());
		assertEquals(agrupacion.get(new Tipo("pata2")),new Integer(2));
	}

	
	public void testAgruparPedidos3() {
		Map<Tipo,Integer>agrupacion = ap.agruparPedidos(cargarPedidos());
		assertEquals(agrupacion.get(new Tipo("muslo")),new Integer(4));
	}

	
	public void testAgruparPedidos4() {
		Map<Tipo,Integer>agrupacion = ap.agruparPedidos(cargarPedidos());
		assertEquals(agrupacion.get(new Tipo("vacio")),new Integer(2));
	}


	private List<Pedido<Tipo>> cargarPedidos() {
		List<Pedido<Tipo>>pedidos= new LinkedList<Pedido<Tipo>>();
		Pedido<Tipo> pedido1 = new PedidoCarne();
		pedido1.agregarItem(new Tipo("pata1"), 3);
		pedido1.agregarItem(new Tipo("muslo"), 4);
		pedidos.add(pedido1);
		
		Pedido<Tipo> pedido2 = new PedidoCarne();
		pedido2.agregarItem(new Tipo("pata1"), 2);
		pedido2.agregarItem(new Tipo("pata2"), 2);
		pedido2.agregarItem(new Tipo("vacio"), 2);
		pedidos.add(pedido2);
		return pedidos;
	}
}