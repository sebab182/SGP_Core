package SGP;

import SGP.Datos.DataSource;
import junit.framework.TestCase;


public class DataSourceTest extends TestCase {
	private DataSource ds;
	
	public void testDataSource() {
		ds = new DataSource("datasource.txt");
		String lecturaTXT = ds.getSource();
		assertEquals("test", lecturaTXT);
	}

	public void testGetFactory() {
		ds = new DataSource("datasource.txt");
		ds.setSource("test");
		String clase = ds.getFactory();
		assertEquals("SGP.Datos.DatosHardcodeados",clase);
		
		ds.setSource("serial");
		clase = ds.getFactory();
		assertEquals("SGP.Datos.DatosSerializable",clase);
	}
}