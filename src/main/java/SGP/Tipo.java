package main.java.SGP;

import java.io.Serializable;

public class Tipo implements Serializable {
	private String tipoPieza;
	
	public Tipo(String tipoPieza) {
		this.tipoPieza= tipoPieza;
	}

	public String getTipoPieza() {
		return tipoPieza;
	}

	public void setTipoPieza(String tipoPieza) {
		this.tipoPieza = tipoPieza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoPieza == null) ? 0 : tipoPieza.hashCode());
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
		Tipo other = (Tipo) obj;
		if (tipoPieza == null) {
			if (other.tipoPieza != null)
				return false;
		} else if (!tipoPieza.equals(other.tipoPieza))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return tipoPieza;
	}
}
