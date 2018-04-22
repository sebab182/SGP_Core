package main.java.SGP.Pedido;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.java.SGP.Pieza;

public class PedidoCarne extends Pedido<Pieza>{

	public PedidoCarne()
	{
		super();
		this._items=new HashMap<Pieza, Double>();
	}
	
	@Override
	public void agregarItem(Pieza item, Double cantidad) {
		// TODO Auto-generated method stub
		super.agregarItem(item, cantidad);
	}

	@Override
	public void quitarItem(Pieza item) {
		// TODO Auto-generated method stub
		super.quitarItem(item);
	}

	@Override
	public void vaciarPedido() {
		// TODO Auto-generated method stub
		super.vaciarPedido();
	}
	
	public Map<Pieza, Double> itemsPedidos()
	{
		return this._items;
	}
	

}
