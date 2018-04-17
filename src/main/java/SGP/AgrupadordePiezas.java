package main.java.SGP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AgrupadordePiezas {
	private Map<Pieza,Integer>agrupador;
	
	public AgrupadordePiezas() {
		agrupador = new HashMap<Pieza,Integer>();
	}
	
	public Map<Pieza,Integer> agruparPedidos(List<Map<Pieza,Integer>>listaPedidos) {
		for(Map<Pieza,Integer> pedido: listaPedidos) {
			for(Entry<Pieza, Integer> entryPedido: pedido.entrySet()) {
				agruparPedido(entryPedido);
			}
	}
		return agrupador;
}

	private void agruparPedido(Entry<Pieza, Integer> entryPedido) {
		Pieza piezaPedido = entryPedido.getKey();
		Integer cantPedido = entryPedido.getValue();
		if(agrupador.containsKey(piezaPedido)) {
			agrupador.put(piezaPedido, agrupador.get(piezaPedido)+cantPedido);
		}
		else {
			agrupador.put(piezaPedido, cantPedido);
		}
		
	}
}