package SGP.Inspeccion;

import SGP.Conservacion.ConservacionNull;
import SGP.Conservacion.Refrigeracion;

public class InspectorTrucho extends Inspector {

	@Override
	public int inspeccionarRefrigeracion(Refrigeracion conservacion) {
		//System.out.println("la carne esta refrigerada y vence despues de 2 anios");
		return 365;
	}
	
	@Override
	public int inspeccionarConservacionNull(ConservacionNull conservacion) {
		//System.out.println("la carne no esta conservada pero aguanta 10 dias mas XD");
		return 10;
	}

}
