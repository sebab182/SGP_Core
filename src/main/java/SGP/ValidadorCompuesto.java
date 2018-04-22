package main.java.SGP;

import java.util.LinkedList;
import java.util.List;

public class ValidadorCompuesto<T> implements Validador<T>{

	private final List<Validador<T>> validadores;
	
	public ValidadorCompuesto(List<Validador<T>> validadores) {
		this.validadores = validadores;
	}
	
	@Override
	public List<String> validar(T info) {
		List<String> errores = new LinkedList<String>();
		
		for (Validador<T> validador: this.validadores)
			errores.addAll(validador.validar(info));
		
		return errores;
	}

}
