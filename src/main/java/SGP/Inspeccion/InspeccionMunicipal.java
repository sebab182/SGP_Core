package SGP.Inspeccion;

import SGP.Conservacion.Conservacion;

public class InspeccionMunicipal extends Inspector {

	@Override
	public int inspeccionar(Conservacion conservacion) {
		return conservacion.conservarSegunMunicipal(this);
	}
	
}