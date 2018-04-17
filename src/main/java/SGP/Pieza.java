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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pieza other = (Pieza) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}

