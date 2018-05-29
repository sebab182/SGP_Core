package SGP;

import SGP.Exportador.TXTExporter;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;
import junit.framework.TestCase;

public class TXTExporterTest extends TestCase {
	private TXTExporter te;
	
	public TXTExporterTest() {
		te = new TXTExporter("","");
	}

	public void testGenerarInforme() {
		te.generarInforme(cargarStockTest());
		assertTrue(!te.getSalida().isEmpty());
	}

	public void testGetExtension() {
		assertEquals("txt",te.getExtension());
	}

	public void testSetNombre() {
		te.setNombre("UNGS");
		assertEquals("UNGS",te.getNombre());
	}
	
	public void testGetSalida() {
		te.generarInforme(cargarStockTest());
		assertTrue(te.getSalida().contains("muslo"));
	}
	
	public void testSetPath() {
		te.setPath("C:\\");
		assertEquals("C:\\",te.getPath());
	}

	public GestorStockPiezas cargarStockTest() {
		GestorStockPiezas gsp = new GestorStockPiezas();
		gsp.agregarItem(new Pieza("muslo 25/05/18"));
		return gsp;
	}
}
