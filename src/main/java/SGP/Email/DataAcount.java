package SGP.Email;

public class DataAcount {
	String direccionMail;
	String usuario;
	String contrasena;
	String host;
	String puerto;
	
	public DataAcount(String d, String u, String c, String h, String p) {
		this.direccionMail=d;
		this.usuario=u;
		this.contrasena=c;
		this.host = h;
		this.puerto=p;
	}

	public String getDireccionMail() {
		return direccionMail;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getHost() {
		return host;
	}

	public String getPuerto() {
		return puerto;
	}	
}
