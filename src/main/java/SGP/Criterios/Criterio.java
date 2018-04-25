package main.java.SGP.Criterios;

import main.java.SGP.Pedidos.Pedido;

public interface Criterio {
	
	int puntuar(Pedido pedido);
	
	//int sumar(ICriterio otro);
	
	//int priorizar(int importancia);

}
