package SGP.Conservacion;

import SGP.Inspeccion.Inspector;

public abstract class Conservacion {

	public int conservarSegunInspector(Inspector inspector) {
		return inspector.inspeccionar(this);
	}
	
}
