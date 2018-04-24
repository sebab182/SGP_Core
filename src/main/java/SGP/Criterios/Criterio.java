package main.java.SGP.Criterios;

import main.java.SGP.Pedido;

public interface Criterio {
	
	int puntuar(Pedido pedido);
	
	//int sumar(ICriterio otro);
	
	//int priorizar(int importancia);

}
