package SGP.Datos;

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
		piezas.add(new Pieza(new Tipo("pata1"),new Date(118,10,23)));
		piezas.add(new Pieza(new Tipo("pata1"),new Date(108,10,23)));
		piezas.add(new Pieza(new Tipo("pata2"),new Date(118,11,12)));
		piezas.add(new Pieza(new Tipo("pata3"),new Date(118,1,21)));
		piezas.add(new Pieza(new Tipo("pata4"),new Date(118,10,27)));
		piezas.add(new Pieza(new Tipo("muslo"),new Date(118,3,21)));
		piezas.add(new Pieza(new Tipo("vacio"),new Date(118,2,21)));
		piezas.add(new Pieza(new Tipo("falda"),new Date(118,2,23)));
		return piezas;
	}

	public List<Pedido<Tipo>> cargarPedidos() {
		List<Pedido<Tipo>>pedidos= new LinkedList<Pedido<Tipo>>();
		Pedido<Tipo> a = new PedidoCarne();
		Local l1 = new Local("Los Polvorines","lpolvorines@gmail.com");
		a.setLocal(l1);
		a.agregarItem(new Tipo("muslo"), 3.0);
		a.agregarItem(new Tipo("pata"), 5.0);
		pedidos.add(a);
		
		Pedido<Tipo> b = new PedidoCarne();
		Local l2 = new Local("Munro","lmunro@gmail.com");
		b.setLocal(l2);
		b.agregarItem(new Tipo("vacio"), 4.0);
		b.agregarItem(new Tipo("muslo"), 7.0);
		b.agregarItem(new Tipo("pata"), 3.0);
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
