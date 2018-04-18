package main.java.SGP;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GestordeStock implements Serializable {
	private int vacasaFaenar;
	private int vacasExistentes;
	private Map<Pieza,Integer>stock;
	
	public GestordeStock() {
		vacasaFaenar = 0;
		vacasExistentes = 0;
		stock = new HashMap<Pieza,Integer>();
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
	
	public Map<Pieza, Integer> getStock() {
		return stock;
	}

	public void setStock(Map<Pieza, Integer> stock) {
		this.stock = stock;
	}
	
	public int getCantidadVacasRestantes() {
		return vacasExistentes - vacasaFaenar;
	}

	public void solicitarVacas(){
		//Tenemos vacas infinitas!
		//Mando a faenar una vaca y aumento en 1 todos los elementos de mi stock.
		vacasaFaenar++;
		for(Entry<Pieza, Integer> mapaStock: stock.entrySet()) {
			Integer cantidad = mapaStock.getValue();
			cantidad = cantidad +1;
			mapaStock.setValue(cantidad);
			}
	}

	public void disminuirStock(Pieza pieza, int cantidad) {
		//En una futura implementación debemos tener en cuenta las vacas existentes y la cantidad de vacas
		for(Entry<Pieza, Integer>mapaStock: stock.entrySet()) {
			//Recorro el stock, busco la pieza de la cual que disminuir stock y le bajo la cantidad solicitda.
			if(pieza.equals(mapaStock.getKey())) {
				mapaStock.setValue(mapaStock.getValue()-cantidad);
			}
		}
	}
}
