package main.SGP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DatosSerializable implements AbstractFactory {
	
	public DatosSerializable() throws ClassNotFoundException {
	}
	
	private void guardarDatos() {
		try
		{
			FileOutputStream fos = new FileOutputStream("piezas.txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			//out.writeObject(piezas);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void leerDatos() {
		try {
			FileInputStream fis = new FileInputStream("piezas.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			//piezas = (List<Pieza>) in.readObject();
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Pieza> cargarPiezas() {
		List<Pieza>piezas = new LinkedList<Pieza>();
		try {
			FileInputStream fis = new FileInputStream("piezas.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			piezas = (List<Pieza>) in.readObject();
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return piezas;
	}

	public Map<Pieza, Integer> cargarStock() {
		Map<Pieza,Integer>stock = new HashMap<Pieza,Integer>();
		try {
			FileInputStream fis = new FileInputStream("stock.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			stock = (HashMap<Pieza,Integer>) in.readObject();
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return stock;
	}

	public List<Map<Pieza, Integer>> cargarPedidos() {
		List<Map<Pieza,Integer>>pedidos = new LinkedList<Map<Pieza,Integer>>();
		try {
			FileInputStream fis = new FileInputStream("pedidos.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			pedidos = (List<Map<Pieza,Integer>>) in.readObject();
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}

	@Override
	public GestordeStock cargarGestordeStock() {
		GestordeStock gs = new GestordeStock();
		try {
			FileInputStream fis = new FileInputStream("gestorStock.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			gs= (GestordeStock) in.readObject();
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return gs;
	}
}
