package main.java.SGP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import main.java.SGP.Pedidos.Pedido;

public class DatosSerializable implements AbstractFactory {
	
	public DatosSerializable() throws ClassNotFoundException {
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

	public List<Pedido<Tipo>> cargarPedidos() {
		List<Pedido<Tipo>>pedidos = new LinkedList<Pedido<Tipo>>();   	
		try {
			FileInputStream fis = new FileInputStream("pedidos.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			pedidos = (List<Pedido<Tipo>>) in.readObject();
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}

	@Override
	public GestordeStock cargarGestordeStock() {
		GestordeStock gestorStock = new GestordeStock();		
		try {
			FileInputStream fis = new FileInputStream("gestorStock.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			gestorStock= (GestordeStock) in.readObject();
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return gestorStock;
	}
}
