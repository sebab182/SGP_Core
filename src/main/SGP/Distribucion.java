package main.SGP;

import java.util.LinkedList;
import java.util.List;

public class Distribucion {
	List<Pieza>distribucion;
	
	public Distribucion(){
		distribucion = new LinkedList<Pieza>();
	}
	
	public boolean distribucionVacia() {
		return distribucion.isEmpty();
	}
	
	public void agregarPieza(Pieza p) {
		distribucion.add(p);
	}
	
	public void quitarPieza(Pieza p) {
		distribucion.remove(p);
	}
	
	public void agregarPiezas(List<Pieza> piezas) {
		distribucion.addAll(piezas);
	}
	
	public void quitarPiezas(List<Pieza> piezas) {
		for(Pieza p: piezas) {
			distribucion.remove(p);
		}
	}
	
	public int getCantidadPiezas() {
		return distribucion.size();
	}
	
	public List<Pieza> getDistribucion(){
		return distribucion;
	}

	@Override
	public String toString() {
		String ret = "Distribución generada:\n";
		for(Pieza p: distribucion) {
			ret = ret+""+p.getNombrePieza()+"\n";			
		}
		return ret;
	}	

}
