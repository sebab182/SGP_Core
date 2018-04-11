package main.SGP;

import java.util.LinkedList;
import java.util.List;

public class DistribuidorDePiezas {

	private Stock stock;
	
	public DistribuidorDePiezas(Stock stock) {
		this.stock = stock;
	}
	
	public Distribucion getDistribucion(Pedido pedido) {
		Distribucion d = null;
		
		// Se fija si el stock contiene las piezas pedidas.
		
		if (this.stock.getStock().containsAll(pedido.getPedido())) {
		
			// Si las contiene crea una distribucion con la piezas pedidas.	
			d = new Distribucion();
			d.agregarPiezas(pedido.getPedido());
			
			// Quita las piezas del stock.
			this.stock.quitarPiezas(d.getDistribucion());
			
		}
		else
			// Si no las contiene avisa que no hay stock.
			System.out.println("No hay stock para satisfacer el pedido");
		
		return d;
	}
	
	public List<Distribucion> getDistribuciones(List<Pedido> pedidos) {
		List<Distribucion> ret = new LinkedList<Distribucion>();
		for (Pedido p: pedidos) {

			// Se fija si hay stock.
			if (this.stock.stockVacio()) {
				
				// Si no hay deja de distribuir.
				System.out.println("Stock vacio: no queda ninguna pieza");
				break;
			}
			else {
				// Si hay se fija si puede crear una distribucion.
				Distribucion d = getDistribucion(p);
					if (d != null)
						ret.add(d);
			}
			
		}
		return ret;
	}
	
}
