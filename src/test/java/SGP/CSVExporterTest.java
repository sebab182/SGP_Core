package SGP;
import SGP.Exportador.CSVExporter;
import SGP.Exportador.TXTExporter;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;
import junit.framework.TestCase;

public class CSVExporterTest extends TestCase {
	private CSVExporter ce;
	
	public CSVExporterTest() {
		ce = new CSVExporter("","");
	}
	
	public void testGenerarInforme() {
		ce.generarInforme(cargarStockTest());
		assertTrue(!ce.getSalida().isEmpty());
	}

	public void testGetSalida() {
		ce.generarInforme(cargarStockTest());
		assertTrue(ce.getSalida().contains("muslo"));
	}
	
	public void testGetExtension() {
		assertEquals("csv",ce.getExtension());
	}

	public void testSetNombre() {
		ce.setNombre("UNGS");
		assertEquals("UNGS",ce.getNombre());
	}

	public void testSetPath() {
		ce.setPath("C://");
		assertEquals("C://",ce.getPath());
	}
	
	public void testCSV() {
		CSVExporter aux = new CSVExporter();
		assertTrue(aux.getSalida()==null);
	}
	
	public GestorStockPiezas cargarStockTest() {
		GestorStockPiezas gsp = new GestorStockPiezas();
		gsp.agregarItem(new Pieza("muslo 25/05/18 l"));
		return gsp;
	}
}
