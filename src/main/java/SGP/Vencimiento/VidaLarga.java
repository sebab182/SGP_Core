package SGP.Vencimiento;

public class VidaLarga extends VidaUtil {

	@Override
	public int obtenerMesesVidaUtil(Almacenamiento a) {
		return a.obtenerValorVencimiento(this);
	}

}
