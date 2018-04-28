package SGP;

import java.util.HashMap;
import java.util.LinkedList;
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
		HashMap<Tipo, Double> PedidoFaltante= new HashMap<Tipo, Double>();
		
		for(Entry<Tipo, Double> item: totalPedido.entrySet())
		{
			Double saldo= reducirStock(item.getKey(), item.getValue(),stock);
			PedidoFaltante.put(item.getKey(), saldo);
		}
	
		for(Entry<Tipo, Double> item: PedidoFaltante.entrySet())
		{
			if(item.getValue()>faenar)
				faenar=item.getValue();
		}
		
		
		return faenar;
		
		
		
	}

	
	private Double reducirStock(Tipo tipo, Double cantidadPedida,  GestorStockPiezas stock)
	{
		LinkedList<Pieza> quitarS = new LinkedList<Pieza>();
		
		for(Pieza p: stock.getStock())
		{
			if(p.getTipoPieza().equals(tipo))
			{
				//stock.quitarItem(p);
				if(cantidadPedida!=0.0) {
					quitarS.add(p);
					cantidadPedida--;
				}
			}
		}
		stock.getStock().removeAll(quitarS);
		return cantidadPedida;
	}
	
	
	@Override
	public List<Pieza> sobrantes() {
		// TODO Auto-generated method stub
		return null;
	}

}
