package SGP;

import SGP.Pedidos.Local;
import SGP.Pedidos.Pedido;
import SGP.Stock.Tipo;

/**
 * Solo se puede usar getLocal() y getNumeroItems()*/
public class PedidoMock extends Pedido<Tipo> {
	
	private int _id;
	private double _num_piezas;
	
	public PedidoMock(int id) {
		this(id, 0.0, null);
	}
	
	public PedidoMock(double num_piezas) {
		this(0, num_piezas, null);
	}
	
	public PedidoMock(Local local) {
		this(0, 0.0, local);
	}
	
	public PedidoMock(int id, double num_piezas) {
		this(id, num_piezas, null);
	}
	
	public PedidoMock(double num_piezas, Local local) {
		this(0, num_piezas, local);
	}
	
	public PedidoMock(int id, double num_piezas, Local local) {
		this._id = id;
		this._num_piezas = num_piezas;
		this.set_Local(local);
	}
	
	@Override
	public double getNumeroItems() {
		return this._num_piezas;
	}
	
	@Override
	public String toString() {
		return Integer.toString(this._id);
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if (o instanceof PedidoMock) {
			PedidoMock p = (PedidoMock) o;
			return this._id == p._id;
		}
		return ret;
		
	}

}
