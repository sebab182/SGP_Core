package SGP.Email;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Account {
	String direccionMail;
	String usuario;
	String contrasena;
	String host;
	String puerto;
	
	public Account(String d, String u, String c, String h, String p) {
		this.direccionMail=d;
		this.usuario=u;
		this.contrasena=c;
		this.host = h;
		this.puerto=p;
	}
	
	//Levantamos los datos del archivo Account.properties
	public Account() {
		Properties p = new Properties();
		try {
			File currDir = new File("");
			String path = currDir.getAbsolutePath();
			path = path.replace("SGP_UI", "SGP_CORE");
			p.load(new FileReader(path+"//Account.properties"));
			direccionMail=p.getProperty("email");
			usuario=p.getProperty("user");
			contrasena=p.getProperty("password");
			host = p.getProperty("host");
			puerto=p.getProperty("port");
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
		result = prime * result + ((direccionMail == null) ? 0 : direccionMail.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;}
		Account other = (Account) obj;
		if(other.getUsuario()==null || other.getContrasena()==null || other.getDireccionMail()==null) {
			return false;}
		return(usuario.equals(other.getUsuario()) && contrasena.equals(other.getContrasena()) && direccionMail.equals(other.getDireccionMail()));
	}
	
	
}
