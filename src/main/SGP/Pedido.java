package main.SGP;

import java.util.LinkedList;
import java.util.List;

public class Pedido {
	List<Pieza>listaPedido;
	
	public Pedido() {
		listaPedido= new LinkedList<Pieza>();
	}
	
	public void agregarPieza(Pieza p) {
		listaPedido.add(p);
	}
	
	public void agregarPiezas(List<Pieza>piezas) {
		listaPedido.addAll(piezas);
	}
	
	public boolean pedidoVacio() {
		return listaPedido.isEmpty();
	}
	
	public List<Pieza> getPedido(){
		return listaPedido;
	}
	
	public int getCantidadPiezas() {
		return listaPedido.size();
	}

	@Override
	public String toString() {
		String ret = "Pedido:\n";
		for(Pieza p: listaPedido) {
			ret = ret+""+p.getNombrePieza()+"\n";			
		}
		return ret;
	}	

}
