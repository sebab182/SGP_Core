package SGP.Criterios;

import SGP.Pedidos.Pedido;

public interface Criterio {
	
	int puntuar(Pedido pedido);
	
	//int sumar(ICriterio otro);
	
	//int priorizar(int importancia);

}
