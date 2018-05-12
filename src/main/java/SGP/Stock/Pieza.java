package SGP.Stock;
import java.io.Serializable;
import java.util.Date;

public class Pieza implements Serializable {
	
private static final long serialVersionUID = 1L;
private	Tipo tipoPieza;
private Date fechaVencimiento;

	public Pieza(Tipo tipo, Date fechaVencimiento) {
		this.tipoPieza=tipo;
		this.fechaVencimiento= fechaVencimiento;
	}
	
	//Parser de una pieza a partir de un String
	public Pieza(String pieza) {
		//tipoPieza - fechaPieza
		this(parseTipo(pieza),parseDate(pieza));
	}
	
	private static Tipo parseTipo(String t) {
		String[] aux = t.split(" ");
		return new Tipo(aux[0]);
	}
	
	@SuppressWarnings("deprecation")
	private static Date parseDate(String d) {
		String[] aux = d.split(" ");
		return new Date(Date.parse(aux[1]));
	}

	public Tipo getTipoPieza() {
		return tipoPieza;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaVencimiento == null) ? 0 : fechaVencimiento.hashCode());
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