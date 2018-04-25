package main.java.SGP;

import java.util.List;
import main.java.SGP.Pedidos.*;

public interface AbstractFactory {
	public List<Pieza>cargarPiezas();
	public GestordeStock cargarGestordeStock();
	public List<Pedido<Tipo>> cargarPedidos();
}