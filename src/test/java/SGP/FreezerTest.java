package SGP;

import SGP.Vencimiento.Freezer;
import SGP.Vencimiento.VidaCorta;
import SGP.Vencimiento.VidaLarga;
import SGP.Vencimiento.VidaUtil;
import junit.framework.TestCase;

public class FreezerTest extends TestCase {
	private Freezer f;
	
	public FreezerTest() {
		f = new Freezer();
	}

	public void testObtenerValorVencimientoVidaUtil() {
		VidaUtil v = new VidaLarga();
		assertEquals(0,f.obtenerValorVencimiento(v));
	}

	public void testObtenerValorVencimientoVidaLarga() {
		assertEquals(7,f.obtenerValorVencimiento(new VidaLarga()));
	}

	public void testObtenerValorVencimientoVidaCorta() {
		assertEquals(5,f.obtenerValorVencimiento(new VidaCorta()));
	}

}
