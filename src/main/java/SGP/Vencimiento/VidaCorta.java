package SGP.Vencimiento;

public class VidaCorta extends VidaUtil {

	@Override
	int obtenerMesesVidaUtil(Almacenamiento a) {
		return a.obtenerValorVencimiento(this);
	}

}
