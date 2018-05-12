package SGP;
import SGP.Datos.DatosHardcodeados;
import junit.framework.TestCase;

public class DatosHardcodeadosTest extends TestCase {
	private DatosHardcodeados dh;
	
	public DatosHardcodeadosTest() {
		dh = new DatosHardcodeados();
	}
	public void testCargarPiezas() {
		assertEquals(false, dh.cargarPiezas().isEmpty());
	}

	public void testCargarPedidos() {
		assertEquals(2, dh.cargarPedidos().size());
	}

	public void testCargarConjuntoVaca() {
		assertEquals(false,dh.cargarConjuntoVaca().isEmpty());
	}
}
