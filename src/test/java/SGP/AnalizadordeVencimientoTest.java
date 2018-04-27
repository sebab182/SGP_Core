package SGP;

import java.util.Date;

import SGP.Stock.AnalizadordeVencimiento;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class AnalizadordeVencimientoTest extends TestCase {

	@SuppressWarnings("deprecation")
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