package SGP;

import java.util.Calendar;
import java.util.GregorianCalendar;

import SGP.Conservacion.Conservacion;
import SGP.Conservacion.Refrigeracion;
import SGP.Inspeccion.Inspector;
import SGP.Inspeccion.InspectorANMAT;
import SGP.Stock.Pieza;
import SGP.Vencimiento.ModificadorVencimiento;
import junit.framework.TestCase;

public class ModificadorVencimientoTest extends TestCase {

	public void testModificar() {
		Pieza p = new Pieza("pata1 28/1/2018");
		Calendar gc = new GregorianCalendar();
		ModificadorVencimiento m = new ModificadorVencimiento();
		Inspector i = new InspectorANMAT();
		Conservacion c = new Refrigeracion();
		
		System.out.println(p.getFechaVencimiento().toString());
		m.modificar(p, i, c);
		System.out.println(p.getFechaVencimiento().toString());
		assertEquals(p.getFechaVencimiento().getMonth(), gc.getTime().getMonth()+6%12);
	}
	
}
