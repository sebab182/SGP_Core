package SGP;

import SGP.Exportador.ExporterSource;
import junit.framework.TestCase;

public class ExporterSourceTest extends TestCase {
	
	public void testGetFactory() {
		ExporterSource es = new ExporterSource("txt");
		assertEquals(es.getFactory(),"SGP.Exportador.TXTExporter");
	}
	
	public void testGetFactoryXLS() {
		ExporterSource es = new ExporterSource("xls");
		assertEquals(es.getFactory(),"SGP.Exportador.XLSExporter");
	}
	
	public void testGetFactoryCSV() {
		ExporterSource es = new ExporterSource("csv");
		assertEquals(es.getFactory(),"SGP.Exportador.CSVExporter");
	}

}
