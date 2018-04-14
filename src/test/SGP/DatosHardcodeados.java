package test.SGP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import main.SGP.AbstractFactory;
import main.SGP.GestordeStock;
import main.SGP.Pieza;

public class DatosHardcodeados implements AbstractFactory {

	public List<Pieza> cargarPiezas() {
		List<Pieza>piezas= new LinkedList<Pieza>();
		piezas.add(new Pieza("pata1"));
		piezas.add(new Pieza("pata2"));
		piezas.add(new Pieza("pata3"));
		piezas.add(new Pieza("pata4"));
		piezas.add(new Pieza("muslo"));
		piezas.add(new Pieza("vacio"));
		return piezas;
	}

	public Map<Pieza, Integer> cargarStock() {
		Map<Pieza, Integer>stock = new HashMap<Pieza,Integer>();
		stock.put(new Pieza("pata1"), 8);
		stock.put(new Pieza("pata2"), 5);
		stock.put(new Pieza("muslo"), 3);
		stock.put(new Pieza("pata3"), 2);
		stock.put(new Pieza("vacio"), 7);
		stock.put(new Pieza("pata4"), 4);
		return stock;
	}

	public List<Map<Pieza, Integer>> cargarPedidos() {
		List<Map<Pieza,Integer>>pedidos= new LinkedList<Map<Pieza,Integer>>();
		Map<Pieza, Integer>pedido1 = new HashMap<Pieza,Integer>();
    	pedido1.put(new Pieza("pata1"), 3);
    	pedido1.put(new Pieza("muslo"), 4);
    	pedidos.add(pedido1);
    	
		Map<Pieza, Integer>pedido2 = new HashMap<Pieza,Integer>();
    	pedido2.put(new Pieza("pata2"), 2);
    	pedido2.put(new Pieza("vacio"), 2);
    	pedidos.add(pedido2);
		return pedidos;
	}

	@Override
	public GestordeStock cargarGestordeStock() {
		GestordeStock gs = new GestordeStock();
		gs.setVacasExistentes(10);
		return null;
	}

}
