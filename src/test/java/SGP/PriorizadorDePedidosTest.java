package SGP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import SGP.Criterios.Criterio;
import SGP.Criterios.CriterioClienteFavorito;
import SGP.Criterios.CriterioCompuesto;
import SGP.Criterios.CriterioMenosPiezas;
import SGP.Criterios.PriorizadorDePedidos;
import SGP.Pedidos.Local;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class PriorizadorDePedidosTest extends TestCase {

	public void testPriorizar() {

		Local l1 = new Local("l1", "sss");
		Local l2 = new Local("l2", "sss");
		
		Map<Local, Integer> favoritos = new  HashMap<Local, Integer>();
		favoritos.put(l1, 1);
		favoritos.put(l2, 2);
		
		List <Pedido<Tipo>> pedidos = new LinkedList<Pedido<Tipo>>();
		Pedido<Tipo> p1 = new PedidoMock(1, 1.0);
		Pedido<Tipo> p2 = new PedidoMock(2, 2.0, l1);
		Pedido<Tipo> p3 = new PedidoMock(3, 3.0);
		Pedido<Tipo> p4 = new PedidoMock(4, 2.0, l2);
		pedidos.add(p1);
		pedidos.add(p2);
		pedidos.add(p3);
		pedidos.add(p4);
		Criterio c1 = new CriterioMenosPiezas();
		Criterio c2 = new CriterioClienteFavorito(favoritos);
		c1.combinar(c2);
		pedidos = PriorizadorDePedidos.priorizar(pedidos, c1);
		
		assertEquals(p1, pedidos.get(0));
		assertEquals(p4, pedidos.get(1));
		assertEquals(p2, pedidos.get(2));
		assertEquals(p3, pedidos.get(3));
	}
	
}
