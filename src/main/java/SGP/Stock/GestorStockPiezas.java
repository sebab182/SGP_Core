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
	
	/*public void quitarNPiezas(Tipo tipo, Double cantQuitar) {
		Double cantQuitada =0.0;
		while(cantQuitada.compareTo(cantQuitar)<0) {
			for(int i=0; i<this._Stock.size();i++) {
				if(cantQuitada.equals(cantQuitar))
				{
					break;
				}
				Pieza p = _Stock.get(i);
				if(p.getTipoPieza().equals(tipo)) {
					_Stock.remove(p);
					cantQuitada++;
				}
			}
		}
	}*/
	
	public void quitarNPiezas(Tipo tipo, Integer cantQuitar) {
		List<Pieza> eliminar = filtrarPiezas(tipo);
		//Arme la lista de piezas a eliminar ahora saco la cantidad a Quitar
		if(cantQuitar>eliminar.size()) {
			cantQuitar= eliminar.size(); //Si la cantidad a quitar es mayor a la existente la cantidad a quitar es la cantidad de piezas existentes.
		}
		for(int i=0; i<cantQuitar;i++) {
			_Stock.remove(eliminar.get(i));
		}
	}

	public List<Pieza> filtrarPiezas(Tipo tipo) {
		List<Pieza> aux = new LinkedList<Pieza>();
		for(Pieza p: _Stock) {
			if(p.getTipoPieza().equals(tipo)) {
				aux.add(p);
			}
		}
		return aux;		
	}
	
	public int contarPiezasTipoN(Tipo tipo) {
		return filtrarPiezas(tipo).size();
	}
}
