package SGP.Stock;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class AnalizadordeVencimiento{

	public AnalizadordeVencimiento() {
	}

	public void analizarVencimientoPiezas(GestorStockPiezas gestorStock) {
		//No podemos eliminar directamente: java.util.ConcurrentModificationException --> Conflicto con for each
		List<Pieza>piezasVencidas = new LinkedList<Pieza>();
		List<Pieza>listaStock = gestorStock.getStock();
		Date fechaActual = new Date();
		for(Pieza p: listaStock) {
			Date fechaVencimiento = p.getFechaVencimiento();
			if(analizarVencimiento(fechaActual, fechaVencimiento)){
				piezasVencidas.add(p);
		}
	}
		for(Pieza piezaVencida: piezasVencidas) {
			gestorStock.quitarItem(piezaVencida);
		}
	}

	private boolean analizarVencimiento(Date fechaActual, Date fechaVencimiento) {
		return fechaActual.after(fechaVencimiento);
	}
}
