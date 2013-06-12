package Ex06;

public class ConversaoDeUnidadesDeArea {
	private final double metroPes = 10.76;// pes
	private final double pesCentimetros = 929;// centimetros
	private final double milhaAcres = 640;// acres
	private final double acrePes = 43.560;// pes
	public static double tt = 0;
	
	private ConversaoDeUnidadesDeArea(){
	}
	
	public static ConversaoDeUnidadesDeArea cua;

	public static double metroQuadradoPes (double metro) {
		cua = new ConversaoDeUnidadesDeArea();
		return cua.metroPes * metro;
	}

	public static double pesQuadradoCentimetro(double pes) {
		cua = new ConversaoDeUnidadesDeArea();
		return cua.pesCentimetros * pes;
	}

	public static double milhaQuadradoAcre(double milha) {
		cua = new ConversaoDeUnidadesDeArea();
		return cua.milhaAcres * milha;
	}

	public static double acreQuadradoPes(double acre) {
		cua = new ConversaoDeUnidadesDeArea();
		return cua.acrePes * acre;
	}
}
