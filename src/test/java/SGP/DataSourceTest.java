package SGP;

import SGP.Datos.DataSource;
import junit.framework.TestCase;


public class DataSourceTest extends TestCase {
	private DataSource ds;
	
	public void testDataSource() {
		ds = new DataSource("datasource.txt"); 
		assertEquals("SGP.Datos.DatosHardcodeados", ds.getFactory());
	}
}