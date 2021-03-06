package SGP.Criterios;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import SGP.Stock.Tipo;
import SGP.Pedidos.Pedido;


public class CriterioCompuesto extends CriterioDecorador{
	
	private final List<Criterio> criterios;
	
	public CriterioCompuesto(Collection<Criterio> c) {
		this.criterios = new LinkedList<Criterio>(c);
	}
	
	@Override
	public int puntuar(Pedido<Tipo> pedido) {
		int ret = 0;
		
		// Suma el puntaje que le da cada criterio.
		for (Criterio c: this.criterios)
			ret = ret + c.puntuar(pedido);
		
		return ret;
	}



}
