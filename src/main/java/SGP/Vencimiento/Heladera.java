package SGP.Vencimiento;

public class Heladera extends Almacenamiento {

	@Override
	public int obtenerValorVencimiento(VidaUtil v) {
		//System.out.println("Heladera y Vida Util --> Error");
		return 0;
	}
	
	@Override
	public int obtenerValorVencimiento(VidaLarga v) {
		//System.out.println("Heladera y Vida Larga");
		return 4;
	}

	@Override
	public int obtenerValorVencimiento(VidaCorta v) {
		//System.out.println("Heladera y Vida Corta");
		return 2;
	}


}
