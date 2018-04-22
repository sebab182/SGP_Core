package main.java.SGP;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DistribuidorConcreto extends Distribuidor{

	@Override
	public boolean puedoResolverPedido(Map<Pieza, Integer> pedido, Map<Pieza, Integer> stock) {
		boolean ret = true;
		
		for(Entry<Pieza, Integer> pedidoEntry: pedido.entrySet()) {
			Integer value = stock.get(pedidoEntry.getKey());
			if (value == null) {
				ret = false;
				break;
			}
			else
			ret = ret && pedidoEntry.getValue() <= value;		
		}
		return ret;
	}

	@Override
	public void solicitarVaca(Map<Pieza, Integer> stock) {
		for(Entry<Pieza, Integer> mapaStock: stock.entrySet()) {
			Integer cantidad = mapaStock.getValue();
			cantidad = cantidad +1;
			mapaStock.setValue(cantidad);
		}
	}

	@Override
	public Map<Pieza, Integer> resolverPedido(Map<Pieza, Integer> pedido, Map<Pieza, Integer> stock) {
		Map<Pieza, Integer> distribucion = new HashMap<Pieza, Integer>();

		for(Entry<Pieza, Integer> pedidoEntry: pedido.entrySet()) {
			// Agrego la pieza del pedido con su cantidad.
			distribucion.put(pedidoEntry.getKey(), pedidoEntry.getValue());
			// Disminuyo la cantidad del stock.
			stock.put(pedidoEntry.getKey(), stock.get(pedidoEntry.getKey()) - pedidoEntry.getValue());
		}
			
		return distribucion;
	}

	
	/*public List<HashMap<Pieza, Integer>> resolverPedidos(List<HashMap<Pieza, Integer>> pedidos) {
		List<HashMap<Pieza, Integer>>distribuciones = new LinkedList<HashMap<Pieza, Integer>>();
		for(HashMap<Pieza,Integer> pedido: pedidos) {
			HashMap<Pieza, Integer>distribucion = new HashMap<Pieza, Integer>();
			resolverPedido(pedido, distribucion);
			distribuciones.add(distribucion);
		}
		System.out.println("TOTAL VACAS A FAENAR: "+cantVacas);
		return distribuciones;
	}
	
	public void resolverPedido(HashMap<Pieza, Integer>pedido, HashMap<Pieza, Integer>distribucion) {
		//Recorro el pedido
		for(Entry<Pieza, Integer> mapaPedido: pedido.entrySet()) {
			Pieza piezaPedida = mapaPedido.getKey();
			
			for(Entry<Pieza, Integer>mapaStock: stock.entrySet()) {
				//Si las piezas son iguales ahora necesito ver cantidad en stock y repartir.
				if(piezaPedida.equals(mapaStock.getKey())) {
					distribuirPiezas(mapaPedido, mapaStock, distribucion);
				}
			}
		}
}
	
	private void distribuirPiezas(Entry<Pieza, Integer> mapaPedido, Entry<Pieza, Integer> mapaStock, Map<Pieza, Integer> distribucion) {
		Integer cantPedida = mapaPedido.getValue();
		Integer cantActual = mapaStock.getValue();
		while(cantActual<cantPedida){
			//Asumimos que tenemos infinitas vacas...
			System.out.println("NO ALCANZAN LAS VACAS PARA CUBRIR: "+mapaPedido+ " > STOCK ACTUAL: "+mapaStock);
			solicitarVacas();
			cantActual = mapaStock.getValue();
		}
		//Agrego la pieza al pedido con su cantidad
		distribucion.put(mapaPedido.getKey(), cantPedida);
		//Disminuyo la cantidad de stock
		mapaStock.setValue(cantActual-cantPedida);		
	}

	private void solicitarVacas() {
		//Esto hay que separarlo del distribuidor
		System.out.println("SOLICITANDO VACAS A FAENAR");
		for(Entry<Pieza, Integer> mapaStock: stock.entrySet()) {
			Integer cantidad = mapaStock.getValue();
			cantidad = cantidad +1;
			mapaStock.setValue(cantidad);
	}
		cantVacas++;
}*/
}
