package SGP.Vencimiento;

import java.text.SimpleDateFormat;
import java.util.Locale;

import SGP.Stock.Pieza;

public class TestDoubleDispatch {

	public static void main(String[] args) {
		Pieza p = new Pieza("pata1 01/01/2017 h");
		CalculadorVencimiento calculadora = new CalculadorVencimiento();
		Almacenamiento a = new Heladera(); //Ver como lo enganchamos!
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
		calculadora.calcularFechaVencimiento(p, a);
		System.out.println(fecha.format(p.getFechaElaboracion()));
		System.out.println(fecha.format(p.getFechaVencimiento()));
	}

}
