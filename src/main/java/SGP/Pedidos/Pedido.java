package SGP.Pedidos;

import java.util.Map;

public abstract class Pedido<T>{
	int _nroLocal;	
	Map<T, Double> _items;
	
	public void agregarItem(T item, Double valor)
	{
		//TODO controlar
		this._items.put(item, valor);
	}
	
	public void quitarItem(T item)
	{
		this._items.remove(item);
	}
	
	public void vaciarPedido()
	{
		this._items.clear();
	}

	public Map<T, Double> get_items() {
		return _items;
	}

	public void set_items(Map<T, Double> _items) {
		this._items = _items;
	}
}
