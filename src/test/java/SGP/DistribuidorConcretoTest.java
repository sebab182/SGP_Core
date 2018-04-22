package test.java.SGP;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.TestCase;
import main.java.SGP.Distribuidor;
import main.java.SGP.DistribuidorConcreto;
import main.java.SGP.Pieza;



public class DistribuidorConcretoTest extends TestCase{
	
	Distribuidor d;
	Map<Pieza, Integer> stock;
	Map<Pieza, Integer> pedido1;
	Map<Pieza, Integer> pedido2;
	Map<Pieza, Integer> pedido3;
	Map<Pieza, Integer> pedido4;
	
	public DistribuidorConcretoTest() {
		this.d = new DistribuidorConcreto();

		stock = new HashMap<Pieza, Integer>();
		stock.put(new Pieza("pata1"), 2);
		stock.put(new Pieza("pata2"), 2);
		
		pedido1 = new HashMap<Pieza, Integer>();
		pedido1.put(new Pieza("pata1"), 2);
		pedido1.put(new Pieza("pata2"), 2);
		
		pedido2 = new HashMap<Pieza, Integer>();
		pedido2.put(new Pieza("pata1"), 1);
		
		pedido3 = new HashMap<Pieza, Integer>();
		pedido3.put(new Pieza("pata1"), 3);
		pedido3.put(new Pieza("pata2"), 2);
		
		pedido4 = new HashMap<Pieza, Integer>();
		pedido4.put(new Pieza("pata3"), 2);
		pedido4.put(new Pieza("pata4"), 2);
	}
	
	public void TestPuedoResolverPedido() {
		assertTrue(d.puedoResolverPedido(pedido1, stock));
		assertTrue(d.puedoResolverPedido(pedido2, stock));
		assertFalse(d.puedoResolverPedido(pedido3, stock));
		assertFalse(d.puedoResolverPedido(pedido4, stock));
	}
	
	public void TestSolicitarVaca() {
		Map<Pieza, Integer> stock2 = new HashMap<Pieza, Integer>(stock);
		d.solicitarVaca(stock2);
		boolean b = true;
		for (Entry<Pieza, Integer> entry: stock.entrySet())
			b = b && entry.getValue() +1 == stock2.get(entry.getKey());
		assertTrue(b);
	}
	
	public void TestresolverPedido( ) {
		Map<Pieza, Integer> dist = d.resolverPedido(pedido2, stock);
		boolean b = true;
		for (Entry<Pieza, Integer> entry: dist.entrySet())
			b = b && entry.getValue() == pedido2.get(entry.getKey());
		assertTrue(b);
		assertEquals(stock.get(new Pieza("pata1")).intValue() , 1);
		assertEquals(stock.get(new Pieza("pata2")).intValue() , 2);
	}

}
