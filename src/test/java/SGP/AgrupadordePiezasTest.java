package SGP;

import java.util.List;
import java.util.Map;

import SGP.Pedidos.Pedido;
import SGP.Stock.AgrupadordePiezas;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class AgrupadordePiezasTest extends TestCase {
	private AgrupadordePiezas ap;
	
	@SuppressWarnings("deprecation")
	public void testAgruparPedidos() {
		DatosHardcodeados dh = new DatosHardcodeados();
		List<Pedido<Tipo>> pedidos = dh.cargarPedidos();
		ap = new AgrupadordePiezas();
		Map<Tipo,Double>agrupacion = ap.agruparPedidos(pedidos);
		assertEquals(agrupacion.get(new Tipo("vacio")),new Double(4.0));
		assertEquals(agrupacion.get(new Tipo("pata")),new Double(8.0));
		assertEquals(agrupacion.get(new Tipo("muslo")),new Double(10.0));
	}
}