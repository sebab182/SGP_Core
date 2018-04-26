package SGP.Pedidos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import SGP.Tipo;

/*Gestor de Pedidos, actua de mediador entre "pedidos" para realizar operaciones entre ellos*/
/*Patron mediator*/
public class GestorPedidosCarneTipo implements IntGestorPedidos<PedidoCarneTipo> {
	HashSet<PedidoCarneTipo> _pedidos;
	
	public GestorPedidosCarneTipo() {
		this._pedidos=new HashSet<PedidoCarneTipo>();
	}

	@Override
	public void agregarPedido(PedidoCarneTipo pedido) {
		this._pedidos.add(pedido);
	}

	@Override
	public void quitarPedido(PedidoCarneTipo pedido) {
		this._pedidos.remove(pedido);
	}

	@Override
	public void vaciarPedidos() {
		this._pedidos.clear();
	}

	@Override
	public PedidoCarneTipo menorPrioridad() {
		// TODO Auto-generated method stub
		//momentaneamente devuelvo el ultimo pedido
		PedidoCarneTipo ultimo=null;
		for(PedidoCarneTipo a:this._pedidos)
		{
			ultimo=a;
		}
		return ultimo;
	}

	public HashMap<Tipo, Double> totalPorPieza() {
		
		HashMap<Tipo, Double> totales=new HashMap<Tipo, Double>();
		
		//Calculo el total por cada pieza en TODOS los pedidos
		for(PedidoCarneTipo a:this._pedidos)
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
		// TODO Auto-generated method stub
		return 0;
	}


}
