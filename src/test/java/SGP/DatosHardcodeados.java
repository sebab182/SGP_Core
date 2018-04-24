package test.java.SGP;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import main.java.SGP.AbstractFactory;
import main.java.SGP.GestordeStock;
import main.java.SGP.Pieza;
import main.java.SGP.Tipo;

public class DatosHardcodeados implements AbstractFactory {
	
	public DatosHardcodeados(){
	}

	public List<Pieza> cargarPiezas() {
		List<Pieza>piezas= new LinkedList<Pieza>();
		//date(año= 1900+años, mes<0 a 11>, día)
		piezas.add(new Pieza(new Tipo("pata1"),new Date(107,10,23)));
		piezas.add(new Pieza(new Tipo("pata2"),new Date(107,11,12)));
		piezas.add(new Pieza(new Tipo("pata3"),new Date(118,1,21)));
		piezas.add(new Pieza(new Tipo("pata4"),new Date(110,10,27)));
		piezas.add(new Pieza(new Tipo("muslo"),new Date(108,3,21)));
		piezas.add(new Pieza(new Tipo("vacio"),new Date(118,2,21)));
		piezas.add(new Pieza(new Tipo("falda"),new Date(118,2,23)));
		return piezas;
	}

	public List<Map<Tipo, Integer>> cargarPedidos() {
		List<Map<Tipo,Integer>>pedidos= new LinkedList<Map<Tipo,Integer>>();
		Map<Tipo, Integer>pedido1 = new HashMap<Tipo,Integer>();
    	pedido1.put(new Tipo("pata1"), 3);
    	pedido1.put(new Tipo("muslo"), 4);
    	pedidos.add(pedido1);
    	
		Map<Tipo, Integer>pedido2 = new HashMap<Tipo,Integer>();
    	pedido2.put(new Tipo("pata2"), 2);
    	pedido2.put(new Tipo("vacio"), 2);
    	pedido2.put(new Tipo("pata1"), 2);
    	pedidos.add(pedido2);
		return pedidos;
	}

	@Override
	public GestordeStock cargarGestordeStock() {
		GestordeStock gs = new GestordeStock();
		List<Pieza>stock = new LinkedList<Pieza>();
		stock.add(new Pieza(new Tipo("pata1"),new Date(107,10,23)));
		stock.add(new Pieza(new Tipo("pata2"),new Date(107,11,12)));
		stock.add(new Pieza(new Tipo("pata3"),new Date(118,1,21)));
		stock.add(new Pieza(new Tipo("pata4"),new Date(110,10,27)));
		stock.add(new Pieza(new Tipo("muslo"),new Date(108,3,21)));
		stock.add(new Pieza(new Tipo("vacio"),new Date(118,2,21)));
		gs.setVacasExistentes(10);
		gs.setStock(stock);
		return gs;
}

}
