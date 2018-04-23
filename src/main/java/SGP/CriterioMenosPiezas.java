package main.java.SGP;

import java.util.List;

public class CriterioMenosPiezas implements Criterio {

	private int prioridad;
	
	public CriterioMenosPiezas() {
		this.prioridad = 1;
	}
	
	public CriterioMenosPiezas(int prioridad) {
		this.prioridad = prioridad;
	}
	
	/* Si queda negativo no importa?
	* Este criterio resta mas puntos 
	* al pedido que mas piezas tiene.
	*/
	@Override
	public int puntuar(Pedido pedido) {
		return -pedido.getPiezas().size() * this.prioridad;
	}
	
}
