package SGP.Datos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataSource {
	private String factory; //Path y nombre de la clase de Datos a cargar.
	
	public DataSource(String nombreTXT) {
		try {
			File currDir = new File("");
			String path = currDir.getAbsolutePath();
			path = path.replace("SGP_UI", "SGP_CORE");
			//System.out.println(path+"\\"+nombreTXT);
			BufferedReader in = new BufferedReader(new FileReader(path+"\\"+nombreTXT)); //Leo el archivo
			String source = in.readLine(); //Leo el tipo de factory a cargar
			in.close(); //Cierro el archivo
			if(source.equals("test")) {
				factory = DatosHardcodeados.class.getName(); //Cargando datos hardcodeados
			}
			else {
				factory = DatosSerializable.class.getName(); //Cargando datos serializados
			}	
		} catch (IOException e) {
			System.out.println("Se produjo el siguiente error: "+e.getMessage());
		}
	}

	public String getFactory() {
		return factory;
	}
	
	public void setFactory(String f) {
		factory = f;
	}
}
