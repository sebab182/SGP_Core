package SGP.Email;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
			p.load(new FileReader("Account.properties"));
			direccionMail=p.getProperty("email");
			usuario=p.getProperty("user");
			contrasena=p.getProperty("password");
			host = p.getProperty("host");
			puerto=p.getProperty("port");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
}
