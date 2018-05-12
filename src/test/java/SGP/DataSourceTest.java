package SGP;

import SGP.Datos.DataSource;
import junit.framework.TestCase;


public class DataSourceTest extends TestCase {
	private DataSource ds;
	
	public void testDataSourceHardcodeado() {
		ds = new DataSource("datasource.txt"); 
		assertEquals("SGP.Datos.DatosHardcodeados", ds.getFactory());
	}
	
	public void testDataSourceSerilizado() {
		ds = new DataSource("testDataSource.txt"); 
		assertEquals("SGP.Datos.DatosSerializable", ds.getFactory());
	}
}