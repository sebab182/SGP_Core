package SGP;

import java.util.List;
import SGP.Pedidos.Pedido;


public interface AbstractFactory {
	public List<Pieza>cargarPiezas();
	public GestordeStock cargarGestordeStock();
	public List<Pedido<Tipo>> cargarPedidos();
}