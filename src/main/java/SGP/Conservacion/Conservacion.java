package SGP.Conservacion;

import SGP.Inspeccion.InspeccionMunicipal;
import SGP.Inspeccion.Inspector;
import SGP.Inspeccion.InspectorANMAT;

public abstract class Conservacion {

	public int conservarSegunInspector(Inspector inspector) {
		return inspector.inspeccionar(this);
	}
	
	public abstract int conservarSegunANMAT(InspectorANMAT inspector);
	
	public abstract int conservarSegunMunicipal(InspeccionMunicipal inspector);
	
}
