package SGP.Criterios;

import SGP.Stock.Tipo;
import SGP.Pedidos.Pedido;

public class CriterioMenosPiezas extends CriterioDecorador {

	
	/* Si queda negativo no importa?
	* Este criterio resta mas puntos 
	* al pedido que mas piezas tiene.
	*/
	@Override
	public int puntuar(Pedido<Tipo> pedido) {
		return -1 * new Double(pedido.getNumeroItems()).intValue();
	}
	
}
