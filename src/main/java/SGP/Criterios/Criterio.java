package SGP.Criterios;

import SGP.Stock.Tipo;
import SGP.Pedidos.Pedido;

public interface Criterio {
	
	int puntuar(Pedido<Tipo> pedido);
	
	//int sumar(ICriterio otro);
	
	//int priorizar(int importancia);

}
