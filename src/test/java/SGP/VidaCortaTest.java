package SGP;

import SGP.Vencimiento.Freezer;
import SGP.Vencimiento.Heladera;
import SGP.Vencimiento.VidaCorta;
import junit.framework.TestCase;

public class VidaCortaTest extends TestCase {
	private VidaCorta vc;
	
	public VidaCortaTest() {
		vc = new VidaCorta();
	}
	
	public void testObtenerMesesVidaUtilFreezer() {
		assertEquals(5,vc.obtenerMesesVidaUtil(new Freezer()));
	}
	
	public void testObtenerMesesVidaUtilHeladera() {
		assertEquals(2,vc.obtenerMesesVidaUtil(new Heladera()));
	}
}
