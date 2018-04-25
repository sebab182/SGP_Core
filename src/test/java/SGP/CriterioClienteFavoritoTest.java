package test.java.SGP;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;
import main.java.SGP.Cliente;
import main.java.SGP.Pieza;
import main.java.SGP.Criterios.Criterio;
import main.java.SGP.Criterios.CriterioClienteFavorito;
//TODO: Rehacer test
public class CriterioClienteFavoritoTest extends TestCase {

	public void testPuntuar() {

		
		Cliente cliente1 = new Cliente("pepito");
		Cliente cliente2 = new Cliente("juancito");
		
		List<Cliente> favoritos = new LinkedList<Cliente>();
		favoritos.add(cliente1);
		
    	/*Pedido p1 = new Pedido(cliente1,new LinkedList<Pieza>());    
    	Pedido p2 = new Pedido(cliente2,new LinkedList<Pieza>());
    	
    	Criterio c = new CriterioClienteFavorito(favoritos);
    	
    	p1.setPuntage(c.puntuar(p1));
    	p2.setPuntage(c.puntuar(p2));
    	
    	
    	assertEquals(p1.getPuntaje(), 45);
    	assertEquals(p2.getPuntaje(), 0);*/
    	
	}
	
}
