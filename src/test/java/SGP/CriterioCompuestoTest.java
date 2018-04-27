package SGP;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import SGP.Criterios.Cliente;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;
import junit.framework.TestCase;


public class CriterioCompuestoTest extends TestCase {
//TODO: Rehacer
	@SuppressWarnings("deprecation")
	public void testPuntuar() {
		
		Cliente cliente1 = new Cliente("pepito");
		List<Cliente> favoritos = new LinkedList<Cliente>();
		favoritos.add(cliente1);
		
	
		List<Pieza>piezas1 = new LinkedList<Pieza>();
		piezas1.add(new Pieza(new Tipo("pata1"),new Date(107,10,23)));
		piezas1.add(new Pieza(new Tipo("pata1"),new Date(107,11,12)));
		piezas1.add(new Pieza(new Tipo("pata3"),new Date(118,1,21)));
		piezas1.add(new Pieza(new Tipo("pata4"),new Date(110,10,27)));
		piezas1.add(new Pieza(new Tipo("muslo"),new Date(108,3,21)));
		piezas1.add(new Pieza(new Tipo("vacio"),new Date(118,2,21)));
		piezas1.add(new Pieza(new Tipo("vacio"),new Date(118,3,21)));	
    	List<Pieza>piezas2 = new LinkedList<Pieza>();
    	piezas2.add(new Pieza(new Tipo("pata3"),new Date(118,1,21)));
		piezas2.add(new Pieza(new Tipo("pata4"),new Date(110,10,27)));
		piezas2.add(new Pieza(new Tipo("muslo"),new Date(108,3,21)));
		piezas2.add(new Pieza(new Tipo("vacio"),new Date(118,2,21)));
		piezas2.add(new Pieza(new Tipo("vacio"),new Date(118,3,21)));	
		piezas2.add(new Pieza(new Tipo("vacio"),new Date(118,3,21)));	
		
    	/*
		Pedido p1 = new Pedido(cliente1,piezas1);
    	Pedido p2 = new Pedido(cliente2,piezas2);
		
    	List<Criterio> criterios = new LinkedList<Criterio>();
    	criterios.add(new CriterioMenosPiezas());
    	criterios.add(new CriterioClienteFavorito(favoritos));
		Criterio c = new CriterioCompuesto(criterios);
		
		p1.setPuntage(c.puntuar(p1));
    	p2.setPuntage(c.puntuar(p2));
    	
    	assertEquals(p1.getPuntaje(), 38);
    	assertEquals(p2.getPuntaje(), -6);*/
    	
	}
	
}
