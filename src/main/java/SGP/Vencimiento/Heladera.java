package SGP.Vencimiento;

public class Heladera extends Almacenamiento {

	@Override
	int obtenerValorVencimiento(VidaUtil v) {
		//System.out.println("Heladera y Vida Util --> Error");
		return 0;
	}
	
	@Override
	int obtenerValorVencimiento(VidaLarga v) {
		//System.out.println("Heladera y Vida Larga");
		return 4;
	}

	@Override
	int obtenerValorVencimiento(VidaCorta v) {
		//System.out.println("Heladera y Vida Corta");
		return 2;
	}


}
