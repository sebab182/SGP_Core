package SGP.Criterios;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import SGP.Stock.Tipo;
import SGP.Pedidos.Pedido;

public class PriorizadorDePedidos {

	public List<Pedido<Tipo>> priorizar(List<Pedido<Tipo>> pedidos, Criterio criterio) {
		List<PedidoPuntuable> puntuados = new LinkedList<PedidoPuntuable>();
		
		// Puntuo los pedidos.
		for (Pedido<Tipo> p: pedidos) {
			PedidoPuntuable puntuado = new PedidoPuntuable(p);
			puntuado.setPuntaje(criterio);
			puntuados.add(puntuado);
		}
		
		// Ordeno los pedidos de mayor a menor.
		Collections.sort(puntuados);
		
		// Preparo la lista a devolver.
		List<Pedido<Tipo>> ret = new LinkedList<Pedido<Tipo>>();
		for (PedidoPuntuable p: puntuados)
			ret.add(p.getPedido());
		
		return ret;
	}
	
}
