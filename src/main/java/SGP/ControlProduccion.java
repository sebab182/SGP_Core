package SGP;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import SGP.Pedidos.GestorPedidosCarne;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;
import SGP.Stock.Tipo;

public class ControlProduccion implements IControladorProduccion {

	@Override
	public  Double calcularFaena(GestorPedidosCarne pedidos, GestorStockPiezas stock) {
		Double faenar=0.0;
		
		HashMap<Tipo, Double> totalPedido= pedidos.totalPorPieza();
		
		for(Entry<Tipo, Double> item: totalPedido.entrySet())
		{
			Double saldo= reducirStock(item.getKey(), item.getValue(),stock);
			totalPedido.put(item.getKey(), saldo);
		}
	
		for(Entry<Tipo, Double> item: totalPedido.entrySet())
		{
			if(item.getValue()>faenar)
				faenar=item.getValue();
		}
		
		return faenar;
		
		
		
	}

	
	private Double reducirStock(Tipo tipo, Double cantidadPedida,  GestorStockPiezas stock)
	{
		for(Pieza p: stock.getStock())
		{
			if(p.getTipoPieza().equals(tipo))
			{
				stock.quitarItem(p);
				cantidadPedida--;
			}
		}
		return cantidadPedida;
	}
	
	
	@Override
	public List<Pieza> sobrantes() {
		// TODO Auto-generated method stub
		return null;
	}

}
