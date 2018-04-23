package test.java.SGP;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;
import main.java.SGP.Cliente;
import main.java.SGP.Criterio;
import main.java.SGP.CriterioClienteFavorito;
import main.java.SGP.CriterioCompuesto;
import main.java.SGP.CriterioMenosPiezas;
import main.java.SGP.Pedido;
import main.java.SGP.Pieza;

public class CriterioCompuestoTest extends TestCase {

	public void testPuntuar() {
		
		Cliente cliente1 = new Cliente("pepito");
		Cliente cliente2 = new Cliente("juancito");
		
		List<Cliente> favoritos = new LinkedList<Cliente>();
		favoritos.add(cliente1);
		
		List<Pieza>piezas1 = new LinkedList<Pieza>();
		piezas1.add(new Pieza("pata1"));
		piezas1.add(new Pieza("pata1"));
		piezas1.add(new Pieza("pata1"));
		piezas1.add(new Pieza("muslo"));
		piezas1.add(new Pieza("muslo"));
		piezas1.add(new Pieza("muslo"));
		piezas1.add(new Pieza("muslo"));  	
    	List<Pieza>piezas2 = new LinkedList<Pieza>();
    	piezas2.add(new Pieza("pata2"));
    	piezas2.add(new Pieza("pata2"));
    	piezas2.add(new Pieza("vacio"));
    	piezas2.add(new Pieza("vacio"));
    	piezas2.add(new Pieza("pata1"));
    	piezas2.add(new Pieza("pata1"));
		
    	Pedido p1 = new Pedido(cliente1,piezas1);
    	Pedido p2 = new Pedido(cliente2,piezas2);
		
    	List<Criterio> criterios = new LinkedList<Criterio>();
    	criterios.add(new CriterioMenosPiezas());
    	criterios.add(new CriterioClienteFavorito(favoritos));
		Criterio c = new CriterioCompuesto(criterios);
		
		p1.setPuntage(c.puntuar(p1));
    	p2.setPuntage(c.puntuar(p2));
    	
    	assertEquals(p1.getPuntaje(), 38);
    	assertEquals(p2.getPuntaje(), -6);
    	
	}
	
}
