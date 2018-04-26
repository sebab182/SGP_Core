package SGP.Criterios;

import java.util.List;

import SGP.Cliente;
import SGP.Pedidos.Pedido;



public class CriterioClienteFavorito implements Criterio {

	private int puntaje;
	List<Integer> locales;
	
	public CriterioClienteFavorito(List<Integer> locales) {
		this.puntaje = 45;
		this.locales = locales;
	}
	
	@Override
	public int puntuar(PedidoPuntuable pedido) {
		
		int local = pedido.getPedido().getLocal();
		
		if (this.locales.contains(local))
			return this.puntaje;
		
		return 0;
	}

}
