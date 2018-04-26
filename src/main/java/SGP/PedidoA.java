package SGP;

import java.util.List;

public class PedidoA {
	
	private List<Pieza> piezas;
	private Cliente cliente;
	private int puntaje;
	
	public PedidoA(Cliente cliente, List<Pieza> piezas) {
		this.piezas = piezas;
		this.cliente = cliente;
		this.puntaje = 0;
	}
	
	public List<Pieza> getPiezas() {
		return this.piezas;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}
	
	public void setPuntage(int p) {
		this.puntaje = p;
	}

}
