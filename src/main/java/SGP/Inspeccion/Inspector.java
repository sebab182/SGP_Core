package SGP.Inspeccion;

import SGP.Conservacion.Conservacion;
import SGP.Conservacion.ConservacionNull;
import SGP.Conservacion.Refrigeracion;

public abstract class Inspector {
	
	public int inspeccionar(Conservacion conservacion) {
		return conservacion.conservarSegunInspector(this);
	}
	
}