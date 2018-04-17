package main.java.SGP;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Distribuidor {
	
	Distribuidor(){
		
	}
	
	public List<Map<Pieza, Integer>> resolverPedidos(List<Map<Pieza, Integer>> pedidos, GestordeStock stock){
		List<Map<Pieza, Integer>>distribuciones = new LinkedList<Map<Pieza, Integer>>();
		for(Map<Pieza,Integer> pedido: pedidos) {
			HashMap<Pieza, Integer>distribucion = new HashMap<Pieza, Integer>();
			if(pedido!=null) {
				resolverPedido(pedido, distribucion, stock);
				distribuciones.add(distribucion);
			}
		}
		return distribuciones;
	}
	
	public void resolverPedido(Map<Pieza, Integer>pedido, HashMap<Pieza, Integer>distribucion, GestordeStock stock) {
		//Recorro el pedido
		for(Entry<Pieza, Integer> mapaPedido: pedido.entrySet()) {
			Pieza piezaPedida = mapaPedido.getKey();
			
			for(Entry<Pieza, Integer>mapaStock: stock.getStock().entrySet()) {
				//Si las piezas son iguales ahora necesito ver cantidad en stock y repartir.
				if(piezaPedida.equals(mapaStock.getKey())) {
					distribuirPiezas(mapaPedido, mapaStock, distribucion, stock);
				}
			}
		}
}
	
	private void distribuirPiezas(Entry<Pieza, Integer> mapaPedido, Entry<Pieza, Integer> mapaStock, Map<Pieza, Integer> distribucion, GestordeStock stock) {
		Integer cantPedida = mapaPedido.getValue();
		Integer cantActual = mapaStock.getValue();
		while(cantActual<cantPedida){
			//Asumimos que tenemos infinitas vacas...
			System.out.println("NO ALCANZAN LAS VACAS PARA CUBRIR: "+mapaPedido+ " > STOCK ACTUAL: "+mapaStock);
			stock.solicitarVacas();
			cantActual = mapaStock.getValue();
		}
		//Agrego la pieza al pedido con su cantidad
		distribucion.put(mapaPedido.getKey(), cantPedida);
		//Disminuyo la cantidad de stock
		stock.disminuirStock(mapaPedido.getKey(),cantPedida);		
	}

	}