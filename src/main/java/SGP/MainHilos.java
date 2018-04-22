package main.java.SGP;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainHilos {

	@SuppressWarnings({ "deprecation", "rawtypes", "unused" })
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//DataSource selecciona el tipo de factory a cargar
		DataSource ds = new DataSource("datasource.txt");
		Class cls = Class.forName(ds.getFactory());
		AbstractFactory af = (AbstractFactory) cls.newInstance();
		
		//Cargamos stock y pedidos
		GestordeStock gestorStock = af.cargarGestordeStock();
		List<Map<Pieza,Integer>>pedidos=af.cargarPedidos();
		
		//Iniciamos el analizador de vencimiento
		GestordeStockN gestorStockN = new GestordeStockN();
		gestorStockN.setVacasExistentes(10);
		List<PiezaN>vaca = new LinkedList<PiezaN>();
		//date(año= 1900+años, mes<0 a 11>, día
		vaca.add(new PiezaN(new Tipo("pata1"),new Date(107,10,23)));
		vaca.add(new PiezaN(new Tipo("pata2"),new Date(107,11,12)));
		vaca.add(new PiezaN(new Tipo("pata3"),new Date(118,1,21)));
		vaca.add(new PiezaN(new Tipo("pata4"),new Date(110,10,27)));
		vaca.add(new PiezaN(new Tipo("muslo"),new Date(108,3,21)));
		vaca.add(new PiezaN(new Tipo("vacio"),new Date(118,2,21)));
		gestorStockN.agregarPiezas(vaca);
		System.out.println(gestorStockN.getStock());
		Runnable av = new AnalizadordeVencimiento(gestorStockN);
		Thread hilo = new Thread(av);
		hilo.start();
		
		//Creamos distribuidor y resolvemos los pedidos
		Distribuidor d = new Distribuidor();
		List<Map<Pieza,Integer>>distribuciones = d.resolverPedidos(pedidos, gestorStock);		
	}
}
