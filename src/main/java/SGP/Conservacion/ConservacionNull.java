package SGP.Conservacion;

import SGP.Inspeccion.Inspector;

public class ConservacionNull extends Conservacion {

	public int conservarSegunInspector(Inspector inspector) {
		return inspector.inspeccionarConservacionNull(this);
	}

}
