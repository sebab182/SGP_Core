package SGP.Criterios;

import java.util.List;
import java.util.Map.Entry;

import SGP.Tipo;
import SGP.Pedidos.Pedido;

public class CriterioMenosPiezas implements Criterio {

	private int puntos_pieza;
	
	public CriterioMenosPiezas() {
		this.puntos_pieza = 1;
	}
	
	public CriterioMenosPiezas(int puntos_pieza) {
		this.puntos_pieza = puntos_pieza;
	}
	
	/* Si queda negativo no importa?
	* Este criterio resta mas puntos 
	* al pedido que mas piezas tiene.
	*/
	@Override
	public int puntuar(PedidoPuntuable pedido) {
		int cantidad_piezas = 0;
		
		// Sumo la cantidad de piezas de cada tipo.
		for (Entry<Tipo, Double> e: pedido.getPedido().get_items().entrySet())
			
			// conviene int ???
			cantidad_piezas = cantidad_piezas + e.getValue().intValue();
		
		return -cantidad_piezas * this.puntos_pieza;
	}
	
}
