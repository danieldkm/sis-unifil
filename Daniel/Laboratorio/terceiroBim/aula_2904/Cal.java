package aula_2904;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Cal {
	
	private static int dados[];
	
	
	public static int[] cal(){
		dados = new int[2];
		GregorianCalendar dataux = new GregorianCalendar();
		System.out.println(dataux.get(Calendar.DAY_OF_WEEK));
		JOptionPane.showMessageDialog(null, "Hora " + dataux.get(Calendar.HOUR_OF_DAY)+ ":" + dataux.get(Calendar.MINUTE) + ":" + dataux.get(Calendar.SECOND));
		dataux.set(2013, 4, 1);
		System.out.println(dataux.get(Calendar.DAY_OF_WEEK));
		
		System.out.println("Dia " + dataux.get(Calendar.DAY_OF_MONTH));
		System.out.println("Mes " + dataux.get(Calendar.MONTH));
		System.out.println("Ano " + dataux.get(Calendar.YEAR));
		dados[0] = dataux.get(Calendar.DAY_OF_YEAR);
		
		GregorianCalendar data = new GregorianCalendar(dataux.get(Calendar.YEAR), dataux.get(Calendar.MONTH), 1);
		System.out.println("Dia da semana" + data.get(Calendar.DAY_OF_WEEK));
		dados[0] = data.get(Calendar.DAY_OF_WEEK);
		
		return dados;
	}

	public static void bunda(){
		
	}
	
	public void bunda2(){
		
	}

}
