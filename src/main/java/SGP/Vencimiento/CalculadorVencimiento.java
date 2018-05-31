package SGP.Vencimiento;

import java.util.Calendar;
import java.util.Date;

import SGP.Stock.Pieza;

public class CalculadorVencimiento {

	public void calcularFechaVencimiento(Pieza p, Almacenamiento a) {
		VidaUtil vu = p.getVidaUtil();
		int meses=0;
		if(p.getVidaUtil().getClass().isInstance(VidaLarga.class)) {
			meses = a.obtenerValorVencimiento((VidaLarga) vu);
		}
		else {
			meses = a.obtenerValorVencimiento((VidaCorta)vu);
		}
		
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(p.getFechaElaboracion()); //Lo configuramos con la fecha de elaboracion
        calendar.add(Calendar.MONTH, meses);  //Agregamos la cantidad de meses recibidos del almacenamiento y el tipo de vida util
	    Date fechaVencimiento = calendar.getTime(); //Obtenemos la fecha de Vencimiento
	    p.setFechaVencimiento(fechaVencimiento); //Seteo la fecha de vencimiento
	    System.out.println(fechaVencimiento);
	}
}
