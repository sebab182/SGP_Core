package SGP;

import SGP.Conservacion.Conservacion;
import SGP.Conservacion.ConservacionNull;
import SGP.Conservacion.Refrigeracion;
import SGP.Inspeccion.Inspector;
import SGP.Inspeccion.InspectorANMAT;
import junit.framework.TestCase;

public class InspectorANMATTest extends TestCase {

	public void testIspeccionar() {
		Inspector i = new InspectorANMAT();
		Conservacion c1 = new ConservacionNull();
		Conservacion c2 = new Refrigeracion();
		
		assertEquals (i.inspeccionar(c1), 1);
		assertEquals (i.inspeccionar(c2), 6);
	}
	
}
