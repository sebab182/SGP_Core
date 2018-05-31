package SGP;

public class CriteriosAceptacionTestsSprint2 {

	public static void main(String[] args) {
		//TEST US1
		//PROYECTO UI: No es necesario testear.
		//TEST US2
		SistemaStockTest sst = new SistemaStockTest();
		sst.testCargarPiezas();
		//TEST US3
		SistemaPedidosTest spt = new SistemaPedidosTest();
		spt.testCargarPedidos();
		//TEST US4
		DistribuidorTest dt = new DistribuidorTest();
		dt.testResolverPedidos();
		//TEST US5
		dt.testResolverPedidosNivelAprobacion();
		//TEST US6
		AccountTest at = new AccountTest();
		at.testAccount();
		at.testAccountArroba();
		at.testAccountContrasena();
		//TEST US7
		//PROYECTO VISTA: Modelo en proyecto UI
		//TEST US8
		ExporterSourceTest est = new ExporterSourceTest();
		est.testGetFactory();
		est.testGetFactoryCSV();
		est.testGetFactoryXLS();
		//TEST US9
		TXTExporterTest tet = new TXTExporterTest();
		tet.testGetExtension();
		tet.testGenerarInforme();
		tet.testGetSalida();
		//TEST US10
		CSVExporterTest cet = new CSVExporterTest();
		cet.testGetExtension();
		cet.testGenerarInforme();
		cet.testGetSalida();
		//TEST US11
		XLSExporterTest xet = new XLSExporterTest();
		xet.testGetExtension();
		xet.testGenerarInforme();
		xet.testGetSalida();
		//TEST US12
		CalculadorVencimientoTest cvt = new CalculadorVencimientoTest();
		cvt.testCalcularFechaVencimiento();
		cvt.testCalcularFechaVencimiento2();
		cvt.testCalcularFechaVencimiento3();
		cvt.testCalcularFechaVencimiento4();
	}
}
