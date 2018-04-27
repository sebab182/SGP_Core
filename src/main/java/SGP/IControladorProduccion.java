package SGP;

import java.util.List;

import SGP.Pedidos.GestorPedidosCarne;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;

public interface IControladorProduccion {

	public List<Pieza> sobrantes();
	public Double calcularFaena(GestorPedidosCarne pedidos, GestorStockPiezas stock);
	
}
