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
		//Recorro cada pedido y me fijo si puedo resolver TODOS los items
		for(Pedido<Tipo> pedido: pedidos){
			Map<Tipo,Double> mapPiezas = pedido.get_items(); //Obtengo items del pedido
			boolean puedoResponderPedido=true;
			for(Entry<Tipo, Double> entryPedido: mapPiezas.entrySet()){ //Recorro cada entrada del pedido
				puedoResponderPedido = puedoResponderPedido && tengoStockparaPedido(entryPedido, stock); //Me fijo si puedo resolver el pedido
				}
			if(puedoResponderPedido==true) {
				pedidosAceptados.add(pedido);
				quitarPiezasStock(pedido,stock); //Como el pedido se aceptó, saco del stock las piezas y la cantidad solicitada.
			}
			else {
				pedidosRechazados.add(pedido);
			}}
	}
	
	private boolean tengoStockparaPedido(Entry<Tipo, Double> entryPedido, GestorStockPiezas stock) {
		Tipo tipoPedido = entryPedido.getKey();
		Double cantPedido = entryPedido.getValue();
		Double cantStock = (double) stock.contarPiezasTipoN(tipoPedido);
		int r = cantStock.compareTo(cantPedido); //r=1 es mayor la cantidad de stock, r=0 es igual stock a pedido, r=-1 es menor la cantidad de stock
		return r>=0; //Si es 0 o 1 puedo resolver el pedido.
	}
	
	public void resolverPedidosNivelAprobacion(HashSet<Pedido<Tipo>> pedidos, GestorStockPiezas stock){
		//Recorro cada pedido y me fijo si puedo resolver los pedidos de acuerdo a su nivel de aprobación
		for(Pedido<Tipo> pedido: pedidos){
			Map<Tipo,Double> mapPiezas = pedido.get_items(); //Obtengo items del pedido
			Integer cantPiezas=0;
			Integer totalItemsPedidos=0;
			for(Entry<Tipo, Double> entryPedidoExp: mapPiezas.entrySet()) {//Recorro cada entrada del pedido
				//Cuento el total del Stock y el total de items pedidos
				int totaltipoPieza = contarStockExistenteParaPedido(entryPedidoExp,stock);
				cantPiezas = cantPiezas + totaltipoPieza;
				totalItemsPedidos = totalItemsPedidos+ entryPedidoExp.getValue().intValue();
			}
			System.out.println("Total items pedidos "+ totalItemsPedidos + " cantPiezas existentes"+cantPiezas);
			Integer porcentajePedido = (cantPiezas*100/totalItemsPedidos);
			System.out.println("Porcentaje que se puede despachar: "+ porcentajePedido+ " y porcentaje satisfactorio "+ pedido.get_nivelAprobacion());
			if(analizarCriterio(pedido, porcentajePedido)==true) {
				System.out.println("Se acepta el pedido");
				pedidosAceptados.add(pedido);
				quitarPiezasStock(pedido,stock); //Como el pedido se aceptó, saco del stock las piezas y la cantidad solicitada.
			}
			else {
				System.out.println("Se rechaza el pedido");
				pedidosRechazados.add(pedido);
			}}
	}	
	
	private int contarStockExistenteParaPedido(Entry<Tipo, Double> entryPedidoExp, GestorStockPiezas stock) {
		Integer ret=0;
		Tipo tipoPedidoExp = entryPedidoExp.getKey();
		Double cantPedidoExp = entryPedidoExp.getValue();
		Double cantStock = (double) stock.contarPiezasTipoN(tipoPedidoExp);
		if(cantPedidoExp.compareTo(cantStock)>=0){
			ret= cantStock.intValue();	}
		else {
			ret = cantPedidoExp.intValue();}
		return ret;
	}
	
	private boolean analizarCriterio(Pedido<Tipo> pedido,int PorcentajeReal) {
		int PorcentajeAprobacion = pedido.get_nivelAprobacion();
		return PorcentajeReal>=PorcentajeAprobacion;
	}
	
	private void quitarPiezasStock(Pedido<Tipo> pedido, GestorStockPiezas stock) {
		Map<Tipo,Double> mapPiezas = pedido.get_items();
		for(Entry<Tipo, Double> entryPedido: mapPiezas.entrySet()){
			stock.quitarNPiezas(entryPedido.getKey(), entryPedido.getValue());
		}		
	}

	public List<Pedido<Tipo>> getPedidosRechazados() {
		return pedidosRechazados;
	}

	public List<Pedido<Tipo>> getPedidosAceptados() {
		return pedidosAceptados;
	}	
}
