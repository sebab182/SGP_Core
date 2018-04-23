package main.java.SGP;

import java.util.List;

public class CriterioClienteFavorito implements Criterio {

	private int puntaje;
	List<Cliente> clientes;
	
	public CriterioClienteFavorito(List<Cliente> clientes) {
		this.puntaje = 45;
		this.clientes = clientes;
	}
	
	@Override
	public int puntuar(Pedido pedido) {
		Cliente cliente = pedido.getCliente();
		
		if (this.clientes.contains(cliente))
			return this.puntaje;
		
		return 0;
	}

}
