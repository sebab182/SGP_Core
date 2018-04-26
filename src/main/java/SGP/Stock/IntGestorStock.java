package SGP.Stock;

import java.util.List;

public abstract class IntGestorStock<T> {
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