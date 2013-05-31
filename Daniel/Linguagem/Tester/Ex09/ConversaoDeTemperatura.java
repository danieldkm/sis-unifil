package Ex09;

public class ConversaoDeTemperatura {
	public static double celsiusParaFahrenheit(int c){
		return c * 1.8f + 32;
	}
	
	public static double fahrenheitParaCelsius(int f){
		return (f - 32) / 1.8f;
	}
	
	public static double celsiusParaKelvin(int c){
		return c + 273.15f;
	}
	
	public static double kelvinParaCelsius(int k){
		return k - 273.15f;
	}
	
	public static double celsiusParaReaumur(int c){
		return c * (4/5f);
	}
	
	public static double reaumurParaCelsius(int re){
		return re * (5/4f);
	}
	
	public static double kelvinParaRankine(int k){
		return k * 1.8f;
	}
	
	public static double rankineParaKelvin(int r){
		return r / 1.8f;
	}
}
