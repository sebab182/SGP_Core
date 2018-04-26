package SGP.Datos;

import java.util.List;

import SGP.GestordeStock;
import SGP.Pieza;
import SGP.Tipo;
import SGP.Pedidos.Pedido;


public interface AbstractFactory {
	public List<Pieza>cargarPiezas();
	public GestordeStock cargarGestordeStock();
	public List<Pedido<Tipo>> cargarPedidos();
}