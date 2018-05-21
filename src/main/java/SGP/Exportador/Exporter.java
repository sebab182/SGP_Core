package SGP.Exportador;

import SGP.Stock.GestorStock;

public interface Exporter {

	public void generarInforme(GestorStock gs);
	public void setNombre(String nombre);
	public void setPath(String path);
}
