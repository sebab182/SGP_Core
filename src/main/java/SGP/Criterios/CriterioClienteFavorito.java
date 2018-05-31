package SGP.Criterios;

import java.util.Map;

import SGP.Stock.Tipo;
import SGP.Pedidos.Local;
import SGP.Pedidos.Pedido;



public class CriterioClienteFavorito extends CriterioDecorador {


	Map<Local, Integer> locales;
	
	public CriterioClienteFavorito(Map<Local, Integer> locales) {
		this.locales = locales;
	}
	
	@Override
	public int puntuar(Pedido<Tipo> pedido) {
		
		Local local = pedido.getLocal();
		
		if (this.locales.containsKey(local))
			return this.locales.get(local);
		
		return 0;
	}

}
