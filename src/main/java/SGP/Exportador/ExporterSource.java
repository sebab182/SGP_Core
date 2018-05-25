package SGP.Exportador;

public class ExporterSource {
	private String factory; //Path y nombre de la clase de Datos a cargar.
	
	public ExporterSource(String tipo) {
		tipo.toLowerCase();
		if(tipo.equals("txt")) {
			factory= TXTExporter.class.getName();
		}
		if(tipo.equals("csv")) {
			factory= CSVExporter.class.getName();
		}
		if(tipo.equals("xls")){
			factory= XLSExporter.class.getName();
	}
}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}
	
	
}
