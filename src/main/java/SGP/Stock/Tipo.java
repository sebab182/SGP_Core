package SGP.Stock;

import java.io.Serializable;

public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombreTipo;
	
	public Tipo(String tipoPieza) {
		this.nombreTipo= tipoPieza;
	}

	public String getTipoPieza() {
		return nombreTipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreTipo == null) ? 0 : nombreTipo.hashCode());
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
		if (nombreTipo == null) {
			if (other.nombreTipo != null)
				return false;
		} else if (!nombreTipo.equals(other.nombreTipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nombreTipo;
	}
}
