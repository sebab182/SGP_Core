package SGP.Conservacion;

import SGP.Inspeccion.Inspector;

public class Refrigeracion extends Conservacion {

	public int conservarSegunInspector(Inspector inspector) {
		return inspector.inspeccionarRefrigeracion(this);
	}

}
