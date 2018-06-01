package SGP;

import java.util.HashSet;
import java.util.List;
import SGP.Datos.AbstractFactory;
import SGP.Datos.DataSource;
import SGP.Stock.Pieza;
import SGP.Stock.SistemaStockProxy;
import SGP.Stock.Tipo;

public class SistemaStockStub implements SistemaStockProxy {
	private AbstractFactory af;
	
	public SistemaStockStub() {
		DataSource ds = new DataSource("datasource.txt");
		Class<?> cls;
		try {
			cls = Class.forName(ds.getFactory());
			af = (AbstractFactory) cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<Pieza> cargarPiezas() {
		return af.cargarPiezas();
	}

	@Override
	public HashSet<Tipo> cargarConjuntoVaca() {
		return af.cargarConjuntoVaca();
	}

}
