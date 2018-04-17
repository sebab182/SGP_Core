package test.java.SGP;

import junit.framework.TestCase;
import main.java.SGP.DataSource;

public class DataSourceTest extends TestCase {
	private DataSource ds;
	
	public void testDataSource() {
		ds = new DataSource("datasource.txt");
		String lecturaTXT = ds.getSource();
		assertEquals(lecturaTXT, "test");
	}

	public void testGetFactory() {
		ds = new DataSource("datasource.txt");
		String clase = ds.getFactory();
		assertEquals(clase, "test.java.SGP.DatosHardcodeados");
		
		ds.setSource("serial");
		clase = ds.getFactory();
		assertEquals(clase, "main.java.SGP.DatosSerializable");
	}
	

}
