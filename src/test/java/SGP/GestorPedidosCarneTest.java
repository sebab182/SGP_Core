package SGP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import SGP.Pedidos.GestorPedidosCarne;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;
import SGP.Stock.Tipo;
import junit.framework.TestCase;

public class GestorPedidosCarneTest extends TestCase {

	GestorPedidosCarne _gp;
	
	public GestorPedidosCarneTest()
	{
		this._gp=null;
		
	}
	
	public void testAgregarPedido() {
		this._gp=new GestorPedidosCarne();
		
		this._gp.agregarPedido(new PedidoCarne());
		
		assertEquals(this._gp.totalPedidos(),1);
	}

	public void testQuitarPedido() {
		this._gp=new GestorPedidosCarne();
		PedidoCarne p=new PedidoCarne();
		
		this._gp.agregarPedido(p);
		this._gp.quitarPedido(p);
		assertEquals(this._gp.totalPedidos(),0);
	}

	public void testVaciarPedidos() {
		this._gp=new GestorPedidosCarne();
		this._gp.agregarPedido(new PedidoCarne());
		this._gp.agregarPedido(new PedidoCarne());
		this._gp.vaciarPedidos();
		assertEquals(this._gp.totalPedidos(),0);
	}

	public void testMenorPrioridad() {
		this._gp=new GestorPedidosCarne();
		this._gp.agregarPedido(new PedidoCarne());
		this._gp.agregarPedido(new PedidoCarne());
		this._gp.agregarPedido(new PedidoCarne());
		this._gp.agregarPedido(new PedidoCarne());

		PedidoCarne p= (PedidoCarne) this._gp.menorPrioridad();
		this._gp.quitarPedido(p);
		
		assertTrue(this._gp.totalPedidos()==3);
	}

	public void testTotalPorPieza() {
		this._gp=new GestorPedidosCarne();

		Tipo pata1=new Tipo("Pata 1");
		Tipo pata2=new Tipo("Pata 2");
		Tipo pata3=new Tipo("Pieza 3");
		
		PedidoCarne p1=new PedidoCarne();
		p1.agregarItem(pata1, 2);
		p1.agregarItem(pata3, 1);
		
		PedidoCarne p2=new PedidoCarne();
		p2.agregarItem(pata1, 1);
		p2.agregarItem(pata2, 5);		

		PedidoCarne p3=new PedidoCarne();
		p3.agregarItem(pata1, 1);
		p3.agregarItem(pata2, 2);		
		p3.agregarItem(pata3, 3);
		
		this._gp.agregarPedido(p1);
		this._gp.agregarPedido(p2);
		this._gp.agregarPedido(p3);
		
		HashMap<Tipo, Integer> totales=this._gp.totalPorPieza();
		
		Integer total1=totales.get(pata1);
		assertEquals(total1,new Integer(4));
	}

	public void testTotalPedidos() {
		this._gp=new GestorPedidosCarne();
		this._gp.agregarPedido(new PedidoCarne());
		this._gp.agregarPedido(new PedidoCarne());
		this._gp.agregarPedido(new PedidoCarne());
		this._gp.agregarPedido(new PedidoCarne());

		assertTrue(this._gp.totalPedidos()==4);
	}
	
	public void testAgregarPedidos() {
		Pedido<Tipo> a = new PedidoCarne();
		a.agregarItem(new Tipo("pata1"), 2);
		Pedido<Tipo> b = new PedidoCarne();
		b.agregarItem(new Tipo("pata2"), 3);
		List<Pedido<Tipo>> p = new LinkedList<Pedido<Tipo>>();
		p.add(a);
		p.add(b);
		this._gp=new GestorPedidosCarne();
		this._gp.agregarPedidos(p);
		assertTrue(this._gp.get_pedidos().size()==2);
	}

	public void test() {
		Pedido<Tipo> a = new PedidoCarne();
		a.agregarItem(new Tipo("pata1"), 2);
		this._gp=new GestorPedidosCarne();
		this._gp.agregarPedido(a);
		assertTrue(this._gp.toString().contains("pata1"));
	}
}
