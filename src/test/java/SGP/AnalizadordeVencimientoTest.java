package SGP;

import java.util.Date;

import SGP.Stock.AnalizadordeVencimiento;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class AnalizadordeVencimientoTest extends TestCase {

	@SuppressWarnings("deprecation")
	public void testAnalizarVencimientoPiezas() {
		AnalizadordeVencimiento av = new AnalizadordeVencimiento(new Date(118,4,9));
		GestorStockPiezas gestorStock = new GestorStockPiezas();
		
		//Se dispone una sola pieza en el stock con fecha de caducidad 10/10/2007 y fecha actual 09/05/2018, la pieza se elimina del stock.
		gestorStock.agregarItem(new Pieza(new Tipo("pata1"),new Date(107,9,10)));
		av.analizarVencimientoPiezas(gestorStock);
		assertTrue(gestorStock.getStock().isEmpty());
		
		//Se dispone una sola pieza en el stock con fecha de caducidad 10/10/2018 y fecha actual 09/05/2018, la pieza se mantiene en el stock.
		gestorStock.agregarItem(new Pieza(new Tipo("pata1"),new Date(118,9,10)));
		av.analizarVencimientoPiezas(gestorStock);
		assertEquals(gestorStock.getStock().size(),1);
	}
	
}