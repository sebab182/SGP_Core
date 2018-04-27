package SGP.Stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import SGP.Pedidos.Pedido;

public class AgrupadordePiezas {
	private Map<Tipo,Double>agrupacion;
	
	public AgrupadordePiezas() {
		agrupacion = new HashMap<Tipo,Double>();
	}
	
	public Map<Tipo,Double> agruparPedidos(List<Pedido<Tipo>>listaPedidos) {
		for(Pedido<Tipo> pedido: listaPedidos) {
			Map<Tipo,Double> mapPedido = pedido.get_items();
			for(Entry<Tipo, Double> entryPedido: mapPedido.entrySet()) {
				agruparPedido(entryPedido);
			}
	}
		return agrupacion;
}

	private void agruparPedido(Entry<Tipo, Double> entryPedido) {
		Tipo tipoPedido = entryPedido.getKey();
		Double cantPedido = entryPedido.getValue();
		if(agrupacion.containsKey(tipoPedido)) {
			agrupacion.put(tipoPedido, agrupacion.get(tipoPedido)+cantPedido);
		}
		else {
			agrupacion.put(tipoPedido, cantPedido);
		}
	}
}