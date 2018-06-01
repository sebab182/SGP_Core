package SGP;

import java.util.LinkedList;
import java.util.List;

import SGP.Criterios.ComparadorDePedidos;
import SGP.Criterios.Criterio;
import SGP.Criterios.CriterioMenosPiezas;
import SGP.Pedidos.Pedido;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class ComparadorDePedidosTest extends TestCase {

	public void testCompare() {
		List <Pedido<Tipo>> pedidos = new LinkedList<Pedido<Tipo>>();
		Pedido<Tipo> p1 = new PedidoMock(1, 1.0);
		Pedido<Tipo> p2 = new PedidoMock(2, 2.0);
		Pedido<Tipo> p3 = new PedidoMock(3, 1.0);
		pedidos.add(p1);
		pedidos.add(p2);
		pedidos.add(p3);
		Criterio c = new CriterioMenosPiezas();
		ComparadorDePedidos cp= new ComparadorDePedidos(pedidos, c);
		
		assertEquals(-1, cp.compare(p1, p2));
		assertEquals(1, cp.compare(p2, p3));
		assertEquals(0, cp.compare(p1, p3));
		
	}
	
}
