package main.java.SGP.Stock;

import java.util.Map;

import main.java.SGP.Pieza;

public abstract class IntGestorStock<T> {
	Map<T, Double> _Stock;
	
	public void agregarItem(T item, Double valor)
	{
		//TODO controlar
		this._Stock.put(item, valor);
	}
	
	public void quitarItem(T item)
	{
		this._Stock.remove(item);
	}
	
	public void vaciarStock()
	{
		this._Stock.clear();
	}
	
}