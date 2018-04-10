package main.SGP;

import java.util.LinkedList;
import java.util.List;

public class Stock {
	
	List<Pieza>stock;
	
	public Stock() {
		stock = new LinkedList<Pieza>();
	}
	
	public boolean stockVacio() {
		System.out.println(stock.size()==0);
		return stock.size()==0;
	}
	
	public void agregarPieza(Pieza p) {
		stock.add(p);
	}
	
	public void quitarPieza(Pieza p) {
		stock.remove(p);
	}
	
	public void agregarPiezas(List<Pieza> stock) {
		for(Pieza p: stock) {
			agregarPieza(p);
		}
	}
		
	public void quitarPiezas(List<Pieza> stock) {
		for(Pieza p: stock) {
			quitarPieza(p);
		}
	}
	
	public int getCantidadPiezas() {
		return stock.size();
	}
	
	public void vaciarStock() {
		stock.removeAll(stock);
	}
	
	public List<Pieza>getStock(){
		return stock;
		
	}

}
