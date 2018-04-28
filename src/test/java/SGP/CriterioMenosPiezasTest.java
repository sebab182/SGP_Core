package SGP;

import SGP.Criterios.Criterio;
import SGP.Criterios.CriterioMenosPiezas;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.Tipo;

import junit.framework.TestCase;


public class CriterioMenosPiezasTest extends TestCase {

	@SuppressWarnings("deprecation")
	public void testPuntuar() {

		int local1 = 1;
		int local2 = 2;
		
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
    	
    	Criterio c = new CriterioMenosPiezas(2);
    	
    	
    	assertEquals(c.puntuar(p1), -14);
    	assertEquals(c.puntuar(p2), -12);
    	
	}
	
}
