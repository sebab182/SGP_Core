package SGP.Datos;

import java.util.List;
import SGP.Pedidos.Pedido;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;


public interface AbstractFactory {
	public List<Pieza>cargarPiezas();
	public void cargarGestordeStock(GestorStockPiezas a);
	public List<Pedido<Tipo>> cargarPedidos();
}