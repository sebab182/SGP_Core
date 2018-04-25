package main.java.SGP.Pedidos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.java.SGP.Pieza;
import main.java.SGP.Tipo;

public class PedidoCarneTipo extends Pedido<Tipo>{

	public PedidoCarneTipo()
	{
		super();
		this._items=new HashMap<Tipo, Double>();
	}
	
	@Override
	public void agregarItem(Tipo item, Double cantidad) {
		// TODO Auto-generated method stub
		super.agregarItem(item, cantidad);
	}

	@Override
	public void quitarItem(Tipo item) {
		// TODO Auto-generated method stub
		super.quitarItem(item);
	}

	@Override
	public void vaciarPedido() {
		// TODO Auto-generated method stub
		super.vaciarPedido();
	}
	
	public Map<Tipo, Double> itemsPedidos()
	{
		return this._items;
	}

	@Override
	public String toString() {
		return this._items.toString();
	}
	
	
	

}
