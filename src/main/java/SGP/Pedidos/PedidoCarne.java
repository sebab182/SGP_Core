package SGP.Pedidos;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import SGP.Stock.Tipo;

public class PedidoCarne extends Pedido<Tipo> implements Serializable{

	private static final long serialVersionUID = 1L;

	public PedidoCarne()
	{
		super();
		this._items=new HashMap<Tipo, Double>();
	}
	
	@Override
	public void agregarItem(Tipo item, Double cantidad) {
		super.agregarItem(item, cantidad);
	}

	@Override
	public void quitarItem(Tipo item) {
		super.quitarItem(item);
	}

	@Override
	public void vaciarPedido() {
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
