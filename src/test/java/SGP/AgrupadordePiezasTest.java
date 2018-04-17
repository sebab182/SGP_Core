package test.java.SGP;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import main.java.SGP.AgrupadordePiezas;
import main.java.SGP.Pieza;

public class AgrupadordePiezasTest extends TestCase {
	private AgrupadordePiezas ap;


	public void testAgruparPedidos() {
		DatosHardcodeados dh = new DatosHardcodeados();
		List<Map<Pieza, Integer>> pedidos = dh.cargarPedidos();
		ap = new AgrupadordePiezas();
		Map<Pieza,Integer>agrupacion = ap.agruparPedidos(pedidos);
		assertEquals(agrupacion.get(new Pieza("pata1")),new Integer(5));
		assertEquals(agrupacion.get(new Pieza("pata2")),new Integer(2));
		assertEquals(agrupacion.get(new Pieza("muslo")),new Integer(4));
		assertEquals(agrupacion.get(new Pieza("vacio")),new Integer(2));
	}

}
