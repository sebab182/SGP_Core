package SGP.Stock;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import SGP.Vencimiento.Almacenamiento;
import SGP.Vencimiento.CalculadorVencimiento;
import SGP.Vencimiento.VidaCorta;
import SGP.Vencimiento.VidaLarga;
import SGP.Vencimiento.VidaUtil;

public class Pieza implements Serializable {
	
private static final long serialVersionUID = 1L;
private	Tipo tipoPieza;
private Date fechaElaboracion;
private Date fechaVencimiento;
private VidaUtil vidaUtil;


public Pieza(Tipo tipo, Date fechaElaboracion, Date fechaVencimiento, VidaUtil vidaUtil) {
	this.tipoPieza=tipo;
	this.fechaElaboracion = fechaElaboracion;
	this.fechaVencimiento= fechaElaboracion; //Se inicia con la misma fecha de elaboracion luego se calcula
	this.vidaUtil= vidaUtil;
}
	
	//Parser de una pieza a partir de un String
	public Pieza(String pieza) {
		//tipoPieza - fechaPieza
		this(parseTipo(pieza),parseElaboracion(pieza),parserVencimiento(pieza),parserVidaUtil(pieza));
	}
	
	private static VidaUtil parserVidaUtil(String v) {
		String[] aux = v.split(" ");
		String vidaUtil = aux[2];
		if(vidaUtil.contains("l")) {
			return new VidaLarga();
		}
		else {
			return new VidaCorta();
		}
	}

	private static Date parserVencimiento(String pieza) {
		CalculadorVencimiento c = new CalculadorVencimiento();
		return null;
	}

	private static Tipo parseTipo(String t) {
		String[] aux = t.split(" ");
		return new Tipo(aux[0]);
	}
	
	@SuppressWarnings("deprecation")
	private static Date parseElaboracion(String d) {
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
	
	public Date getFechaElaboracion() {
		return fechaElaboracion;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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
		if (fechaVencimiento == null) {
			if (other.fechaVencimiento != null)
				return false;
		} else if (!fechaVencimiento.equals(other.fechaVencimiento))
			return false;
		if (tipoPieza == null) {
			if (other.tipoPieza != null)
				return false;
		} else if (!tipoPieza.equals(other.tipoPieza))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.tipoPieza.getNombreTipo();
	}

	public VidaUtil getVidaUtil() {
		return vidaUtil;
	}
}