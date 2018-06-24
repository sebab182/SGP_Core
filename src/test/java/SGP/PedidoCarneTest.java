package SGP;

import SGP.Pedidos.Local;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class PedidoCarneTest extends TestCase {
	private PedidoCarne pc;

	public PedidoCarneTest() {
		pc = new PedidoCarne();
	}
	
	public void testVaciarPedido() {
		pc.agregarItem(new Tipo("muslo"), 3);
		assertTrue(pc.get_items().containsKey(new Tipo("muslo")));
		pc.vaciarPedido();
		assertTrue(pc.get_items().isEmpty());
	}

	public void testAgregarItemTipoDouble() {
		pc.agregarItem(new Tipo("muslo"), 3);
		assertTrue(pc.get_items().containsKey(new Tipo("muslo")));
	}

	public void testQuitarItemTipo() {
		pc.agregarItem(new Tipo("muslo"), 3);
		assertTrue(pc.get_items().containsKey(new Tipo("muslo")));
		pc.quitarItem(new Tipo("muslo"));
		assertTrue(pc.get_items().isEmpty());
	}

	public void testItemsPedidos() {
		pc.agregarItem(new Tipo("muslo"), 3);
		pc.agregarItem(new Tipo("vacio"), 3);
		assertTrue(pc.get_items().containsKey(new Tipo("vacio")));
		assertTrue(pc.get_items().containsKey(new Tipo("muslo")));
	}

	public void testToString() {
		pc.agregarItem(new Tipo("muslo"), 3);
		assertEquals(pc.toString(),"{muslo=3}");
	}
	
	public void testsetAprobacion() {
		pc.set_nivelAprobacion(40);
		assertEquals(40,pc.get_nivelAprobacion());
	}
	
	public void testsetLocal() {
		pc.setLocal(new Local("Test","test@test.com.ar"));
		assertEquals(new Local("Test","test@test.com.ar"),pc.getLocal());
	}

}
