package SGP.Pedidos;

import java.util.List;
import SGP.Stock.Tipo;

public interface SistemaPedidosProxy {
	public List<Pedido<Tipo>> cargarPedidos();
}
