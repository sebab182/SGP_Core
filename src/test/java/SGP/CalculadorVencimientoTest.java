package SGP;

import java.util.Date;

import SGP.Stock.Pieza;
import SGP.Vencimiento.Almacenamiento;
import SGP.Vencimiento.CalculadorVencimiento;
import SGP.Vencimiento.Freezer;
import SGP.Vencimiento.Heladera;
import junit.framework.TestCase;

public class CalculadorVencimientoTest extends TestCase {
	private CalculadorVencimiento calculadora;
	
	public CalculadorVencimientoTest() {
		calculadora = new CalculadorVencimiento();
	}

	public void testCalcularFechaVencimiento() {
		//Pieza de vida corta con Freezer
		Pieza p = new Pieza("pata1 01/01/2017 c");
		calculadora.calcularFechaVencimiento(p, new Freezer());
		assertEquals(new Date(Date.parse("06/01/2017")),p.getFechaVencimiento());
	}
	
	public void testCalcularFechaVencimiento2() {
		//Pieza de vida corta con Heladera
		Pieza p = new Pieza("pata1 01/01/2017 c");
		calculadora.calcularFechaVencimiento(p, new Heladera());
		assertEquals(new Date(Date.parse("03/01/2017")),p.getFechaVencimiento());
	}
	
	
	public void testCalcularFechaVencimiento3() {
		//Pieza de vida larga con Freezer
		Pieza p = new Pieza("pata1 01/01/2017 l");
		calculadora.calcularFechaVencimiento(p, new Freezer());
		assertEquals(new Date(Date.parse("08/01/2017")),p.getFechaVencimiento());
	}
	
	public void testCalcularFechaVencimiento4() {
		//Pieza de vida larga con Heladera
		Pieza p = new Pieza("pata1 01/01/2017 l");
		calculadora.calcularFechaVencimiento(p, new Heladera());
		assertEquals(new Date(Date.parse("05/01/2017")),p.getFechaVencimiento());
	}	

}
