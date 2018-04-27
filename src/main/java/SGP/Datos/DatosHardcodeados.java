package SGP.Datos;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import SGP.Datos.AbstractFactory;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;

public class DatosHardcodeados implements AbstractFactory {
//TODO: Eliminar!
	public DatosHardcodeados(){
	}

	@SuppressWarnings("deprecation")
	public List<Pieza> cargarPiezas() {
		List<Pieza>piezas= new LinkedList<Pieza>();
		//date(año= 1900+años, mes<0 a 11>, día)
		piezas.add(new Pieza(new Tipo("pata1"),new Date(107,10,23)));
		piezas.add(new Pieza(new Tipo("pata2"),new Date(107,11,12)));
		piezas.add(new Pieza(new Tipo("pata3"),new Date(118,1,21)));
		piezas.add(new Pieza(new Tipo("pata4"),new Date(110,10,27)));
		piezas.add(new Pieza(new Tipo("muslo"),new Date(108,3,21)));
		piezas.add(new Pieza(new Tipo("vacio"),new Date(118,2,21)));
		piezas.add(new Pieza(new Tipo("falda"),new Date(118,2,23)));
		return piezas;
	}

	public List<Pedido<Tipo>> cargarPedidos() {
		List<Pedido<Tipo>>pedidos= new LinkedList<Pedido<Tipo>>();
		Pedido<Tipo> a = new PedidoCarne();
		a.agregarItem(new Tipo("muslo"), 3.0);
		a.agregarItem(new Tipo("pata"), 5.0);
		pedidos.add(a);
		
		Pedido<Tipo> b = new PedidoCarne();
		b.agregarItem(new Tipo("vacio"), 4.0);
		b.agregarItem(new Tipo("muslo"), 7.0);
		b.agregarItem(new Tipo("pata"), 3.0);
		pedidos.add(b);		
		return pedidos;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void cargarGestordeStock(GestorStockPiezas a){
		
		LinkedList<Pieza> tmp=new LinkedList<Pieza>();
		HashSet<Tipo> vaca=new HashSet<Tipo> ();
		
		tmp.add(new Pieza(new Tipo("pata1"),new Date(107,10,23)));
		tmp.add(new Pieza(new Tipo("pata2"),new Date(107,11,12)));
		tmp.add(new Pieza(new Tipo("pata3"),new Date(118,1,21)));
		tmp.add(new Pieza(new Tipo("pata4"),new Date(110,10,27)));
		tmp.add(new Pieza(new Tipo("muslo"),new Date(108,3,21)));
		tmp.add(new Pieza(new Tipo("vacio"),new Date(118,2,21)));
		
		
		for(Pieza p:tmp)
		{
			a.agregarItem(p);
			vaca.add(p.getTipoPieza());
		}
		
		a.setCortesVaca(vaca);
		
		//gs.setVacasExistentes(10);
		//gs.setStock(stock);
}
}
