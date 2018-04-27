package SGP.Criterios;

public class Cliente {
	
	private String nombre;
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Cliente c = (Cliente) o;
		return this.getNombre().equals(c.getNombre());
	}

}
