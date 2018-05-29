package SGP;

import SGP.Conservacion.Conservacion;
import SGP.Conservacion.ConservacionNull;
import SGP.Inspeccion.Inspector;
import SGP.Inspeccion.InspectorTrucho;

public class MainInspeccion {

	public static void main(String[] args) {
		/*
		 * Hay que instanciar los subtipos de
		 * Inspector y de Conservacion y
		 * devuelve los dias que le quedan
		 * a la carne sin vencer.
		 */
		Conservacion c = new ConservacionNull();
		Inspector i = new InspectorTrucho();
		System.out.println("A la carne le quedan "+i.inspeccionar(c)+" dias para vencer."); // Devuelve un int tambien
	}

}
