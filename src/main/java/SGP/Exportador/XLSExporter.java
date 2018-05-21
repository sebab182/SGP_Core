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
	private String path;
	private String extension="xls";
	
	public XLSExporter(String nombreArchivo, String path) {
		this.nombreArchivo=nombreArchivo;
		this.path=path;
	}
	
	public XLSExporter() {
		//Constructor vacio para class for name
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
				fw = new FileWriter(path+nombreArchivo+"."+extension);
				fw.write(salida);
				fw.close();
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("Se produjo el siguiente error: "+e.getMessage());
			}
	}

	@Override
	public void setNombre(String nombre) {
		this.nombreArchivo=nombre;
		
	}

	@Override
	public void setPath(String path) {
		this.path=path;
		
	}

}
