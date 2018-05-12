package SGP.Datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataSource {
	private String factory; //Path y nombre de la clase de Datos a cargar.
	
	public DataSource(String nombreTXT) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(nombreTXT)); //Leo el archivo
			String source = in.readLine(); //Leo el tipo de factory a cargar
			in.close(); //Cierro el archivo
			if(source.equals("test")) {
				factory = DatosHardcodeados.class.getName(); //Cargando datos hardcodeados
			}
			else {
				factory = DatosSerializable.class.getName(); //Cargando datos serializados
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getFactory() {
		return factory;
	}
	
	public void setFactory(String f) {
		factory = f;
	}
}
