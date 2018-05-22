package SGP.Criterios;

import SGP.Stock.Tipo;

import java.util.List;

import SGP.Pedidos.Pedido;

public interface Criterio {
	
	int puntuar(Pedido<Tipo> pedido);
	
	void combinar(Criterio criterio);
	
	public boolean hayOtroCriterio();
	
	public Criterio siguienteCriterio();

}
