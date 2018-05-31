package SGP;

import SGP.Criterios.Criterio;
import SGP.Criterios.CriterioMenosPiezas;
import SGP.Pedidos.Pedido;
import SGP.Stock.Tipo;

import junit.framework.TestCase;


public class CriterioMenosPiezasTest extends TestCase {

	public void testPuntuar() {

    	Pedido<Tipo> p1 = new PedidoMock(7.0);
    	Pedido<Tipo> p2 = new PedidoMock(6.0);
    	
    	Criterio c = new CriterioMenosPiezas();
    	
    	assertEquals(c.puntuar(p1), -7);
    	assertEquals(c.puntuar(p2), -6);
    	
	}
	
}
