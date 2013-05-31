package Ex09;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Celsius tem " + ConversaoDeTemperatura.celsiusParaFahrenheit(1) + " Fahrenheit");
		System.out.println("Celsius tem " + ConversaoDeTemperatura.celsiusParaKelvin(1) + " Kelvin");
		System.out.println("Celsius tem " + ConversaoDeTemperatura.celsiusParaReaumur(1) + " Reaumur");
		System.out.println("Fahrenheit tem " + ConversaoDeTemperatura.fahrenheitParaCelsius(1) + " Celsius");
		System.out.println("Kelvin tem " + ConversaoDeTemperatura.kelvinParaCelsius(1) + " Celsius");
		System.out.println("Kelvin tem " + ConversaoDeTemperatura.kelvinParaRankine(1) + " Rankine");
		System.out.println("Rankine tem " + ConversaoDeTemperatura.rankineParaKelvin(1) + " Kelvin");
		System.out.println("Reaumur tem " + ConversaoDeTemperatura.reaumurParaCelsius(1) + " Celsius");
	}

}
