package SGP.Vencimiento;

public abstract class Almacenamiento {
	abstract int obtenerValorVencimiento(VidaUtil v);
	abstract int obtenerValorVencimiento(VidaLarga v);
	abstract int obtenerValorVencimiento(VidaCorta v);
}