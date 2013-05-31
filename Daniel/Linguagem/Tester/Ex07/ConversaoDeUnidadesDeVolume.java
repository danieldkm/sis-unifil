package Ex07;

public class ConversaoDeUnidadesDeVolume {
	public static ConversaoDeUnidadesDeVolume cuv;
	
	public ConversaoDeUnidadesDeVolume() {
	}
	
	public static double litroConverterCentimetro(int litro){
		int cc = 1000;
		return cc * litro;
	}
	
	public static double metroConverterLitro(int metro){
		int l = 1000;
		return l * metro;
	}
	
	public static double metroConverterPes(int metro){
		float pes = 32.32f;
		return pes * metro;
	}
	
	public static double galaoConverterPolegadas(int galao){
		int polegada = 231;
		return polegada * galao;
	}
	
	public static double galaoConverterLitro(float galao){
		float litros = 3.785f;
		return galao * litros;
	}
}
