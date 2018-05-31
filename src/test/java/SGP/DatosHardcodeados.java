package SGP;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import SGP.Datos.AbstractFactory;
import SGP.Pedidos.Local;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;

public class DatosHardcodeados implements AbstractFactory {
//TODO: No pudimos cargar la clase datos hardcodeados que está en el paquete Test, desde el paquete Main!
	public DatosHardcodeados(){
	}

	@SuppressWarnings("deprecation")
	public List<Pieza> cargarPiezas() {
		List<Pieza>piezas= new LinkedList<Pieza>();
		//date(año= 1900+años, mes<0 a 11>, día)
		piezas.add(new Pieza("pata1 25/05/18"));
		piezas.add(new Pieza("pata1 12/07/20 l"));
		piezas.add(new Pieza("pata1 07/09/20 l"));
		piezas.add(new Pieza("pata1 08/08/20 l"));
		piezas.add(new Pieza("pata1 09/05/20 c"));
		piezas.add(new Pieza("pata1 09/25/20 c"));
		
		piezas.add(new Pieza("pata2 08/05/20 l"));
		piezas.add(new Pieza("pata2 11/15/20 l"));
		piezas.add(new Pieza("pata2 10/15/20 c"));
		piezas.add(new Pieza("pata2 12/05/20 l"));
		piezas.add(new Pieza("pata2 11/05/20 c"));
				
		piezas.add(new Pieza("muslo 08/05/20 c"));
		piezas.add(new Pieza("muslo 09/05/20 c"));
		piezas.add(new Pieza("muslo 01/25/20 c"));
		
		piezas.add(new Pieza("vacio 04/18/20 l"));
		
		piezas.add(new Pieza("falda 07/25/20 c"));
		return piezas;
	}

	public List<Pedido<Tipo>> cargarPedidos() {
		List<Pedido<Tipo>>pedidos= new LinkedList<Pedido<Tipo>>();
		Pedido<Tipo> a = new PedidoCarne();
		Local l1 = new Local("Los Polvorines","lpolvorines@gmail.com");
		a.setLocal(l1);
		a.agregarItem(new Tipo("muslo"), 3.0);
		a.agregarItem(new Tipo("pata1"), 5.0);
		a.agregarItem(new Tipo("pata2"), 5.0);
		pedidos.add(a);
		
		Pedido<Tipo> b = new PedidoCarne();
		Local l2 = new Local("Munro","lmunro@gmail.com");
		b.setLocal(l2);
		b.agregarItem(new Tipo("vacio"), 4.0);
		b.agregarItem(new Tipo("muslo"), 7.0);
		b.agregarItem(new Tipo("pata1"), 3.0);
		b.agregarItem(new Tipo("pata2"), 4.0);
		pedidos.add(b);		
		return pedidos;
	}

	@Override
	public HashSet<Tipo> cargarConjuntoVaca() {
		HashSet<Tipo> vaca=new HashSet<Tipo> ();
		vaca.add(new Tipo("pata1"));
		vaca.add(new Tipo("pata2"));
		vaca.add(new Tipo("pata3"));
		vaca.add(new Tipo("pata4"));
		vaca.add(new Tipo("muslo"));
		vaca.add(new Tipo("vacio"));
		vaca.add(new Tipo("falda"));
		return vaca;
		
	}
}
