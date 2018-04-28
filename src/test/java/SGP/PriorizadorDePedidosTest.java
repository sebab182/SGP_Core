package SGP;

import java.util.LinkedList;
import java.util.List;

import SGP.Criterios.Criterio;
import SGP.Criterios.CriterioClienteFavorito;
import SGP.Criterios.CriterioCompuesto;
import SGP.Criterios.CriterioMenosPiezas;
import SGP.Criterios.PriorizadorDePedidos;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class PriorizadorDePedidosTest extends TestCase {

	public void testPriorizar() {
		
		int local1 = 1;
		int local2 = 2;
		int local3 = 3;
		
		List<Integer> favoritos = new LinkedList<Integer>();
		favoritos.add(local3);
		
		Pedido<Tipo> p1 = new PedidoCarne();
    	p1.setLocal(local1);
    	p1.agregarItem(new Tipo("pata1"), 2.0);
		p1.agregarItem(new Tipo("pata3"), 1.0);
		p1.agregarItem(new Tipo("pata4"), 1.0);
		p1.agregarItem(new Tipo("muslo"), 1.0);
		p1.agregarItem(new Tipo("vacio"), 2.0);	
		
    	Pedido<Tipo> p2 = new PedidoCarne();
    	p2.setLocal(local2);
    	p2.agregarItem(new Tipo("pata3"), 1.0);
		p2.agregarItem(new Tipo("pata4"), 1.0);
		p2.agregarItem(new Tipo("muslo"), 1.0);
		p2.agregarItem(new Tipo("vacio"), 3.0);
		
		Pedido<Tipo> p3 = new PedidoCarne();
		p3.setLocal(local3);
		p3.agregarItem(new Tipo("pata3"), 1.0);
		
		List<Pedido<Tipo>> pedidos = new LinkedList<Pedido<Tipo>>();
		pedidos.add(p1);
		pedidos.add(p2);
		pedidos.add(p3);
		
    	List<Criterio> criterios = new LinkedList<Criterio>();
    	criterios.add(new CriterioMenosPiezas(2));
    	criterios.add(new CriterioClienteFavorito(favoritos));
		Criterio c = new CriterioCompuesto(criterios);
		
		PriorizadorDePedidos pp = new PriorizadorDePedidos();
		pp.priorizar(pedidos, c);
		
		List<Pedido<Tipo>> ordenados = pp.priorizar(pedidos, c);
		
		/* puntajes:
		 * p1 = -14
		 * p2 = -12
		 * p3 = 43
		 * quedan odenados asi:
		 * {p3, p2, p1}
		 */
		
		assertEquals(ordenados.get(0), p3);
		assertEquals(ordenados.get(1), p2);
		assertEquals(ordenados.get(2), p1);
		
	}
	
}
