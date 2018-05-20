package SGP.Exportador;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import SGP.Stock.GestorStock;
import SGP.Stock.Pieza;

public class TXTExporter implements Exporter {
	private String salida;
	private String nombreArchivo;
	private String extension="txt";
	
	public TXTExporter(String nombreArchivo) {
		this.nombreArchivo=nombreArchivo;
	}

	@Override
	public void generarInforme(GestorStock gs) {
		salida = "==================SISTEMA DE GESTION DE PIEZAS==================";
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
		salida = salida + "\nFecha: "+fecha.format(new Date());
		SimpleDateFormat hora = new SimpleDateFormat("HH:mm", Locale.getDefault());
		salida = salida + "\nHora: "+hora.format(new Date());
		salida = salida + "\n======================INVENTARIO======================";
		for(Pieza p: (List<Pieza>)gs.getStock()) {
			salida = salida + "\nPieza: "+p.toString()+ "    |     Fecha de vencimiento: "+ fecha.format(p.getFechaVencimiento());
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
