package SGP.Pedidos;

public class Local {
	private String nombreLocal;
	private String email;

	public Local(String nombreLocal, String email) {
		this.nombreLocal=nombreLocal;
		this.email=email;
	}

	public String getNombreLocal() {
		return nombreLocal;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nombreLocal == null) ? 0 : nombreLocal.hashCode());
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
		Local other = (Local) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombreLocal == null) {
			if (other.nombreLocal != null)
				return false;
		} else if (!nombreLocal.equals(other.nombreLocal))
			return false;
		return true;
	}
}
