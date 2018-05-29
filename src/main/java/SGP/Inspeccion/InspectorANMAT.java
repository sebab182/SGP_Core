package SGP.Inspeccion;

import SGP.Conservacion.Conservacion;

public class InspectorANMAT extends Inspector {

	@Override
	public int inspeccionar(Conservacion conservacion) {
		return conservacion.conservarSegunANMAT(this);
	}
	
}
