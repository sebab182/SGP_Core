package SGP;

import SGP.Pedidos.GestorPedidosCarne;
import SGP.Stock.AgrupadordePiezas;
import SGP.Stock.AnalizadordeVencimiento;
import SGP.Stock.GestorStockPiezas;
import SGP.Stock.Pieza;

public class SGP {
	private AnalizadordeVencimiento analizadorVencimiento;
	private GestorStockPiezas gestorStock;
	private GestorPedidosCarne gestorPedidosCarne;
	private AgrupadordePiezas agrupadorPiezas;
	private ControlProduccion controlProduccion;

	//Constructor canonico
	public SGP(AnalizadordeVencimiento av, GestorStockPiezas gs, GestorPedidosCarne gpc, AgrupadordePiezas ap, ControlProduccion cp) {
		this.analizadorVencimiento= av;
		this.gestorStock= gs;
		this.gestorPedidosCarne= gpc;
		this.agrupadorPiezas= ap;
		this.controlProduccion= cp;
	}
	
	//Constructores convenience
	public SGP(AnalizadordeVencimiento av) {
		this(av,new GestorStockPiezas(),new GestorPedidosCarne(), new AgrupadordePiezas(),new ControlProduccion());
	}
	
	public SGP(AnalizadordeVencimiento av, GestorStockPiezas gsp) {
		this(av,gsp,new GestorPedidosCarne(), new AgrupadordePiezas(),new ControlProduccion());
	}
	
	public SGP(AnalizadordeVencimiento av, GestorStockPiezas gsp, Pieza p) {
		this(av,gsp,new GestorPedidosCarne(), new AgrupadordePiezas(),new ControlProduccion());
		gsp.agregarItem(p);
		run();
	}
	
	public void run() {
		analizadorVencimiento.analizarVencimientoPiezas(gestorStock);
	}

	public AnalizadordeVencimiento getAnalizadorVencimiento() {
		return analizadorVencimiento;
	}

	public void setAnalizadorVencimiento(AnalizadordeVencimiento analizadorVencimiento) {
		this.analizadorVencimiento = analizadorVencimiento;
	}

	public GestorStockPiezas getGestorStock() {
		return gestorStock;
	}

	public void setGestorStock(GestorStockPiezas gestorStock) {
		this.gestorStock = gestorStock;
	}

	public GestorPedidosCarne getGestorPedidosCarne() {
		return gestorPedidosCarne;
	}

	public void setGestorPedidosCarne(GestorPedidosCarne gestorPedidosCarne) {
		this.gestorPedidosCarne = gestorPedidosCarne;
	}

	public AgrupadordePiezas getAgrupadorPiezas() {
		return agrupadorPiezas;
	}

	public void setAgrupadorPiezas(AgrupadordePiezas agrupadorPiezas) {
		this.agrupadorPiezas = agrupadorPiezas;
	}

	public ControlProduccion getControlProduccion() {
		return controlProduccion;
	}

	public void setControlProduccion(ControlProduccion controlProduccion) {
		this.controlProduccion = controlProduccion;
	}
}
