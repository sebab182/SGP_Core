package SGP;
import SGP.Exportador.XLSExporter;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;
import junit.framework.TestCase;

public class XLSExporterTest extends TestCase {
	private XLSExporter xe;
	
	public XLSExporterTest() {
		xe = new XLSExporter("","");
	}
	
	public void testGenerarInforme() {
		xe.generarInforme(cargarStockTest());
		assertTrue(!xe.getSalida().isEmpty());
	}

	public void testSetNombre() {
		xe.setNombre("UNGS");
		assertEquals("UNGS",xe.getNombre());
	}

	public void testSetPath() {
		xe.setPath("C:\\");
		assertEquals("C:\\",xe.getPath());
	}

	public void testGetSalida() {
		xe.generarInforme(cargarStockTest());
		assertTrue(xe.getSalida().contains("muslo"));
	}
	
	public GestorStockPiezas cargarStockTest() {
		GestorStockPiezas gsp = new GestorStockPiezas();
		gsp.agregarItem(new Pieza("muslo 25/05/18"));
		return gsp;
	}
}