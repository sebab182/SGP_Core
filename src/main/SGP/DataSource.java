package main.SGP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataSource {
	private String ruta; //Nombre del archivo a leer
	private String source; //Path y nombre de la clase de Datos a cargar.

	public DataSource(String ruta) {
		this.ruta= ruta; 
		try {
			leerDatos();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void leerDatos() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(ruta));
		source = in.readLine();
		in.close();
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getSource() {
		//Aca mandamos la ubicación de la clase del factory! :)
		String factory ="";
		String clase = "";
		if(source.equals("test")) {
			//Cargando datos hardcodeados
			clase = "DatosHardcodeados";
			factory = "test.SGP."+clase;
		}
		else {
			//Cargando datos serializados
			clase = "DatosSerializable";
			factory = "main.SGP."+clase;
		}
		
		return factory;
	}

}
