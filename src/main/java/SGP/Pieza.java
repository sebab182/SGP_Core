package main.java.SGP;
import java.io.Serializable;
import java.util.Date;

public class Pieza implements Serializable {
	
private	Tipo tipoPieza;
private Date fechaVencimiento;

	public Pieza(Tipo tipo, Date fechaVencimiento) {
		this.tipoPieza=tipo;
		this.fechaVencimiento= fechaVencimiento;
	}

	public Tipo getTipoPieza() {
		return tipoPieza;
	}

	public void setTipoPieza(Tipo tipoPieza) {
		this.tipoPieza = tipoPieza;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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
		Pieza other = (Pieza) obj;
		if (tipoPieza == null) {
			if (other.tipoPieza != null)
				return false;
		} else if (!tipoPieza.equals(other.tipoPieza))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.tipoPieza.getTipoPieza();
	}
}

