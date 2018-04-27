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
		this._gs.agregarItem(new Pieza(pata1,new Date()));
		this._gs.agregarItem(new Pieza(pata2,new Date()));
		this._gs.agregarItem(new Pieza(pata2,new Date()));
		this._gs.agregarItem(new Pieza(pata1,new Date()));
		this._gs.agregarItem(new Pieza(pata1,new Date()));
		this._gs.agregarItem(new Pieza(pata3,new Date()));
				
				
		this._gp=new GestorPedidosCarne();
		
		PedidoCarne p1=new PedidoCarne();
		p1.agregarItem(pata1, 2.0);
		p1.agregarItem(pata3, 1.0);
		
		PedidoCarne p2=new PedidoCarne();
		p2.agregarItem(pata1, 1.0);
		p2.agregarItem(pata2, 5.0);		

		PedidoCarne p3=new PedidoCarne();
		p3.agregarItem(pata1, 1.0);
		p3.agregarItem(pata2, 2.0);		
		p3.agregarItem(pata3, 3.0);
		
		this._gp.agregarPedido(p1);
		this._gp.agregarPedido(p2);
		//this._gp.agregarPedido(p3);
		
		this._cp = new ControlProduccion();
		//Calculo total a Faenar
	}
	
	public void testCalcularFaena() {
		Double a=_cp.calcularFaena(_gp, _gs);
		
		assertEquals(a,3.0);
		
	}

	public void testSobrantes() {
		//TODO;
		assertTrue(true);
	}

}
