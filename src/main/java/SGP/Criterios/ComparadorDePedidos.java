package SGP.Criterios;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import SGP.Pedidos.Pedido;
import SGP.Stock.Tipo;

public class ComparadorDePedidos implements Comparator<Pedido<Tipo>>{

	private Map<Pedido<Tipo>, Integer> puntajes;
	
	public ComparadorDePedidos(List<Pedido<Tipo>> pedidos, Criterio criterio) {
		this.puntajes = Puntaje.puntuar(pedidos, criterio);
	}
	
	public Map<Pedido<Tipo>, Integer> getPuntajes() {
		return this.puntajes;
	}
	
	@Override
	public int compare(Pedido<Tipo> o1, Pedido<Tipo> o2) {
		// Ordena de menor a mayor.
		if (puntajes.get(o1) > puntajes.get(o2))
			return -1;
		else if (puntajes.get(o1) < puntajes.get(o2))
			return 1;
		return 0;
	}

}
