package test.java.SGP;

import java.util.Date;
import junit.framework.TestCase;
import main.java.SGP.GestordeStock;
import main.java.SGP.Pieza;
import main.java.SGP.Tipo;
import main.java.SGP.Stock.AnalizadordeVencimiento;

public class AnalizadordeVencimientoTest extends TestCase {

	public void testAnalizarVencimientoPiezas() {
		AnalizadordeVencimiento av = new AnalizadordeVencimiento();
		GestordeStock gestorStock = new GestordeStock();
		
		//Se dispone una pieza con fecha de caducidad 10/10/2007, la pieza se elimina del stock.
		gestorStock.agregarPieza(new Pieza(new Tipo("pata1"),new Date(107,9,10)));
		av.analizarVencimientoPiezas(gestorStock);
		assertTrue(gestorStock.getStock().isEmpty());
		
		//Se dispone una pieza con fecha de caducidad 10/10/2018, la pieza se mantiene en el stock.
		gestorStock.agregarPieza(new Pieza(new Tipo("pata1"),new Date(118,9,10)));
		av.analizarVencimientoPiezas(gestorStock);
		assertEquals(gestorStock.getStock().size(),1);
	}
}