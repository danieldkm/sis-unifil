package aula_2904;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteCalendario {

	public static void main(String[] args) {
		Cal cal = new Cal();

		int[] v = new int[3];

		v = cal.cal();
		System.out.println("Dia da semana: " + v[0] + " Qtds de dias do mes " + (v[2] + 1) + " é " + v[1]);
		System.out.println(cal + "\n\n\n\n");
		v = cal.cal(10);
		System.out.println("Dia da semana: " + v[0] + " Qtds de dias do mes " + (v[2] + 1) + " é " + v[1]);
		System.out.println(cal + "\n\n\n\n");
		v = cal.cal(8, 1752);
		System.out.println("Dia da semana: " + v[0] + " Qtds de dias do mes " + (v[2] + 1) + " é " + v[1]);
		System.out.println(cal + "\n\n\n\n");

		// GregorianCalendar g = (GregorianCalendar) Calendar.getInstance();
		GregorianCalendar g = new GregorianCalendar(2013, 1, 1);

		System.out.println(g.getTime());
		System.out.println("Dia " + g.get(Calendar.DAY_OF_MONTH));
		System.out.println("Mês " + (g.get(Calendar.MONTH) + 1));
		System.out.println("Ano " + g.get(Calendar.YEAR));

		System.out.println("qtd dias do Mês "
				+ g.getActualMaximum(Calendar.DAY_OF_MONTH));

		 System.out.println(cal);

	}
}

// --------------------ver.
// prof.----------------------------------------//

/*
 * GregorianCalendar d = new GregorianCalendar(1752, 8, 14); // ano,mes
 * informado e dia 1 GregorianCalendar data = new GregorianCalendar(1752, 8,
 * 1);// mes eh 1 a // menos // set troca informando um date no parâmetro
 * data.setGregorianChange(d.getTime()); // 15/10/1582 default // ano,mes
 * informado e dia 1 data.set(1752, 8, 1);
 * System.out.println(data.getGregorianChange()); //mostra o dia da semana
 * subtraindo 1 pois começa pelo 0 System.out.println("Dias da semana cai " +
 * (data.get(Calendar.DAY_OF_WEEK) - 1)); // percorre calendario e obtem qt dias
 * int qt = 1; int mesAux, mes = data.get(Calendar.MONTH); String omes = " D" +
 * "   " + "S" + "   " + "T" + "   " + "Q" + "   " + "Q" + "   " + "S" + "   " +
 * "S\n"; while (true) { if (data.get(Calendar.DAY_OF_WEEK) == 1) { omes += "\n"
 * + data.get(Calendar.DAY_OF_MONTH) + "  "; }else if
 * (data.get(Calendar.DAY_OF_MONTH) == 1){ int n = 1;
 * while(data.get(Calendar.DAY_OF_WEEK) > n){ omes += "    "; n ++; } omes +=
 * " " + data.get(Calendar.DAY_OF_MONTH) + "   "; }else{ omes +=
 * data.get(Calendar.DAY_OF_MONTH) + "  "; }
 * 
 * data.add(Calendar.DATE, 1);
 * 
 * mesAux = data.get(Calendar.MONTH); if (mes != mesAux) { break; } else { qt++;
 * } } System.out.println("Dias desse mês " + qt);
 * System.out.println("Dias desse mês " + data.get(Calendar.DAY_OF_WEEK));
 * System.out.println(omes);
 */
