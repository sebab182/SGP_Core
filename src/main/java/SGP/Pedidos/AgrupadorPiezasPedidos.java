package SGP.Pedidos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import SGP.Stock.Tipo;

public class AgrupadorPiezasPedidos {
	private Map<Tipo,Integer>agrupacion;
	
	public AgrupadorPiezasPedidos() {
		agrupacion = new HashMap<Tipo,Integer>();
	}
	
	public Map<Tipo,Integer> agruparPedidos(List<Pedido<Tipo>>listaPedidos) {
		for(Pedido<Tipo> pedido: listaPedidos) {
			Map<Tipo,Integer> mapPedido = pedido.get_items();
			for(Entry<Tipo, Integer> entryPedido: mapPedido.entrySet()) {
				agruparPedido(entryPedido);
			}
	}
		return agrupacion;
}

	private void agruparPedido(Entry<Tipo, Integer> entryPedido) {
		Tipo tipoPedido = entryPedido.getKey();
		Integer cantPedido = entryPedido.getValue();
		if(agrupacion.containsKey(tipoPedido)) {
			agrupacion.put(tipoPedido, agrupacion.get(tipoPedido)+cantPedido);
		}
		else {
			agrupacion.put(tipoPedido, cantPedido);
		}
	}
}