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
	private String path;
	private String extension="txt";
	
	public TXTExporter(String nombreArchivo, String path) {
		this.nombreArchivo=nombreArchivo;
		this.path=path;
	}
	
	public TXTExporter() {
		//Constructor vacio para class for name
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
				System.out.println(path+nombreArchivo+"."+extension);
				fw = new FileWriter(path+nombreArchivo+"."+extension);
				fw.write(salida);
				fw.close();
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("Se produjo el siguiente error: "+e.getMessage());
			}
	}
	public String getExtension() {
		return extension;
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
