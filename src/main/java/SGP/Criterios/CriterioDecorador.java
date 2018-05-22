package SGP.Criterios;

public abstract class CriterioDecorador implements Criterio {

	protected Criterio siguiente;
	
	public CriterioDecorador() {
		this.siguiente = null;
	}
	
	public void combinar(Criterio criterio) {
		if (this.siguiente == null)
			this.siguiente = criterio;
		else
			this.siguiente.combinar(criterio);
	}
	
	public boolean hayOtroCriterio() {
		return this.siguiente != null;
	}
	
	public Criterio siguienteCriterio() {
		return this.siguiente;
	}
	
}
