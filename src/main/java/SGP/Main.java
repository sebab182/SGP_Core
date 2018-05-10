package SGP;

import java.util.Date;
import java.util.List;

import SGP.Datos.AbstractFactory;
import SGP.Datos.DataSource;
import SGP.Pedidos.GestorPedidosCarne;
import SGP.Pedidos.Pedido;
import SGP.Stock.AnalizadordeVencimiento;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Tipo;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//DataSource selecciona el tipo de factory a cargar
		DataSource ds = new DataSource("datasource.txt");
		Class<?> cls = Class.forName(ds.getFactory());
		AbstractFactory af = (AbstractFactory) cls.newInstance();
		
		//Cargamos stock y pedidos
		GestorStockPiezas gestorStock=new GestorStockPiezas(); 
		af.cargarGestordeStock(gestorStock);
		
		//Analizo piezas vencidas
		AnalizadordeVencimiento av = new AnalizadordeVencimiento(new Date());
		av.analizarVencimientoPiezas(gestorStock);
		
		GestorPedidosCarne gp = new GestorPedidosCarne();
		List<Pedido<Tipo>>pedidos=af.cargarPedidos();
		
		for(Pedido<Tipo> pedido:pedidos)
		{
			gp.agregarPedido(pedido);
		}

		System.out.println(gp.totalPorPieza());
		
		ControlProduccion ControlProd = new ControlProduccion();
		//Calculo total a Faenar
		System.out.println(ControlProd.calcularFaena(gp, gestorStock));
		//Creamos distribuidor y resolvemos los pedidos
		//Distribuidor d = new Distribuidor();
		//List<Map<Pieza,Integer>>distribuciones = d.resolverPedidos(pedidos, gestorStock);
	}
}
