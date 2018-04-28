package SGP;

import java.util.LinkedList;
import java.util.List;

import SGP.Criterios.Criterio;
import SGP.Criterios.CriterioClienteFavorito;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarneTipo;
import junit.framework.TestCase;
public class CriterioClienteFavoritoTest extends TestCase {

	public void testPuntuar() {

		
		int local1 = 1;
		int local2 = 2;
		
		List<Integer> favoritos = new LinkedList<Integer>();
		favoritos.add(local1);
		
    	Pedido<Tipo> p1 = new PedidoCarneTipo();
    	p1.setLocal(local1);
    	p1.agregarItem(new Tipo("pata1"), 2.0);
		p1.agregarItem(new Tipo("pata3"), 1.0);
		p1.agregarItem(new Tipo("pata4"), 1.0);
		p1.agregarItem(new Tipo("muslo"), 1.0);
		p1.agregarItem(new Tipo("vacio"), 2.0);	
		
    	Pedido<Tipo> p2 = new PedidoCarneTipo();
    	p2.setLocal(local2);
    	p2.agregarItem(new Tipo("pata3"), 1.0);
		p2.agregarItem(new Tipo("pata4"), 1.0);
		p2.agregarItem(new Tipo("muslo"), 1.0);
		p2.agregarItem(new Tipo("vacio"), 3.0);
    	
    	Criterio c = new CriterioClienteFavorito(favoritos);
    	
    	assertEquals(c.puntuar(p1), 45);
    	assertEquals(c.puntuar(p2), 0);
    	
	}
	
}
