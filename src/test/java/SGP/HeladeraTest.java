package SGP;

import SGP.Vencimiento.Heladera;
import SGP.Vencimiento.VidaCorta;
import SGP.Vencimiento.VidaLarga;
import SGP.Vencimiento.VidaUtil;
import junit.framework.TestCase;

public class HeladeraTest extends TestCase {
	private Heladera h;
	
	public HeladeraTest() {
		h = new Heladera();
	}

	public void testObtenerValorVencimientoVidaUtil() {
		VidaUtil d = new VidaLarga();
		assertEquals(0, h.obtenerValorVencimiento(d));
	}

	public void testObtenerValorVencimientoVidaLarga() {
		assertEquals(4, h.obtenerValorVencimiento(new VidaLarga()));
	}

	public void testObtenerValorVencimientoVidaCorta() {
		assertEquals(2, h.obtenerValorVencimiento(new VidaCorta()));
	}

}
