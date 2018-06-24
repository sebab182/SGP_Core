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
	public  Integer calcularFaena(GestorPedidosCarne pedidos, GestorStockPiezas stock) {
		Integer faenar=0;
		
		HashMap<Tipo, Integer> totalPedido= pedidos.totalPorPieza();
		HashMap<Tipo, Integer> PedidoFaltante= new HashMap<Tipo, Integer>();
		
		for(Entry<Tipo, Integer> item: totalPedido.entrySet())
		{
			Integer saldo= reducirStock(item.getKey(), item.getValue(),stock);
			PedidoFaltante.put(item.getKey(), saldo);
		}
	
		for(Entry<Tipo, Integer> item: PedidoFaltante.entrySet())
		{
			if(item.getValue()>faenar)
				faenar=item.getValue();
		}
		
		
		return faenar;
		
		
		
	}

	
	private Integer reducirStock(Tipo tipo, Integer cantidadPedida,  GestorStockPiezas stock)
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
