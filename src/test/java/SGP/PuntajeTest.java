package SGP;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import SGP.Criterios.ComparadorDePedidos;
import SGP.Criterios.Criterio;
import SGP.Criterios.CriterioMenosPiezas;
import SGP.Criterios.Puntaje;
import SGP.Pedidos.Pedido;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class PuntajeTest extends TestCase {
	
	public void testPuntuar() {
		Criterio c = new CriterioMenosPiezas();
		List <Pedido<Tipo>> pedidos = new LinkedList<Pedido<Tipo>>();
		Pedido<Tipo> p1 = new PedidoMock(1, 1.0);
		Pedido<Tipo> p2 = new PedidoMock(2, 2.0);
		Pedido<Tipo> p3 = new PedidoMock(3, 1.0);
		pedidos.add(p1);
		pedidos.add(p2);
		pedidos.add(p3);
		Map<Pedido<Tipo>, Integer> puntajes = Puntaje.puntuar(pedidos, c);
		
		assertEquals(-1, puntajes.get(p1).intValue());
		assertEquals(-2, puntajes.get(p2).intValue());
		assertEquals(-1, puntajes.get(p3).intValue());
	}
	
	public void testHayEmpate() {
		Criterio c = new CriterioMenosPiezas();
		List <Pedido<Tipo>> pedidos_con_empate = pedidosConEmpate();
		Map<Pedido<Tipo>, Integer> puntajes_con_empate = Puntaje.puntuar(pedidos_con_empate, c);
		List <Pedido<Tipo>> pedidos_sin_empate = pedidosSinEmpate();
		Map<Pedido<Tipo>, Integer> puntajes_sin_empate = Puntaje.puntuar(pedidos_sin_empate, c);
		
		assertTrue(Puntaje.hayEmpate(pedidos_con_empate, puntajes_con_empate));
		assertFalse(Puntaje.hayEmpate(pedidos_sin_empate, puntajes_sin_empate));
	}
	
	private List <Pedido<Tipo>> pedidosConEmpate() {
		List <Pedido<Tipo>> pedidos_con_empate = new LinkedList<Pedido<Tipo>>();
		pedidos_con_empate.add(new PedidoMock(1, 1.0));
		pedidos_con_empate.add(new PedidoMock(2, 2.0));
		pedidos_con_empate.add(new PedidoMock(3, 1.0));
		return pedidos_con_empate;
	}
	
	private List <Pedido<Tipo>> pedidosSinEmpate() {
		List <Pedido<Tipo>> pedidos_sin_empate = new LinkedList<Pedido<Tipo>>();
		pedidos_sin_empate.add(new PedidoMock(4, 1.0));
		pedidos_sin_empate.add(new PedidoMock(5, 2.0));
		pedidos_sin_empate.add(new PedidoMock(6, 3.0));
		return pedidos_sin_empate;
	}

}
