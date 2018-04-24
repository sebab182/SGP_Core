package main.java.SGP.Stock;

import java.util.List;
import java.util.Map;

import main.java.SGP.Pieza;

public abstract class IntGestorStockListas<T> {
	List<T> _Stock;
	
	public void agregarItem(T item)
	{
		//TODO controlar
		this._Stock.add(item);
	}
	
	public void quitarItem(T item)
	{
		this._Stock.remove(item);
	}
	
	public void vaciarStock()
	{
		this._Stock.clear();
	}
	
	public List<T> getStock(){
		return this._Stock;
	}
	
}