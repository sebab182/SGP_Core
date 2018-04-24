package main.java.SGP.Pedidos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import main.java.SGP.Pieza;

/*Gestor de Pedidos, actua de mediador entre "pedidos" para realizar operaciones entre ellos*/
/*Patron mediator*/
public class GestorPedidosCarne implements IntGestorPedidos<PedidoCarne> {
	HashSet<PedidoCarne> _pedidos;
	
	public GestorPedidosCarne() {
		this._pedidos=new HashSet<PedidoCarne>();
	}

	@Override
	public void agregarPedido(PedidoCarne pedido) {
		this._pedidos.add(pedido);
	}

	@Override
	public void quitarPedido(PedidoCarne pedido) {
		this._pedidos.remove(pedido);
	}

	@Override
	public void vaciarPedidos() {
		this._pedidos.clear();
	}

	@Override
	public PedidoCarne menorPrioridad() {
		// TODO Auto-generated method stub
		//momentaneamente devuelvo el ultimo pedido
		PedidoCarne ultimo=null;
		for(PedidoCarne a:this._pedidos)
		{
			ultimo=a;
		}
		return ultimo;
	}

	public HashMap<Pieza, Double> totalPorPieza() {
		
		HashMap<Pieza, Double> totales=new HashMap<Pieza, Double>();
		
		//Calculo el total por cada pieza en TODOS los pedidos
		for(PedidoCarne a:this._pedidos)
		{
			for(Entry<Pieza, Double> item: a._items.entrySet())
			{
				
				if(totales.containsKey(item.getKey()))
				{
					totales.put(item.getKey(), totales.get(item.getKey())+item.getValue());
				}
				else
				{
					totales.put(item.getKey(), item.getValue());
				}
			}
		}
				
		return totales;
	}

	@Override
	public int totalPedidos() {
		// TODO Auto-generated method stub
		return 0;
	}


}
