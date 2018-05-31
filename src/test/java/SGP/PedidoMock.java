package SGP;

import SGP.Pedidos.Local;
import SGP.Pedidos.Pedido;
import SGP.Stock.Tipo;

/**
 * Solo se puede usar getLocal() y getNumeroItems()*/
public class PedidoMock extends Pedido<Tipo> {
	
	private int _id;
	private double _num_piezas;
	
	public PedidoMock(double num_piezas) {
		this(0, num_piezas, null);
	}
	
	public PedidoMock(Local local) {
		this(0, 0.0, local);
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

}
