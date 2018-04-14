package main.java.SGP;

import java.io.Serializable;
import java.util.Date;

public class Pieza implements Serializable {
	
private	String nombre;
private Date fechaVencimiento; 

	public Pieza(String nombre) {
		this.nombre= nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public boolean equals(Pieza obj) {
		return this.nombre.equals(obj.getNombre());
	}
}

