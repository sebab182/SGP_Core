package SGP.Vencimiento;

import SGP.Stock.Pieza;

public class TestDoubleDispatch {

	public static void main(String[] args) {
		Pieza p = new Pieza("pata1 01/01/2017 c");
		Almacenamiento a = new Freezer(); //Ver como lo enganchamos!
		CalculadorVencimiento calculadora = new CalculadorVencimiento();
		calculadora.calcularFechaVencimiento(p, a);
	}
}
