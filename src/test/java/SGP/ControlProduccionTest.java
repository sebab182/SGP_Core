package SGP;

import java.util.Date;
import java.util.List;

import SGP.Pedidos.GestorPedidosCarne;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class ControlProduccionTest extends TestCase {

	ControlProduccion _cp;
	GestorStockPiezas _gs;
	GestorPedidosCarne _gp;
	
	public ControlProduccionTest()
	{
		_gs=new GestorStockPiezas(); 
	
		Tipo pata1=new Tipo("Pata 1");
		Tipo pata2=new Tipo("Pata 2");
		Tipo pata3=new Tipo("Pieza 3");
		
		this._gs=new GestorStockPiezas();
		this._gs.agregarItem(new Pieza("pata1 31/05/2018 l"));
		this._gs.agregarItem(new Pieza("pata2 31/05/2018 l"));
		this._gs.agregarItem(new Pieza("pata2 31/05/2018 l"));
		this._gs.agregarItem(new Pieza("pata1 31/05/2018 l"));
		this._gs.agregarItem(new Pieza("pata1 31/05/2018 c"));
		this._gs.agregarItem(new Pieza("pata3 31/05/2018 c"));
				
		this._gp=new GestorPedidosCarne();
		
		PedidoCarne p1=new PedidoCarne();
		p1.agregarItem(pata1, 2);
		p1.agregarItem(pata3, 1);
		
		PedidoCarne p2=new PedidoCarne();
		p2.agregarItem(pata1, 1);
		p2.agregarItem(pata2, 3);		

		PedidoCarne p3=new PedidoCarne();
		p3.agregarItem(pata1, 1);
		p3.agregarItem(pata2, 2);		
		p3.agregarItem(pata3, 3);
		
		this._gp.agregarPedido(p1);
		this._gp.agregarPedido(p2);
		//this._gp.agregarPedido(p3);
		
		this._cp = new ControlProduccion();
		//Calculo total a Faenar
	}
	
	public void testCalcularFaena() {
		Integer a=_cp.calcularFaena(_gp, _gs);
		assertEquals(a,new Integer(3));
		
	}

	public void testSobrantes() {
		//TODO;
		assertTrue(true);
	}

}
