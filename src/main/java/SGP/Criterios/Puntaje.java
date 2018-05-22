package SGP.Criterios;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import SGP.Pedidos.Pedido;
import SGP.Stock.Tipo;

public class Puntaje {
	
	static Map<Pedido<Tipo>, Integer> puntuar(List<Pedido<Tipo>> pedidos, Criterio criterio) {
		Map<Pedido<Tipo>, Integer> puntajes = new HashMap<Pedido<Tipo>, Integer>();
		for (Pedido<Tipo> p: pedidos)
			puntajes.put(p, criterio.puntuar(p));
		return puntajes;
	}
	
	static boolean hayEmpate(List<Pedido<Tipo>> pedidos, Map<Pedido<Tipo>, Integer> puntajes) {
		List<Integer> control = new LinkedList<Integer>();
		
		if (pedidos.size() > 1) {
			for (Pedido<Tipo> p: pedidos) {
				if (!control.isEmpty() && control.contains(puntajes.get(p)))
					return true;
				control.add(puntajes.get(p));
			}
		}
		
		return false;
		
	}
	
	static List<List<Pedido<Tipo>>> sublistasDeEmpates(List<Pedido<Tipo>> pedidos, Map<Pedido<Tipo>, Integer> puntajes) {
		
		List<List<Pedido<Tipo>>> sublistas = new LinkedList<List<Pedido<Tipo>>>();
		List<Integer> indexlist = new LinkedList<Integer>();
		List<Pedido<Tipo>> sublista_actual = new LinkedList<Pedido<Tipo>>();
		
		boolean empate_previo = false;
		
		for (int i=0; i<pedidos.size()-1; i++) {
			
			int puntaje1 = puntajes.get(pedidos.get(i));
			int puntaje2 = puntajes.get(pedidos.get(i+1));
			
			boolean empate = puntaje1 == puntaje2;
			
			if (empate && !empate_previo) {
				empate_previo = true;
				indexlist.add(i);
				indexlist.add(i+1);
			}
			else if (empate && empate_previo)
				indexlist.add(i+1);
			else if (!empate && empate_previo)
				empate_previo = false;
			//else if (!empate && !empate_previo)	
		}
		
		for (int i =0; i<pedidos.size()-1; i++) {
			
			if (i==0)
				sublista_actual.add(pedidos.get(i));
			
			if ((indexlist.contains(i) && !indexlist.contains(i+1))
			|| (!indexlist.contains(i) && indexlist.contains(i+1))) {
				sublistas.add(sublista_actual);
				sublista_actual = new LinkedList<Pedido<Tipo>>();
			}
			
			sublista_actual.add(pedidos.get(i+1));
			
			if (i==pedidos.size()-2) {
				sublistas.add(sublista_actual);
				
			}
		}
		
		return sublistas;
		
	}

}
