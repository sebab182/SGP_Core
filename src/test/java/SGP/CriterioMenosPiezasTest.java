package test.java.SGP;

import java.util.LinkedList;
import java.util.List;
import junit.framework.TestCase;
import main.java.SGP.Criterio;
import main.java.SGP.CriterioMenosPiezas;
import main.java.SGP.Pieza;

public class CriterioMenosPiezasTest extends TestCase {

	public void testPuntuar() {
		List<List<Pieza>>pedidos= new LinkedList<List<Pieza>>();
		List<Pieza>pedido1 = new LinkedList<Pieza>();
    	pedido1.add(new Pieza("pata1"));
    	pedido1.add(new Pieza("pata1"));
    	pedido1.add(new Pieza("pata1"));
    	pedido1.add(new Pieza("muslo"));
    	pedido1.add(new Pieza("muslo"));
    	pedido1.add(new Pieza("muslo"));
    	pedido1.add(new Pieza("muslo"));
    	pedidos.add(pedido1);
    	
    	List<Pieza>pedido2 = new LinkedList<Pieza>();
    	pedido2.add(new Pieza("pata2"));
    	pedido2.add(new Pieza("pata2"));
    	pedido2.add(new Pieza("vacio"));
    	pedido2.add(new Pieza("vacio"));
    	pedido2.add(new Pieza("pata1"));
    	pedido2.add(new Pieza("pata1"));
    	pedidos.add(pedido2);
    	
    	Criterio c = new CriterioMenosPiezas(2);
    	
    	assertEquals(c.puntuar(pedido1), -14);
    	assertEquals(c.puntuar(pedido2), -12);
    	
	}
	
}
