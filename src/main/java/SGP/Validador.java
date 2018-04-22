package main.java.SGP;

import java.util.List;

public interface Validador<T> {
	
	List<String> validar(T info);

}
