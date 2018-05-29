package SGP.Inspeccion;

import SGP.Conservacion.ConservacionNull;
import SGP.Conservacion.Refrigeracion;

public class InspectorCreible extends Inspector {

	@Override
	public int inspeccionarRefrigeracion(Refrigeracion refrigeracion) {
		//System.out.println("la carne esta refrigerada y aguanta 1 mes");
		return 31;
	}

	@Override
	public int inspeccionarConservacionNull(ConservacionNull conservacionNull) {
		//System.out.println("la carne no esta conservada y ya no sirve");
		return 0;
	}

}
