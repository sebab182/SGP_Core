package SGP.Pedidos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import SGP.Stock.Tipo;

/*Gestor de Pedidos, actua de mediador entre "pedidos" para realizar operaciones entre ellos*/
/*Patron mediator*/
public class GestorPedidosCarne implements IntGestorPedidos<Pedido<Tipo>> {
	HashSet<Pedido<Tipo>> _pedidos;
	
	public GestorPedidosCarne() {
		this._pedidos=new HashSet<Pedido<Tipo>>();
	}

	@Override
	public void agregarPedido(Pedido<Tipo> pedido) {
		this._pedidos.add(pedido);
	}

	@Override
	public void quitarPedido(Pedido<Tipo> pedido) {
		this._pedidos.remove(pedido);
	}

	@Override
	public void vaciarPedidos() {
		this._pedidos.clear();
	}

	@Override
	public Pedido<Tipo> menorPrioridad() {
		//momentaneamente devuelvo algun pedido
		Pedido<Tipo> ultimo=null;
		for(Pedido<Tipo> a:this._pedidos)
		{
			ultimo=a;
		}
		return ultimo;
	}

	public HashMap<Tipo, Double> totalPorPieza() {
		
		HashMap<Tipo, Double> totales=new HashMap<Tipo, Double>();
		
		//Calculo el total por cada pieza en TODOS los pedidos
		for(Pedido<Tipo> a:this._pedidos)
		{
			for(Entry<Tipo, Double> item: a._items.entrySet())
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
		return _pedidos.size();
	}

	@Override
	public String toString() {
		return _pedidos.toString();
	}
	
}
