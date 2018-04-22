package main.java.SGP;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class GestordeStockN implements Serializable {
	private int vacasaFaenar;
	private int vacasExistentes;
	private List<PiezaN> stock;
	
	public GestordeStockN() {
		vacasaFaenar = 0;
		vacasExistentes = 10;
		stock = new LinkedList<PiezaN>();
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
		
	public void setNuevoStock(List<PiezaN> nuevoStock) {
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
			List<PiezaN>vaca = new LinkedList<PiezaN>();
			vaca.add(new PiezaN(new Tipo("pata1"),new Date()));
			vaca.add(new PiezaN(new Tipo("pata2"),new Date()));
			vaca.add(new PiezaN(new Tipo("pata3"),new Date()));
			vaca.add(new PiezaN(new Tipo("pata4"),new Date()));
			vaca.add(new PiezaN(new Tipo("muslo"),new Date()));
			vaca.add(new PiezaN(new Tipo("vacio"),new Date()));
			//Agrego la vaca al stock
			agregarPiezas(vaca);
			}
	}
	
	public void agregarPieza(PiezaN pieza) {
		stock.add(pieza);
	}
	
	public void quitarPieza(PiezaN pieza) {
		stock.remove(pieza);
	}
	
	public void agregarPiezas(List<PiezaN>piezas) {
		stock.addAll(piezas);
	}

	public void quitarPiezas(List<PiezaN> piezas) {
		stock.removeAll(piezas);
	}

	public List<PiezaN> getStock() {
		return stock;
	}
	
	public boolean hayVacasDisponibles() {
		return vacasExistentes!=0;
	}
}
