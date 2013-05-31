package Ex06;

public class ConversaoDeUnidadesDeArea {
	private final double metro = 10.76;// pes
	private final double pes = 929;// centimetros
	private final double milha = 640;// acres
	private final double acre = 43.560;// pes
	public static double tt = 0;
	
	private ConversaoDeUnidadesDeArea(){
	}
	
	public static ConversaoDeUnidadesDeArea cua;

	public static double metroQuadradoPes (double metro) {
		cua = new ConversaoDeUnidadesDeArea();
		return cua.metro * metro;
	}

	public static double pesQuadradoCentimetro(double pes) {
		cua = new ConversaoDeUnidadesDeArea();
		return cua.pes * pes;
	}

	public static double milhaQuadradoAcre(double milha) {
		cua = new ConversaoDeUnidadesDeArea();
		return cua.milha * milha;
	}

	public static double acreQuadradoPes(double acre) {
		cua = new ConversaoDeUnidadesDeArea();
		return cua.acre * acre;
	}
}
