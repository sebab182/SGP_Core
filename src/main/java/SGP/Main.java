package main.java.SGP;
import java.util.List;
import java.util.Map;

import main.java.SGP.Pedidos.Pedido;
import main.java.SGP.Stock.AgrupadordePiezas;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//DataSource selecciona el tipo de factory a cargar
		DataSource ds = new DataSource("datasource.txt");
		Class cls = Class.forName(ds.getFactory());
		AbstractFactory af = (AbstractFactory) cls.newInstance();
		
		//Cargamos stock y pedidos
		GestordeStock gestorStock = af.cargarGestordeStock();
		System.out.println(gestorStock.getStock());
		List<Pedido<Tipo>>pedidos=af.cargarPedidos();
		System.out.println(pedidos);
		
		AgrupadordePiezas ap= new AgrupadordePiezas();
		System.out.println(ap.agruparPedidos(pedidos));
		
		
		//Creamos distribuidor y resolvemos los pedidos
		Distribuidor d = new Distribuidor();
		//List<Map<Pieza,Integer>>distribuciones = d.resolverPedidos(pedidos, gestorStock);
	}
}
