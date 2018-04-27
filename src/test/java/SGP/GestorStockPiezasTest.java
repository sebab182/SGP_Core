package SGP;

import java.util.Date;
import java.util.HashSet;

import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class GestorStockPiezasTest extends TestCase {

	GestorStockPiezas _gs;
	
	public GestorStockPiezasTest()
	{
		this._gs=null;
	}
	
	public void testVaciarStock() {
		this._gs=new GestorStockPiezas();
		this._gs.agregarItem(new Pieza(new Tipo("t1"),new Date()));
		this._gs.agregarItem(new Pieza(new Tipo("t2"),new Date()));

		this._gs.vaciarStock();
		
		assertEquals(this._gs.getStock().size(),0);
	}

	public void testSetCortesVaca() {
		this._gs=new GestorStockPiezas();
		
		HashSet<Tipo> cortes=new HashSet<Tipo>();
		cortes.add(new Tipo("t1"));
		cortes.add(new Tipo("t3"));
		cortes.add(new Tipo("t4"));
		
		this._gs.setCortesVaca(cortes);
		
		assertEquals(this._gs.getVaca().size(),3);
		
	}

	public void testAgregarItemPieza() {
		this._gs=new GestorStockPiezas();
		this._gs.agregarItem(new Pieza(new Tipo("t1"),new Date()));

		assertEquals(this._gs.getStock().size(),1);
	}

	public void testQuitarItemPieza() {
		this._gs=new GestorStockPiezas();
		Pieza p1 =new Pieza(new Tipo("t1"),new Date());
		Pieza p2 =new Pieza(new Tipo("t3"),new Date());
		this._gs.agregarItem(p1);
		this._gs.agregarItem(p2);
		
		this._gs.quitarItem(p1);
		
		assertEquals(this._gs.getStock().size(),1);
	}

}
