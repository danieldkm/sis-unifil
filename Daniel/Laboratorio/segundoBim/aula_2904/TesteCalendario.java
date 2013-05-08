package aula_2904;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteCalendario {

	public static void main(String[] args) {

		/*
		 * int[] v = new int[3];
		 * 
		 * v = cal.cal(); System.out.println(v[0] + " " + v[1] + " " + v[2]);
		 * System.out.println(cal); v = cal.cal(10); System.out.println(v[0] +
		 * " " + v[1] + " " + v[2]); System.out.println(cal); v = cal.cal(10,
		 * 2010); System.out.println(v[0] + " " + v[1] + " " + v[2]);
		 * System.out.println(cal);
		 * 
		 * // GregorianCalendar g = (GregorianCalendar) Calendar.getInstance();
		 * GregorianCalendar g = new GregorianCalendar(2013, 1, 1);
		 * 
		 * System.out.println(g.getTime()); System.out.println("Dia " +
		 * g.get(Calendar.DAY_OF_MONTH)); System.out.println("Mês " +
		 * (g.get(Calendar.MONTH) + 1)); System.out.println("Ano " +
		 * g.get(Calendar.YEAR));
		 * 
		 * System.out.println("qtd dias do Mês " +
		 * g.getActualMaximum(Calendar.DAY_OF_MONTH));
		 */

		// --------------------ver.
		// prof.----------------------------------------//

		GregorianCalendar d = new GregorianCalendar(1752, 8, 14);
		// ano,mes informado e dia 1
		GregorianCalendar data = new GregorianCalendar(1752, 8, 1);// mes eh 1 a
																	// menos
		// set troca informando um date no parâmetro
		data.setGregorianChange(d.getTime()); // 15/10/1582 default
		// ano,mes informado e dia 1
		data.set(1752, 8, 1);

		System.out.println(data.getGregorianChange());
		// percorre calendario e obtem qt dias
		int qt = 1;
		int mesAux, mes = data.get(Calendar.MONTH);
		String omes = " D" + "   " + "S" + "   " + "T" + "   " + "Q" + "   " + "Q" + "   " + "S" + "   " + "S\n";
		while (true) {
//			System.out.println(data.get(Calendar.DAY_OF_WEEK));
//			System.out.println(data.get(Calendar.DAY_OF_MONTH) + "/"
//					+ data.get(Calendar.MONTH));

			
			if (data.get(Calendar.DAY_OF_WEEK) == 1) {
				omes += "\n" + data.get(Calendar.DAY_OF_MONTH) + "  ";
			}else if (data.get(Calendar.DAY_OF_MONTH) == 1){
				int n = 1;
				while(data.get(Calendar.DAY_OF_WEEK) > n){
					omes += "    ";
					n ++;
				}
				omes += " " + data.get(Calendar.DAY_OF_MONTH) + "   ";
			}else{
				omes += data.get(Calendar.DAY_OF_MONTH) + "  ";
			}

			data.add(Calendar.DATE, 1);

			mesAux = data.get(Calendar.MONTH);
			if (mes != mesAux) {
				break;
			} else {
				qt++;
			}
		}
		System.out.println("Dias desse mês " + qt);
		System.out.println(omes);

		
		 Cal.cal(8, 2013);
		
		 Cal cal = new Cal();
		 System.out.println(cal);

	}
}
