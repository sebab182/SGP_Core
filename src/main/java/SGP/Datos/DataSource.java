package SGP.Datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataSource {
	private String ruta; //Nombre del archivo a leer
	private String source; //Path y nombre de la clase de Datos a cargar.
	private String nombreTXT; //Nombre del archivo TXT
	
	public DataSource(String nombreTXT) {
		this.nombreTXT= nombreTXT; 
		try {
			leerDatos();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void leerDatos() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(nombreTXT));
		source = in.readLine(); //Cargo el tipo de Factory
		in.close(); //Cierro el archivo
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getFactory() {
		//Aca mandamos la ubicación de la clase del factory! :)
		String factory ="";
		String clase = "";
		if(source.equals("test")) {
			//Cargando datos hardcodeados
			clase = "DatosHardcodeados";
			factory = "test.java.SGP."+clase;
		}
		else {
			//Cargando datos serializados
			clase = "DatosSerializable";
			factory = "main.java.SGP."+clase;
		}
		
		return factory;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
