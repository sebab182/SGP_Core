package main.java.SGP;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Distribuidor {
	
public abstract boolean puedoResolverPedido(Map<Pieza, Integer> pedido, Map<Pieza, Integer> stock);
	
	public abstract void solicitarVaca(Map<Pieza, Integer> stock);
	
	public abstract Map<Pieza, Integer> resolverPedido(Map<Pieza, Integer> pedido, Map<Pieza, Integer> stock);
	
	public List<Map<Pieza, Integer>> resolverPedidos(List<Map<Pieza, Integer>> listaPedidos, Map<Pieza, Integer> stock) {
		List<Map<Pieza, Integer>> listaDistribuciones = new LinkedList<Map<Pieza, Integer>>();
		
		for (Map<Pieza, Integer> pedido: listaPedidos) {
			
			while ( !puedoResolverPedido(pedido, stock) )
				solicitarVaca(stock);
			
			listaDistribuciones.add(resolverPedido(pedido, stock));
		}
		
		return listaDistribuciones;
	}
	
	/*Map<Pieza, Integer>stock;
	int cantVacas;
	
	Distribuidor(Map<Pieza, Integer> stock){
		this.stock=stock;
		cantVacas=0;
	}
	
	public List<HashMap<Pieza, Integer>> resolverPedidos(List<HashMap<Pieza, Integer>> pedidos) {
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
