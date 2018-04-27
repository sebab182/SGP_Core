package SGP;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import SGP.Criterios.Criterio;
import SGP.Criterios.CriterioMenosPiezas;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;
import junit.framework.TestCase;


public class CriterioMenosPiezasTest extends TestCase {

	@SuppressWarnings("deprecation")
	public void testPuntuar() {

		List<Pieza>pedido1 = new LinkedList<Pieza>();
		pedido1.add(new Pieza(new Tipo("pata1"),new Date(107,10,23)));
		pedido1.add(new Pieza(new Tipo("pata1"),new Date(107,11,12)));
		pedido1.add(new Pieza(new Tipo("pata3"),new Date(118,1,21)));
		pedido1.add(new Pieza(new Tipo("pata4"),new Date(110,10,27)));
		pedido1.add(new Pieza(new Tipo("muslo"),new Date(108,3,21)));
		pedido1.add(new Pieza(new Tipo("vacio"),new Date(118,2,21)));
		pedido1.add(new Pieza(new Tipo("vacio"),new Date(118,3,21)));	
    	//Pedido p1 = new Pedido(new Cliente(""),pedido1);
    	
    	List<Pieza>pedido2 = new LinkedList<Pieza>();
    	pedido2.add(new Pieza(new Tipo("pata3"),new Date(118,1,21)));
		pedido2.add(new Pieza(new Tipo("pata4"),new Date(110,10,27)));
		pedido2.add(new Pieza(new Tipo("muslo"),new Date(108,3,21)));
		pedido2.add(new Pieza(new Tipo("vacio"),new Date(118,2,21)));
		pedido2.add(new Pieza(new Tipo("vacio"),new Date(118,3,21)));	
		pedido2.add(new Pieza(new Tipo("vacio"),new Date(118,3,21)));	
    	//Pedido p2 = new Pedido(new Cliente(""),pedido2);
    	
    	Criterio c = new CriterioMenosPiezas(2);
    	
    	//p1.setPuntage(c.puntuar(p1));
    	//p2.setPuntage(c.puntuar(p2));
    	
    	
    	//assertEquals(p1.getPuntaje(), -14);
    	//assertEquals(p2.getPuntaje(), -12);
    	
	}
	
}
