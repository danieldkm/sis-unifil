package aula_2904;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class TesteCalendario {

	public static void main(String[] args) {
		
		Cal.cal(10,2010);
		
		
		Cal cal = new Cal();
		System.out.println(cal);
		
		int[] v = new int[3];
		
		v = cal.cal();
		System.out.println(v[0] + " " + v[1] + " " + v[2]);
		System.out.println(cal);
		v = cal.cal(10);
		System.out.println(v[0] + " " + v[1] + " " + v[2]);
		System.out.println(cal);
		v = cal.cal(10,2010);
		System.out.println(v[0] + " " + v[1] + " " + v[2]);
		System.out.println(cal);
		
//		GregorianCalendar g = (GregorianCalendar) Calendar.getInstance();
		GregorianCalendar g = new GregorianCalendar(2013, 1 , 1);
		
		System.out.println(g.getTime());
		System.out.println("Dia " + g.get(Calendar.DAY_OF_MONTH));
		System.out.println("Mês " + (g.get(Calendar.MONTH) + 1));
		System.out.println("Ano " + g.get(Calendar.YEAR));
		
		
		System.out.println("qtd dias do Mês " + g.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		
		
		
		
		
		
	}
}
