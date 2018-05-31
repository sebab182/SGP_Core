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
		this._gs.agregarItem(new Pieza("t1 22/08/18 l"));
		this._gs.agregarItem(new Pieza("t2 22/08/18 l"));

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
		this._gs.agregarItem(new Pieza("t1 22/08/18 l"));

		assertEquals(this._gs.getStock().size(),1);
	}

	public void testQuitarItemPieza() {
		this._gs=new GestorStockPiezas();
		Pieza p1 =new Pieza("t1 22/08/18 l");
		Pieza p2 =new Pieza("t3 22/08/18 l");
		this._gs.agregarItem(p1);
		this._gs.agregarItem(p2);
		
		this._gs.quitarItem(p1);
		
		assertEquals(this._gs.getStock().size(),1);
	}

}
