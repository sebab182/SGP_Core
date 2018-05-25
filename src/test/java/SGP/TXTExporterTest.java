package SGP;

import SGP.Exportador.TXTExporter;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;
import junit.framework.TestCase;

public class TXTExporterTest extends TestCase {
	private TXTExporter te;

	public void testGenerarInforme() {
		te = new TXTExporter("test",".");
		//te.generarInforme(cargarStockTest());
		//assertTrue(!te.getSalida().isEmpty());
	}

	public void testGetExtension() {
		te = new TXTExporter("test",".");
		assertEquals("txt",te.getExtension());
	}

	public void testGetSalida() {
		te = new TXTExporter("test",".");
		//te.generarInforme(cargarStockTest());
		//assertTrue(te.getSalida().contains("muslo"));
	}

	public GestorStockPiezas cargarStockTest() {
		GestorStockPiezas gsp = new GestorStockPiezas();
		gsp.agregarItem(new Pieza("muslo 25/05/18"));
		return gsp;
	}
}
