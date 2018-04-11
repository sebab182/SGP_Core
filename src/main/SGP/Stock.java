package main.SGP;

import java.util.LinkedList;
import java.util.List;

public class Stock {
	
	List<Pieza>stock;
	
	public Stock() {
		stock = new LinkedList<Pieza>();
	}
	
	public boolean stockVacio() {
		return stock.isEmpty();
	}
	
	public void agregarPieza(Pieza p) {
		stock.add(p);
	}
	
	public void quitarPieza(Pieza p) {
		stock.remove(p);
	}
	
	public void agregarPiezas(List<Pieza> piezas) {
		stock.addAll(piezas);
	}
		
	public void quitarPiezas(List<Pieza> piezas) {
		for(Pieza p: piezas) {
			stock.remove(p);
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
