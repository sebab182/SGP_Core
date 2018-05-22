package SGP.Stock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import SGP.Pedidos.Pedido;

public class Distribuidor {
	List<Pedido<Tipo>>pedidosRechazados;
	List<Pedido<Tipo>>pedidosAceptados;
	
	public Distribuidor() {
		pedidosRechazados = new LinkedList<Pedido<Tipo>>();
		pedidosAceptados = new LinkedList<Pedido<Tipo>>();
	}
	
	public void resolverPedidos(HashSet<Pedido<Tipo>> pedidos, GestorStockPiezas stock){
		//Recorro cada pedido
		for(Pedido<Tipo> pedido: pedidos)
		{
			Map<Tipo,Double> mapPiezas = pedido.get_items(); //Obtengo items del pedido
			boolean puedoResponderPedido=true;
			for(Entry<Tipo, Double> entryPedido: mapPiezas.entrySet()) //Recorro cada entrada del pedido
			{
				puedoResponderPedido = puedoResponderPedido && contarStockparaPedido(entryPedido, stock); //Me fijo si puedo resolver el pedido
			}
			if(puedoResponderPedido==true) {
				pedidosAceptados.add(pedido);
				quitarPiezasStock(pedido,stock); //Como el pedido se aceptó, saco del stock las piezas y la cantidad solicitada.
			}
			else {
				pedidosRechazados.add(pedido);
			}}
	}
	
	private boolean contarStockparaPedido(Entry<Tipo, Double> entryPedido, GestorStockPiezas stock) {
		Tipo tipoPedido = entryPedido.getKey();
		Double cantPedido = entryPedido.getValue();
		List<Pieza>listaStock = stock.getStock();
		Double cantStock = (double) stock.contarPiezasTipoN(tipoPedido);
		/*for(Pieza p: listaStock) {
			if(p.getTipoPieza().equals(tipoPedido)) {
				cantStock++;
			}
		}*/
		int r = cantStock.compareTo(cantPedido); //r=1 es mayor la cantidad de stock, r=0 es igual stock a pedido, r=-1 es menor la cantidad de stock
		return r>=0; //Si es 0 o 1 puedo resolver el pedido.
	}

	private void quitarPiezasStock(Pedido<Tipo> pedido, GestorStockPiezas stock) {
		Map<Tipo,Double> mapPiezas = pedido.get_items();
		for(Entry<Tipo, Double> entryPedido: mapPiezas.entrySet())
		{
			quitarPieza(entryPedido,stock);
		}		
	}

	private void quitarPieza(Entry<Tipo, Double> entryPedido, GestorStockPiezas stock) {
		stock.quitarNPiezas(entryPedido.getKey(), entryPedido.getValue());
	}

	public List<Pedido<Tipo>> getPedidosRechazados() {
		return pedidosRechazados;
	}

	public List<Pedido<Tipo>> getPedidosAceptados() {
		return pedidosAceptados;
	}	
}
