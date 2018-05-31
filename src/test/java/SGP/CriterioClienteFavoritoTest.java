package SGP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import SGP.Criterios.Criterio;
import SGP.Criterios.CriterioClienteFavorito;
import SGP.Pedidos.Local;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.Tipo;

import junit.framework.TestCase;
public class CriterioClienteFavoritoTest extends TestCase {

	public void testPuntuar() {

		Local local1 = new Local("LP","mail");
		Local local2 = new Local("M","mail");
		
		Map<Local, Integer> favoritos = new HashMap<Local, Integer>();
		favoritos.put(local1, 3);
		
		
    	Pedido<Tipo> p1 = new PedidoMock(local1);
    	Pedido<Tipo> p2 = new PedidoMock(local2);
    	
    	Criterio c = new CriterioClienteFavorito(favoritos);
    	
    	assertEquals(c.puntuar(p1), 3);
    	assertEquals(c.puntuar(p2), 0);
    	
	}
	
}
