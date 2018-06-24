package SGP.Pedidos;

import java.util.Map;
import java.util.Map.Entry;

public abstract class Pedido<T>{
	Local _Local;	
	Map<T, Integer> _items;
	int _nivelAprobacion;
	
	public double getNumeroItems() {
		double ret = 0;
		for (Entry<T, Integer> e: this._items.entrySet())
			ret = ret + e.getValue();
		return ret;
	}
	
	public void agregarItem(T item, Integer valor)
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
	
	public Map<T, Integer> get_items() {
		return _items;
	}

	public void set_items(Map<T, Integer> _items) {
		this._items = _items;
	}

	public Local get_Local() {
		return _Local;
	}

	public void set_Local(Local _Local) {
		this._Local = _Local;
	}

	public int get_nivelAprobacion() {
		return _nivelAprobacion;
	}

	public void set_nivelAprobacion(int _nivelAprobacion) {
		this._nivelAprobacion = _nivelAprobacion;
	}
}
