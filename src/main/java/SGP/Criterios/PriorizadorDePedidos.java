package SGP.Criterios;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import SGP.Stock.Tipo;
import SGP.Pedidos.Pedido;

public class PriorizadorDePedidos {

	public static List<Pedido<Tipo>> priorizar(List<Pedido<Tipo>> pedidos, Criterio criterio) {
		
		// Preparo la lista de copia.
		List<Pedido<Tipo>> pedidos_copia = new LinkedList<Pedido<Tipo>>(pedidos);
		
		// Preparo la lista a devolver.
		List<Pedido<Tipo>> ret = new LinkedList<Pedido<Tipo>>();
		
		if (criterio != null) {
			
			ret = new LinkedList<Pedido<Tipo>>();
			
			// Creo el comparador.
			ComparadorDePedidos  comparador = new ComparadorDePedidos(pedidos_copia, criterio);
			
			// Ordeno los pedidos de mayor a menor.
			Collections.sort(pedidos_copia, comparador);
			
			if (Puntaje.hayEmpate(pedidos_copia, comparador.getPuntajes())
				&& criterio.hayOtroCriterio()) {
				/*
				 * Si hay empate separo en sublistas
				 * y ordeno recursivamente con el
				 * siguiente criterio.
				 */
					
				List<List<Pedido<Tipo>>> sublistas = Puntaje.sublistasDeEmpates(pedidos_copia, comparador.getPuntajes());
				
				for (List<Pedido<Tipo>> s: sublistas) {
					if (Puntaje.hayEmpate(s, comparador.getPuntajes()))
						priorizar(s, criterio.siguienteCriterio());
					for (Pedido<Tipo> p: s)
						ret.add(p);
				}
				
				
			}
			else
				ret = pedidos_copia;
		}
		else
			/*
			 *  Si el criterio es null devuelvo
			 *  la lista de pedidos.
			 */
			ret = pedidos_copia;
		return ret;
	}
	
}
