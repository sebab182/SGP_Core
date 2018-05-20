package SGP.Exportador;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import SGP.Stock.GestorStock;
import SGP.Stock.Pieza;

public class XLSExporter implements Exporter {
	private String salida;
	private String nombreArchivo;
	private String extension="xls";
	
	public XLSExporter(String nombreArchivo) {
		this.nombreArchivo=nombreArchivo;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void generarInforme(GestorStock gs) {
		salida = "INFORME STOCK";
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
		salida = salida+"\nFecha: "+"\t"+ fecha.format(new Date());
		salida = salida+"\n";
		salida=salida+"\nPieza\tFechaVencimiento";
		for(Pieza p: (List<Pieza>)gs.getStock()) {
			salida = salida+"\n" + p.toString()+ "\t"+ fecha.format(p.getFechaVencimiento());
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
