package test.java.SGP;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import main.java.SGP.Tipo;
import main.java.SGP.Pedidos.Pedido;
import main.java.SGP.Stock.AgrupadordePiezas;

public class AgrupadordePiezasTest extends TestCase {
	private AgrupadordePiezas ap;


	public void testAgruparPedidos() {
		DatosHardcodeados dh = new DatosHardcodeados();
		List<Pedido<Tipo>> pedidos = dh.cargarPedidos();
		ap = new AgrupadordePiezas();
		/*Map<Tipo,Integer>agrupacion = ap.agruparPedidos(pedidos);
		assertEquals(agrupacion.get(new Tipo("pata1")),new Integer(5));
		assertEquals(agrupacion.get(new Tipo("pata2")),new Integer(2));
		assertEquals(agrupacion.get(new Tipo("muslo")),new Integer(4));
		assertEquals(agrupacion.get(new Tipo("vacio")),new Integer(2));*/
	}

}