package SGP;

import java.util.LinkedList;
import java.util.List;


import SGP.Criterios.Criterio;
import SGP.Criterios.CriterioClienteFavorito;
import SGP.Criterios.CriterioCompuesto;
import SGP.Criterios.CriterioMenosPiezas;
import SGP.Pedidos.Local;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.Tipo;

import junit.framework.TestCase;


public class CriterioCompuestoTest extends TestCase {

	public void testPuntuar() {
		
		Local local1 = new Local("LP","mail");
		Local local2 = new Local("M","mail");
		
		List<Local> favoritos = new LinkedList<Local>();
		favoritos.add(local1);
		
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
		
    	List<Criterio> criterios = new LinkedList<Criterio>();
    	criterios.add(new CriterioMenosPiezas(2));
    	criterios.add(new CriterioClienteFavorito(favoritos));
		Criterio c = new CriterioCompuesto(criterios);
		

    	
    	assertEquals(c.puntuar(p1), 31);
    	assertEquals(c.puntuar(p2), -12);
    	
	}
	
}
