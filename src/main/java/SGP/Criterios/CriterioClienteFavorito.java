package SGP.Criterios;

import java.util.List;
import java.util.Map;

import SGP.Stock.Tipo;
import SGP.Pedidos.Pedido;



public class CriterioClienteFavorito extends CriterioDecorador {

	Map<Integer, Integer> locales;
	
	public CriterioClienteFavorito(Map<Integer, Integer> locales) {
		this.locales = locales;
	}
	
	@Override
	public int puntuar(Pedido<Tipo> pedido) {
		
		int local = pedido.getLocal();
		
		if (this.locales.containsKey(local))
			return this.locales.get(local);
		
		return 0;
	}

}
