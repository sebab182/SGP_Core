package SGP;

import SGP.Pedidos.SistemaPedidosProxy;
import junit.framework.TestCase;

public class SistemaPedidosTest extends TestCase {
	private SistemaPedidosProxy sp;

	public void testCargarPedidos() {
		sp = new SistemaPedidosStub();
		assertEquals(2,sp.cargarPedidos().size());
	}

}
