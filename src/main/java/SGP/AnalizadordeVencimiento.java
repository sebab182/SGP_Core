package main.java.SGP;
import java.util.Date;
import java.util.List;

public class AnalizadordeVencimiento extends Thread  {
	private GestordeStockN gestorStock;
	private boolean finProcesamiento;

	public AnalizadordeVencimiento(GestordeStockN gestorStock) {
		this.gestorStock= gestorStock;
		this.finProcesamiento=false;
	}
	
	@Override
	public void run() {
		while(finProcesamiento==false) {
			List<PiezaN>listaStock = gestorStock.getStock();
			finProcesamiento = listaStock.isEmpty();
			Date fechaActual = new Date();
			for(PiezaN p: listaStock){
				System.out.println("Analizando: "+p.getTipoPieza().getTipoPieza()+" vence en "+p.getFechaVencimiento().toString());
				Date fechaVencimiento = p.getFechaVencimiento();
			if(analizarVencimiento(fechaActual, fechaVencimiento)){
				gestorStock.quitarPieza(p);
				break;
			}
		}
		}
		try {
			sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private boolean analizarVencimiento(Date fechaActual, Date fechaVencimiento) {
		int v = fechaActual.compareTo(fechaVencimiento);
		boolean r=(v>0)?true:false;
		return r;
	}



}
