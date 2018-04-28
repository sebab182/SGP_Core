package SGP.Datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataSource {
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

	public String getFactory() {
		//Aca mandamos la ubicación de la clase del factory! :)
		String factory ="";
		String clase = "";
		if(source.equals("test")) {
			//Cargando datos hardcodeados
			//TODO: Aca tenemos el problema! No carga datos hardcodeados por que no esta en el mismo src
			factory = DatosHardcodeados.class.getPackage().toString();
			factory = factory.substring(8); //Eliminamos "package"
			clase = "DatosHardcodeados";
			factory = factory+"."+clase;
		}
		else {
			//Cargando datos serializados
			factory = DatosSerializable.class.getPackage().toString();
			factory = factory.substring(8); 
			clase = "DatosSerializable";
			factory = factory+"."+clase;
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
