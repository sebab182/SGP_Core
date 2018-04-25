package main.java.SGP.Stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import main.java.SGP.Tipo;
import main.java.SGP.Pedidos.Pedido;
//TODO: Rehacer esto!
public class AgrupadordePiezas {
	private Map<Tipo,Integer>agrupacion;
	
	public AgrupadordePiezas() {
		agrupacion = new HashMap<Tipo,Integer>();
	}
	
	public Map<Tipo,Integer> agruparPedidos(List<Pedido<Tipo>>listaPedidos) {
		for(Pedido<Tipo> pedido: listaPedidos) {
			/*for(Entry<Tipo, Integer> entryPedido: pedido.entrySet()) {
				agruparPedido(entryPedido);
			}
	}*/
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