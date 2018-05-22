package SGP.Criterios;

import SGP.Pedidos.Pedido;
import SGP.Stock.Tipo;

public class CriterioNull extends CriterioDecorador {

	public CriterioNull() {
		this.siguiente = null;
	}
	
	@Override
	public void combinar(Criterio criterio) {
		// Hace cualquier gilada xq no se usa XD
		@SuppressWarnings("unused")
		String s = "estoy haciendo una gilada";
	}

	@Override
	public int puntuar(Pedido<Tipo> pedido) {
		return 0;
	}
	
	
	
}
