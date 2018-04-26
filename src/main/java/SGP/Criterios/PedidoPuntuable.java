package SGP.Criterios;

import SGP.Tipo;
import SGP.Pedidos.Pedido;

public class PedidoPuntuable implements Comparable<PedidoPuntuable>{
	
	private Pedido<Tipo> pedido;
	private int puntaje;
	
	public PedidoPuntuable(Pedido<Tipo> pedido) {
		this.pedido = pedido;
		this.puntaje = 0;
	}
	
	public Pedido<Tipo> getPedido() {
		return this.pedido;
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}
	
	public void setPuntaje(Criterio criterio) {
		this.puntaje = criterio.puntuar(this);
	}

	@Override
	public int compareTo(PedidoPuntuable o) {
		if (this.getPuntaje() > o.getPuntaje())
			return -1;
		else if (this.getPuntaje() < o.getPuntaje())
			return 1;
		return 0;
	}
	
	

}
