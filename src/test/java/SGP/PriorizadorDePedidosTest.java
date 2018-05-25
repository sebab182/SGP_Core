package SGP;

import java.util.LinkedList;
import java.util.List;

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

		Local local1 = new Local("LP","mail");
		Local local2 = new Local("M","mail");
		Local local3 = new Local("B","mail");
		List<Local> favoritos = new LinkedList<Local>();
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
		
		assertEquals(ordenados.get(0), p3);
		assertEquals(ordenados.get(1), p2);
		assertEquals(ordenados.get(2), p1);
		
	}
	
}
