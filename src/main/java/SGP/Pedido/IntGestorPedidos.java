package main.java.SGP.Pedido;
import java.util.Map;
import java.util.Set;

/*Interface para mediador de pedidos*/
public interface IntGestorPedidos<T> {
	public void agregarPedido(T pedido);
	public void quitarPedido(T pedido);
	public void vaciarPedidos();
	public  T menorPrioridad();
	public int totalPedidos();
}
