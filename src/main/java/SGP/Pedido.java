package main.java.SGP;

import java.util.List;

public class Pedido {
	
	private List<Pieza> piezas;
	private Cliente cliente;
	private int puntaje;
	
	public Pedido(Cliente cliente, List<Pieza> piezas) {
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
