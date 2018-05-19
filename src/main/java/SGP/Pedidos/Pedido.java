package SGP.Pedidos;

import java.util.Map;

public abstract class Pedido<T>{
	Local _Local;	
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

	public Local getLocal() {
		return this._Local;
	}
	

	public void setLocal(Local l) {
		this._Local=l;
	}	
	
	public Map<T, Double> get_items() {
		return _items;
	}

	public void set_items(Map<T, Double> _items) {
		this._items = _items;
	}
}
