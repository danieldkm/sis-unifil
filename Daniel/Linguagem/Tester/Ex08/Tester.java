package Ex08;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Ano tem " + ConversaoDeUnidadesDeTempo.anoConverterDia(1) + " Dias");
		System.out.println("Dias tem " + ConversaoDeUnidadesDeTempo.diaConverterHora(1) + " Horas");
		System.out.println("Horas tem " + ConversaoDeUnidadesDeTempo.horaConverterMinutos(1) + " Minutos");
		System.out.println("Mes tem " + ConversaoDeUnidadesDeTempo.mesConverterDia(1) + " Dias");
		System.out.println("Minutos tem " + ConversaoDeUnidadesDeTempo.minutoConverterSegundos(1) + " Segundos");
		System.out.println("Semana tem " + ConversaoDeUnidadesDeTempo.semanaConverterDia(1) + " Dias");
	}

}
