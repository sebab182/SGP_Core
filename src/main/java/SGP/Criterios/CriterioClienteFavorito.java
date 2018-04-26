package SGP.Criterios;

import java.util.List;

import SGP.Cliente;
import SGP.Pedidos.Pedido;



public class CriterioClienteFavorito implements Criterio {

	private int puntaje;
	List<Cliente> clientes;
	
	public CriterioClienteFavorito(List<Cliente> clientes) {
		this.puntaje = 45;
		this.clientes = clientes;
	}
	
	@Override
	public int puntuar(Pedido pedido) {
		//TODO: Rever implementacion
		/*Cliente cliente = pedido.getCliente();
		
		if (this.clientes.contains(cliente))
			return this.puntaje;
		*/
		return 0;
	}

}
