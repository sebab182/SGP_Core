package SGP;

import SGP.Vencimiento.Freezer;
import SGP.Vencimiento.Heladera;
import SGP.Vencimiento.VidaLarga;
import junit.framework.TestCase;

public class VidaLargaTest extends TestCase {
	private VidaLarga vl;
	
	public VidaLargaTest() {
		vl = new VidaLarga();
	}

	public void testObtenerMesesVidaUtilFreezer() {
		assertEquals(7, vl.obtenerMesesVidaUtil(new Freezer()));
	}
	
	public void testObtenerMesesVidaUtilHeladera() {
		assertEquals(4, vl.obtenerMesesVidaUtil(new Heladera()));
	}

}
