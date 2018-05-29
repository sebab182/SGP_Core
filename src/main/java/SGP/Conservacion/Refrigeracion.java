package SGP.Conservacion;

import SGP.Inspeccion.InspeccionMunicipal;
import SGP.Inspeccion.Inspector;
import SGP.Inspeccion.InspectorANMAT;

public class Refrigeracion extends Conservacion {

	@Override
	public int conservarSegunANMAT(InspectorANMAT inspector) {
		return 6;
	}

	@Override
	public int conservarSegunMunicipal(InspeccionMunicipal inspector) {
		return 4;
	}

}
