package SGP.Vencimiento;

public class Freezer extends Almacenamiento {

	@Override
	public int obtenerValorVencimiento(VidaUtil v) {
		//System.out.println("Freezer y Vida Util --> Error");
		return 0;
	}
	
	@Override
	public int obtenerValorVencimiento(VidaLarga v) {
		//System.out.println("Freezer y Vida Larga");
		return 7;
	}

	@Override
	public int obtenerValorVencimiento(VidaCorta v) {
		//System.out.println("Freezer y Vida Corta");
		return 5;
	}


}
