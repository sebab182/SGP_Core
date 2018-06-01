package SGP;

import java.util.LinkedList;
import java.util.List;
import SGP.Datos.AbstractFactory;
import SGP.Datos.DataSource;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.SistemaPedidosProxy;
import SGP.Stock.Tipo;

public class SistemaPedidosStub implements SistemaPedidosProxy {

	@Override
	public List<Pedido<Tipo>> cargarPedidos(){
		List<Pedido<Tipo>> ret = new LinkedList<Pedido<Tipo>>();
		DataSource ds = new DataSource("datasource.txt");
		try {
			Class<?> cls = Class.forName(ds.getFactory());
			AbstractFactory af = (AbstractFactory) cls.newInstance();
			ret = af.cargarPedidos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
