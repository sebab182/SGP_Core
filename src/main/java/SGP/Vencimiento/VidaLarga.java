package SGP.Vencimiento;

public class VidaLarga extends VidaUtil {

	@Override
	int obtenerMesesVidaUtil(Almacenamiento a) {
		return a.obtenerValorVencimiento(this);
	}

}
