package SGP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import SGP.Criterios.Criterio;
import SGP.Criterios.CriterioClienteFavorito;
import SGP.Criterios.CriterioCompuesto;
import SGP.Criterios.CriterioMenosPiezas;
import SGP.Pedidos.Local;
import SGP.Pedidos.Pedido;
import SGP.Stock.Tipo;
import junit.framework.TestCase;


public class CriterioCompuestoTest extends TestCase {

	public void testPuntuar() {

		Local local1 = new Local("LP","mail");
		Local local2 = new Local("M","mail");
		
		Map<Local, Integer> favoritos = new HashMap<Local, Integer>();
		favoritos.put(local1, 1);
		
		
    	Pedido<Tipo> p1 = new PedidoMock(7.0, local1);
    	Pedido<Tipo> p2 = new PedidoMock(6.0, local2);
    	
    	Criterio c1 = new CriterioMenosPiezas();
    	Criterio c2 = new CriterioClienteFavorito(favoritos);
    	List<Criterio> criterios = new LinkedList<Criterio>();
    	criterios.add(c1);
    	criterios.add(c2);
    	Criterio cc = new CriterioCompuesto(criterios);
		

    	
    	assertEquals(cc.puntuar(p1), -6);
    	assertEquals(cc.puntuar(p2), -6);
    	
	}
	
}
