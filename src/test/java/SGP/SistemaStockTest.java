package SGP;
import SGP.Stock.SistemaStockProxy;
import junit.framework.TestCase;

public class SistemaStockTest extends TestCase {
	private SistemaStockProxy ss;

	public void testCargarPiezas() {
		ss = new SistemaStockStub();
		assertEquals(16,ss.cargarPiezas().size());
	}

	public void testCargarConjuntoVaca() {
		ss = new SistemaStockStub();
		assertTrue(!ss.cargarConjuntoVaca().isEmpty());
	}

}
