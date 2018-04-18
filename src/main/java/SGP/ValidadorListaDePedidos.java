package main.java.SGP;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ValidadorListaDePedidos implements Validador<List<Map<Pieza, Integer>>>{

	@Override
	public List<String> validar(List<Map<Pieza, Integer>> info) {
		List<String> errores = new LinkedList<String>();
		
		for (Map<Pieza, Integer> pedido: info) {
			if (pedido.isEmpty()) {
				errores.add("La lista contiene un pedido vacio.");
				break;
			}
		}
		
		return errores;
	}

}
