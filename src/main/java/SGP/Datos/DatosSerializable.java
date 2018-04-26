package SGP.Datos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import SGP.GestordeStock;
import SGP.Pieza;
import SGP.Tipo;
import SGP.Pedidos.Pedido;
import SGP.Pedidos.PedidoCarne;

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
		List<Pedido<Tipo>>pedidos= new LinkedList<Pedido<Tipo>>();
		Pedido<Tipo> a = new PedidoCarne();
		a.agregarItem(new Tipo("muslo"), 3.0);
		a.agregarItem(new Tipo("pata"), 5.0);
		pedidos.add(a);
		
		Pedido<Tipo> b = new PedidoCarne();
		b.agregarItem(new Tipo("vacio"), 4.0);
		b.agregarItem(new Tipo("muslo"), 7.0);
		b.agregarItem(new Tipo("pata"), 3.0);
		pedidos.add(b);	
		
		Pedido<Tipo> c = new PedidoCarne();
		c.agregarItem(new Tipo("lomo"), 8.0);
		c.agregarItem(new Tipo("pata"), 2.0);
		pedidos.add(c);
		
		try
		{
			FileOutputStream fos = new FileOutputStream("pedidos.txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(pedidos);
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		
		/* Corrompe los pedidos!
		try {
			FileInputStream fis = new FileInputStream("pedidos.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			pedidos = (List<Pedido<Tipo>>) in.readObject();
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
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
