package SGP.Stock;

import java.util.LinkedList;
import java.util.List;

public class GestorStockPiezas extends GestorStock<Pieza> {

	public GestorStockPiezas() {
		super();
		this._Stock=new LinkedList<Pieza>();
	}

	@Override
	public void agregarItem(Pieza item) {
		// TODO Auto-generated method stub
		super.agregarItem(item);
	}

	@Override
	public void quitarItem(Pieza item) {
		// TODO Auto-generated method stub
		super.quitarItem(item);
	}

	@Override
	public void vaciarStock() {
		// TODO Auto-generated method stub
		super.vaciarStock();
	}

	@Override
	public List<Pieza> getStock() {
		// TODO Auto-generated method stub
		return super.getStock();
	}
}
