package main.java.SGP;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class GestordeStock implements Serializable {
	private int vacasaFaenar;
	private int vacasExistentes;
	private List<Pieza> stock;
	
	public GestordeStock() {
		vacasaFaenar = 0;
		vacasExistentes = 10;
		stock = new LinkedList<Pieza>();
	}
	
	public int getVacasaFaenar() {
		return vacasaFaenar;
	}

	public void setVacasaFaenar(int vacasaFaenar) {
		this.vacasaFaenar = vacasaFaenar;
	}

	public int getVacasExistentes() {
		return vacasExistentes;
	}

	public void setVacasExistentes(int vacasExistentes) {
		this.vacasExistentes = vacasExistentes;
	}
		
	public void setStock(List<Pieza> nuevoStock) {
		this.stock = nuevoStock;
	}

	public int getCantidadVacasRestantes() {
		return vacasExistentes - vacasaFaenar;
	}

	public void solicitarVacas(){
		
		if(vacasExistentes>0) {
			vacasExistentes--;
			vacasaFaenar++;
			//Mando a faenar una vaca y aumento en 1 todos los elementos de mi stock. Asumimos vacas infinitas.
			//Bajo la cantidad de vacas existentes.
			//La lista vaca tiene todas las piezas que obtengo de una vaca
			List<Pieza>vaca = new LinkedList<Pieza>();
			vaca.add(new Pieza(new Tipo("pata1"),new Date()));
			vaca.add(new Pieza(new Tipo("pata2"),new Date()));
			vaca.add(new Pieza(new Tipo("pata3"),new Date()));
			vaca.add(new Pieza(new Tipo("pata4"),new Date()));
			vaca.add(new Pieza(new Tipo("muslo"),new Date()));
			vaca.add(new Pieza(new Tipo("vacio"),new Date()));
			//Agrego la vaca al stock
			agregarPiezas(vaca);
			}
	}
	
	public void agregarPieza(Pieza pieza) {
		stock.add(pieza);
	}
	
	public void quitarPieza(Pieza pieza) {
		stock.remove(pieza);
	}
	
	public void agregarPiezas(List<Pieza>piezas) {
		stock.addAll(piezas);
	}

	public void quitarPiezas(List<Pieza> piezas) {
		stock.removeAll(piezas);
	}

	public List<Pieza> getStock() {
		return stock;
	}
	
	public boolean hayVacasDisponibles() {
		return vacasExistentes!=0;
	}
}
