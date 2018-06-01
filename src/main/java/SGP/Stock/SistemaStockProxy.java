package SGP.Stock;
import java.util.HashSet;
import java.util.List;

public interface SistemaStockProxy {
	public List<Pieza>cargarPiezas();
	public HashSet<Tipo> cargarConjuntoVaca();
	
}
