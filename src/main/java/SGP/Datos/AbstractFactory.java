package SGP.Datos;

import java.util.HashSet;
import java.util.List;
import SGP.Pedidos.Pedido;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;


public interface AbstractFactory {
	public List<Pieza>cargarPiezas();
	public HashSet<Tipo> cargarConjuntoVaca();
	public List<Pedido<Tipo>> cargarPedidos();
}