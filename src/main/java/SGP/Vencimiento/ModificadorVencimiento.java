package SGP.Vencimiento;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import SGP.Conservacion.Conservacion;
import SGP.Inspeccion.Inspector;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;

public class ModificadorVencimiento {

	public void modificar(Pieza p, Inspector i, Conservacion c) {
		// Sugerencia: hacer un setFechaVencimiento()
		Tipo t = p.getTipoPieza();
		Date d = p.getFechaVencimiento();
		Calendar gc = new GregorianCalendar();
		
		if (d.before(gc.getTime())) {
			d.setMonth(gc.getTime().getMonth()+i.inspeccionar(c));
			p = new Pieza(t, d);	
		}
	}
	
}
