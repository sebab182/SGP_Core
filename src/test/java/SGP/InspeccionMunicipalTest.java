package SGP;

import SGP.Conservacion.Conservacion;
import SGP.Conservacion.ConservacionNull;
import SGP.Conservacion.Refrigeracion;
import SGP.Inspeccion.InspeccionMunicipal;
import SGP.Inspeccion.Inspector;
import junit.framework.TestCase;

public class InspeccionMunicipalTest extends TestCase {

	public void testIspeccionar() {
		Inspector i = new InspeccionMunicipal();
		Conservacion c1 = new ConservacionNull();
		Conservacion c2 = new Refrigeracion();
		
		assertEquals (i.inspeccionar(c1), 2);
		assertEquals (i.inspeccionar(c2), 4);
	}
	
}
