package test.java.SGP;

import java.util.LinkedList;
import java.util.List;
import junit.framework.TestCase;
import main.java.SGP.Cliente;
import main.java.SGP.Criterio;
import main.java.SGP.CriterioMenosPiezas;
import main.java.SGP.Pedido;
import main.java.SGP.Pieza;

public class CriterioMenosPiezasTest extends TestCase {

	public void testPuntuar() {

		List<Pieza>pedido1 = new LinkedList<Pieza>();
    	pedido1.add(new Pieza("pata1"));
    	pedido1.add(new Pieza("pata1"));
    	pedido1.add(new Pieza("pata1"));
    	pedido1.add(new Pieza("muslo"));
    	pedido1.add(new Pieza("muslo"));
    	pedido1.add(new Pieza("muslo"));
    	pedido1.add(new Pieza("muslo"));
    	Pedido p1 = new Pedido(new Cliente(""),pedido1);
    	
    	List<Pieza>pedido2 = new LinkedList<Pieza>();
    	pedido2.add(new Pieza("pata2"));
    	pedido2.add(new Pieza("pata2"));
    	pedido2.add(new Pieza("vacio"));
    	pedido2.add(new Pieza("vacio"));
    	pedido2.add(new Pieza("pata1"));
    	pedido2.add(new Pieza("pata1"));
    	Pedido p2 = new Pedido(new Cliente(""),pedido2);
    	
    	Criterio c = new CriterioMenosPiezas(2);
    	
    	p1.setPuntage(c.puntuar(p1));
    	p2.setPuntage(c.puntuar(p2));
    	
    	
    	assertEquals(p1.getPuntaje(), -14);
    	assertEquals(p2.getPuntaje(), -12);
    	
	}
	
}
