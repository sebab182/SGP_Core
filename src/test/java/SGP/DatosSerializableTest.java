package SGP;

import SGP.Datos.DatosSerializable;
import SGP.Stock.GestorStockPiezas;
import junit.framework.TestCase;

public class DatosSerializableTest extends TestCase {
	private DatosSerializable ds;

	public DatosSerializableTest() throws ClassNotFoundException {
		ds = new DatosSerializable();
	}
	public void testCargarPiezas() {
		assertTrue(ds.cargarPiezas().size()==7);
	}

	public void testCargarPedidos() {
		assertEquals(ds.cargarPedidos().size(),3);
	}

	public void testCargarGestordeStock() {
		GestorStockPiezas gs= new GestorStockPiezas();
		ds.cargarGestordeStock(null);
		assertTrue(gs.getStock().isEmpty()==false);
	}

}
