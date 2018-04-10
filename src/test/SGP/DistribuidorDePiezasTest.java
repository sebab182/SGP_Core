package test.SGP;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;
import main.SGP.Distribucion;
import main.SGP.DistribuidorDePiezas;
import main.SGP.Pedido;
import main.SGP.Pieza;
import main.SGP.Stock;

public class DistribuidorDePiezasTest extends TestCase {

	private Stock stock;
	private DistribuidorDePiezas dp;
	private Pieza pata1;
	private Pieza pata2;
	private Pieza pata3;
	private Pieza pata4;
	private Pieza lengua1;
	private Pieza lengua2;
	private Pedido ped1;
	private Pedido ped2;
	private Pedido ped3;
	
	public DistribuidorDePiezasTest() {
		this.pata1 = new Pieza("pata1");
		this.pata2 = new Pieza("pata2");
		this.pata3 = new Pieza("pata3");
		this.pata4 = new Pieza("pata4");
		this.lengua1 = new Pieza("lengua1");
		this.lengua2 = new Pieza("lengua2");
		this.stock = new Stock();
		this.stock.agregarPieza(pata1);
		this.stock.agregarPieza(pata2);
		this.stock.agregarPieza(pata3);
		this.stock.agregarPieza(pata4);
		this.stock.agregarPieza(lengua1);
		this.stock.agregarPieza(lengua2);
		this.dp = new DistribuidorDePiezas(this.stock);
		
		// pedido 1 y 2 con piezas del stock
		this.ped1.agregarPieza(pata1);
		this.ped1.agregarPieza(pata2);
		this.ped2.agregarPieza(pata3);
		this.ped2.agregarPieza(pata4);
		this.ped2.agregarPieza(lengua1);
		
		// pedido 3 sin piezas del stock
		this.ped3.agregarPieza(new Pieza("pata5"));
		this.ped3.agregarPieza(new Pieza("lengua3"));
		
	}
	
	public void getDistribucionTest() {
		int s1 = this.stock.getCantidadPiezas();
		Distribucion d1 = dp.getDistribucion(ped1);
		int s2 = s1 - d1.getCantidadPiezas();
		assertTrue(s2 == 2);
		assertTrue(ped1.getPedido().containsAll(this.stock.getStock())
				&& this.stock.getStock().containsAll(ped1.getPedido()));
	}
	
	public void getDistribucionesTest() {
		List<Pedido> pedidos = new LinkedList<Pedido>();
		pedidos.add(ped1);
		pedidos.add(ped1);
		pedidos.add(ped1);
		
		List<Distribucion> dist = dp.getDistribuciones(pedidos);
		
		assertTrue(this.stock.stockVacio());
		assertTrue(dist.size() == 3);
	}
	
}
