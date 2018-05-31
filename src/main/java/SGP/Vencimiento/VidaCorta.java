package SGP.Vencimiento;

public class VidaCorta extends VidaUtil {

	@Override
	public int obtenerMesesVidaUtil(Almacenamiento a) {
		return a.obtenerValorVencimiento(this);
	}

}
