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
}
