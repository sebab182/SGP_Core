package main.SGP;

public class Pieza {
	
	private String nombrePieza;
	
	public Pieza(String nombrePieza) {
		this.nombrePieza=nombrePieza;
	}

	public String getNombrePieza() {
		return nombrePieza;
	}

	public void setNombrePieza(String nombrePieza) {
		this.nombrePieza = nombrePieza;
	}

	@Override
	public String toString() {
		return this.nombrePieza;
	}
	
}
