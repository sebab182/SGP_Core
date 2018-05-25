package SGP;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.AgrupadordePiezas;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class AgrupadordePiezasTest extends TestCase {
	private AgrupadordePiezas ap;
	
	public AgrupadordePiezasTest() {
		ap = new AgrupadordePiezas();
	}
	
	public void testAgruparPedidos() {
		Map<Tipo,Double>agrupacion = ap.agruparPedidos(cargarPedidos());
		assertEquals(agrupacion.get(new Tipo("pata1")),new Double(5.0));
	}
	
	public void testAgruparPedidos2() {
		Map<Tipo,Double>agrupacion = ap.agruparPedidos(cargarPedidos());
		assertEquals(agrupacion.get(new Tipo("pata2")),new Double(2.0));
	}

	
	public void testAgruparPedidos3() {
		Map<Tipo,Double>agrupacion = ap.agruparPedidos(cargarPedidos());
		assertEquals(agrupacion.get(new Tipo("muslo")),new Double(4.0));
	}

	
	public void testAgruparPedidos4() {
		Map<Tipo,Double>agrupacion = ap.agruparPedidos(cargarPedidos());
		assertEquals(agrupacion.get(new Tipo("vacio")),new Double(2.0));
	}


	private List<Pedido<Tipo>> cargarPedidos() {
		List<Pedido<Tipo>>pedidos= new LinkedList<Pedido<Tipo>>();
		Pedido<Tipo> pedido1 = new PedidoCarne();
		pedido1.agregarItem(new Tipo("pata1"), 3.0);
		pedido1.agregarItem(new Tipo("muslo"), 4.0);
		pedidos.add(pedido1);
		
		Pedido<Tipo> pedido2 = new PedidoCarne();
		pedido2.agregarItem(new Tipo("pata1"), 2.0);
		pedido2.agregarItem(new Tipo("pata2"), 2.0);
		pedido2.agregarItem(new Tipo("vacio"), 2.0);
		pedidos.add(pedido2);
		return pedidos;
	}
}