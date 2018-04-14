package main.SGP;

import java.util.List;
import java.util.Map;

import test.SGP.DatosHardcodeados;

public class TestIntegracion {


	public static void main(String[] args) {
		AbstractFactory af = new DatosHardcodeados();
		
		System.out.println("STOCK");
		GestordeStock stock = new GestordeStock();
		stock.setStock(af.cargarStock());
		System.out.println(stock.getStock());
		
		System.out.println("PEDIDOS");
		List<Map<Pieza, Integer>> pedidos = af.cargarPedidos();
		System.out.println(pedidos);
		

		System.out.println("DISTRIBUCIONES GENERADAS");
		Distribuidor d = new Distribuidor();
		List<Map<Pieza, Integer>>distribuciones = d.resolverPedidos(pedidos, stock);
		System.out.println(distribuciones);
		
		System.out.println("VACAS FAENADAS: "+stock.getVacasaFaenar());
		System.out.println("STOCK LUEGO DE DISTRIBUCIÓN");
		System.out.println(stock.getStock());
	}

}
