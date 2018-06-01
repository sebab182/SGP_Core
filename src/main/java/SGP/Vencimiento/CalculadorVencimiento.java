package SGP.Vencimiento;

import java.util.Calendar;
import java.util.Date;

import SGP.Stock.Pieza;

public class CalculadorVencimiento {

	public void calcularFechaVencimiento(Pieza p, Almacenamiento a) {
		int meses=0;
		VidaUtil vidaUtil = p.getVidaUtil();
		if(vidaUtil instanceof VidaLarga) {
			meses = a.obtenerValorVencimiento((VidaLarga) vidaUtil);
		}
		if(vidaUtil instanceof VidaCorta) {
			meses = a.obtenerValorVencimiento((VidaCorta) vidaUtil);
		}
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(p.getFechaElaboracion()); //Lo configuramos con la fecha de elaboracion
        calendar.add(Calendar.MONTH, meses);  //Agregamos la cantidad de meses recibidos del almacenamiento y el tipo de vida util
	    Date fechaVencimiento = calendar.getTime(); //Obtenemos la fecha de Vencimiento
	    p.setFechaVencimiento(fechaVencimiento); //Seteo la fecha de vencimiento
	}
}
