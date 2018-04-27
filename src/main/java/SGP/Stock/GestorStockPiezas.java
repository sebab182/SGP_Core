package SGP.Stock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GestorStockPiezas extends GestorStock<Pieza> {
	
	private Set<Tipo> vaca;

	public GestorStockPiezas() {
		super();
		this._Stock=new LinkedList<Pieza>();
		this.vaca=new HashSet<Tipo>();
	}

	public void setCortesVaca(HashSet<Tipo> vaca)
	{
		this.vaca.addAll(vaca);
	}

	@Override
	public void agregarItem(Pieza item) {
		super.agregarItem(item);
	}

	@Override
	public void quitarItem(Pieza item) {
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
	
	public Set<Tipo> getVaca() {
		return vaca;
	}

}
