package aula_2904;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class wil {

	private static int dados[];

	public static int[] cal() {
		dados = new int[2];

		GregorianCalendar v = new GregorianCalendar();
		GregorianCalendar date = new GregorianCalendar(v.get(Calendar.YEAR),
				v.get(Calendar.MONTH), 1);
		dados[0] = v.get(Calendar.DAY_OF_WEEK);
		dados[1] = v.getActualMaximum(Calendar.DAY_OF_MONTH);

		System.out.println("Ano Atual: " + v.get(Calendar.YEAR));
		System.out.println("Mes Atual: " + (v.get(Calendar.MONTH) + 1));

		if (date.get(Calendar.DAY_OF_WEEK) == 1) {
			System.out.println("Primeiro dia do mes: " + "Domingo");
		} else if (date.get(Calendar.DAY_OF_WEEK) == 2) {
			System.out.println("Primeiro dia do mes: " + "Segunda");
		} else if (date.get(Calendar.DAY_OF_WEEK) == 3) {
			System.out.println("Primeiro dia do mes: " + "Terça");
		} else if (date.get(Calendar.DAY_OF_WEEK) == 4) {
			System.out.println("Primeiro dia do mes: " + "Quarta");
		} else if (date.get(Calendar.DAY_OF_WEEK) == 5) {
			System.out.println("Primeiro dia do mes: " + "Quinta");
		} else if (date.get(Calendar.DAY_OF_WEEK) == 6) {
			System.out.println("Primeiro dia do mes: " + "Sexta");
		} else if (date.get(Calendar.DAY_OF_WEEK) == 7) {
			System.out.println("Primeiro dia do mes: " + "Sabado");
		}

		// for (int i = 1; i <= v.getActualMaximum(Calendar.DAY_OF_MONTH); i++)
		// {
		// System.out.println(i+"/"+(v.get(Calendar.MONTH)+1));
		// }

		return dados;
	}

	public static int[] cal(int mes) {
		mes = mes - 1;

		int dados[] = new int[2];
		GregorianCalendar aux = new GregorianCalendar();
		GregorianCalendar data = new GregorianCalendar(
				aux.get(Calendar.DAY_OF_YEAR), mes, 1);

		System.out.println("Ano: " + aux.get(Calendar.YEAR));
		System.out.println("Mes: " + mes(mes/*, aux.get(Calendar.DAY_OF_YEAR)*/));

		System.out.println("Primeiro dia do mês: " + DiaSemanal(mes + 1));
		System.out.println("Quantidade de dias do mês: "
				+ data.getActualMaximum(Calendar.DAY_OF_MONTH));
		dados[0] = data.get(Calendar.DAY_OF_WEEK);
		dados[1] = data.getActualMaximum(Calendar.DAY_OF_MONTH);
		return dados;
	}

	private static String DiaSemanal(int semana) {
//		mes = mes - 1;
//		GregorianCalendar aux = new GregorianCalendar();
//		GregorianCalendar d = new GregorianCalendar(aux.get(Calendar.YEAR),
//				mes, 1);

		if (semana == 1) {
			return "Domingo";
		} else if (semana == 2) {
			return "Segunda";
		} else if (semana == 3) {
			return "Terça";
		} else if (semana == 4) {
			return "Quarta";
		} else if (semana == 5) {
			return "Quinta";
		} else if (semana == 6) {
			return "Sexta";
		} else if (semana == 7) {
			return "Sabado";
		} else {
			return "Erro";
		}
	}

	
	private static String mes(/*int ano,*/ int mes) {

//		GregorianCalendar meses = new GregorianCalendar(ano, mes, 1);

		if (mes == 0) {
			return "Janeiro";
		} else if (mes == 1) {
			return "Fevereiro";
		} else if (mes == 2) {
			return "Março";
		} else if (mes == 3) {
			return "Abril";
		} else if (mes== 4) {
			return "Maio";
		} else if (mes == 5) {
			return "Junho";
		} else if (mes == 6) {
			return "Julho";
		} else if (mes == 7) {
			return "Agosto";
		} else if (mes == 8) {
			return "Setembro";
		} else if (mes == 9) {
			return "Outubro";
		} else if (mes == 10) {
			return "Novembro";
		} else if (mes == 11) {
			return "Dezembro";
		} else {
			return "Erro";
		}

	}

	public static int[] cal(int a, int m) {
		m = m - 1;
		int[] dados;
		dados = new int[2];
		//criei essa variavel para descobrir em String que dia da semana caiu
		int semana = 0;
		GregorianCalendar date = new GregorianCalendar(a, m, 1);

		System.out.println("Ano: " + date.get(Calendar.YEAR));

		//Mudei o nome do metodo Mes para mes, e tirei a varial ano
		System.out.println("Mes: " + mes(m));

		//variavel semana recebe o valor que a varial date, pega o valor da semana
		semana = date.get(Calendar.DAY_OF_WEEK);
		System.out.println("Primeiro dia do mes: " + DiaSemanal(semana));
		System.out.println("Quantidade de dias do mês: "
				+ date.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dados;

	}
}
