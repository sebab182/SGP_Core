package main.SGP;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        //System.out.println("Test GIT");
        Pieza p = new Pieza("pata1");
        Pieza p1 = new Pieza("muslo");
        
        Pedido pedido = new Pedido();
        pedido.agregarPieza(p);
        pedido.agregarPieza(p1);
        System.out.println(pedido);
        
        Distribucion d = new Distribucion();
        d.agregarPiezas(pedido.getPedido());
        System.out.println(d);
        
        System.out.println(p.equals(p));
    }
}
