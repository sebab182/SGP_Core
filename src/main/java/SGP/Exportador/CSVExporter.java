package SGP.Exportador;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import SGP.Stock.GestorStock;
import SGP.Stock.Pieza;

public class CSVExporter implements Exporter {
	private String salida;
	private String nombreArchivo;
	private String extension="csv";
	
	public CSVExporter(String nombreArchivo) {
		this.nombreArchivo=nombreArchivo;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void generarInforme(GestorStock gs) {
		salida="Pieza,FechaVencimiento";
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
		for(Pieza p: (List<Pieza>)gs.getStock()) {
			salida = salida+"\n" + p.toString()+ ","+ fecha.format(p.getFechaVencimiento());
		}
			FileWriter fw;
			try {
				fw = new FileWriter(nombreArchivo+"."+extension);
				fw.write(salida);
				fw.close();
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("Se produjo el siguiente error: "+e.getMessage());
			}
	}

}
