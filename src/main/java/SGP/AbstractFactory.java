package main.java.SGP;

import java.util.List;
import java.util.Map;

public interface AbstractFactory {
	public List<Pieza>cargarPiezas();
	public GestordeStock cargarGestordeStock();
	public List<Map<Pieza,Integer>>cargarPedidos();
}