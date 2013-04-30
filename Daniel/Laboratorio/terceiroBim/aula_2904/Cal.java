package aula_2904;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cal {

	private static int dados[];

	public static int[] cal() {
		dados = new int[2];
		GregorianCalendar dataux = new GregorianCalendar();
		GregorianCalendar data = new GregorianCalendar(
				dataux.get(Calendar.YEAR), dataux.get(Calendar.MONTH), 1);
		System.out.println("dia da semana " + data.get(Calendar.DAY_OF_WEEK));
		dados[0] = data.get(Calendar.DAY_OF_WEEK);
		// dataux.set(Calendar.DAY_OF_MONTH, 1);
		data.set(GregorianCalendar.DAY_OF_MONTH,
				dataux.get(Calendar.DAY_OF_MONTH));
		dados[1] = data.get(Calendar.DAY_OF_MONTH);
		System.out.println("dias do mês " + data.get(Calendar.DAY_OF_MONTH));
		data.set(GregorianCalendar.MONTH, dataux.get(Calendar.JANUARY));
		System.out.println("mes " + data.get(Calendar.MARCH));
		System.out.println("dias do mês " + data.get(Calendar.DAY_OF_MONTH));
		// System.out.println("dia " + data.get(Calendar.DATE));
		// System.out.println("mes " + data.get(Calendar.MONTH));
		// System.out.println("ano " + data.get(Calendar.YEAR));

		return dados;
	}

	public static int[] cal(int mes) {
		dados = new int[2];
		GregorianCalendar dataux = new GregorianCalendar();
		GregorianCalendar data = new GregorianCalendar(
				dataux.get(Calendar.YEAR), mes, 1);
		System.out.println("dia da semana " + data.get(Calendar.DAY_OF_WEEK));
		dados[0] = data.get(Calendar.DAY_OF_WEEK);
		// dataux.set(Calendar.DAY_OF_MONTH, 1);
		data.set(GregorianCalendar.DAY_OF_MONTH,
				dataux.get(Calendar.DAY_OF_MONTH));
		dados[1] = data.get(Calendar.DAY_OF_MONTH);
		System.out.println("dias do mês " + data.get(Calendar.DAY_OF_MONTH));
		data.set(GregorianCalendar.MONTH, dataux.get(Calendar.JANUARY));
		System.out.println("mes " + data.get(Calendar.MARCH));
		System.out.println("dias do mês " + data.get(Calendar.DAY_OF_MONTH));
		// data.add(1, Calendar.DATE);

		// dados[0] = data.get(Calendar.DAY_OF_WEEK);
		// System.out.println(dataux.get(Calendar.DAY_OF_WEEK));
		//
		// dados[1] = dataux.get(Calendar.DAY_OF_MONTH);
		// System.out.println(dataux.get(Calendar.DAY_OF_MONTH));

		return dados;
	}

	public static int[] cal(int mes, int ano) {
		dados = new int[2];
		GregorianCalendar dataux = new GregorianCalendar();
		GregorianCalendar data = new GregorianCalendar(ano, mes, 1);
		System.out.println("dia da semana " + data.get(Calendar.DAY_OF_WEEK));
		dados[0] = data.get(Calendar.DAY_OF_WEEK);
		// dataux.set(Calendar.DAY_OF_MONTH, 1);
		data.set(GregorianCalendar.DAY_OF_MONTH,
				dataux.get(Calendar.DAY_OF_MONTH));
		dados[1] = data.get(Calendar.DAY_OF_MONTH);
		System.out.println("dias do mês " + data.get(Calendar.DAY_OF_MONTH));
		data.set(GregorianCalendar.MONTH, dataux.get(Calendar.JANUARY));
		System.out.println("mes " + data.get(Calendar.MARCH));
		System.out.println("dias do mês " + data.get(Calendar.DAY_OF_MONTH));
		// data.add(1, Calendar.DATE);
		return dados;
	}

	public String toString() {
		String n = "";
		switch (dados[0]) {
		case 1:
			n = "Domingo";
			break;
		case 2:
			n = "Segunda";
			break;
		case 3:
			n = "Terça";
			break;
		case 4:
			n = "Quarta";
			break;
		case 5:
			n = "Quinta";
			break;
		case 6:
			n = "Sexta";
			break;
		case 7:
			n = "Sabado";
			break;
		}
		return n;
	}

	// public static void cal2() {
	// // get the supported ids for GMT-08:00 (Pacific Standard Time)
	// String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
	// // if no ids were returned, something is wrong. get out.
	// if (ids.length == 0)
	// System.exit(0);
	//
	// // begin output
	// System.out.println("Current Time");
	//
	// // create a Pacific Standard Time time zone
	// SimpleTimeZone pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);
	//
	// // set up rules for Daylight Saving Time
	// pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
	// pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY,
	// 2 * 60 * 60 * 1000);
	//
	// // create a GregorianCalendar with the Pacific Daylight time zone
	// // and the current date and time
	// Calendar calendar = new GregorianCalendar(pdt);
	// Date trialTime = new Date();
	// calendar.setTime(trialTime);
	//
	// // print out a bunch of interesting things
	// System.out.println("ERA: " + calendar.get(Calendar.ERA));
	// System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
	// System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
	// System.out.println("WEEK_OF_YEAR: "
	// + calendar.get(Calendar.WEEK_OF_YEAR));
	// System.out.println("WEEK_OF_MONTH: "
	// + calendar.get(Calendar.WEEK_OF_MONTH));
	// System.out.println("DATE: " + calendar.get(Calendar.DATE));
	// System.out.println("DAY_OF_MONTH: "
	// + calendar.get(Calendar.DAY_OF_MONTH));
	// System.out
	// .println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
	// System.out
	// .println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
	// System.out.println("DAY_OF_WEEK_IN_MONTH: "
	// + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
	// System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
	// System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
	// System.out
	// .println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
	// System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
	// System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
	// System.out
	// .println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
	// System.out.println("ZONE_OFFSET: "
	// + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000)));
	// System.out.println("DST_OFFSET: "
	// + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000)));
	//
	// System.out.println("Current Time, with hour reset to 3");
	// calendar.clear(Calendar.HOUR_OF_DAY); // so doesn't override
	// calendar.set(Calendar.HOUR, 3);
	// System.out.println("ERA: " + calendar.get(Calendar.ERA));
	// System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
	// System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
	// System.out.println("WEEK_OF_YEAR: "
	// + calendar.get(Calendar.WEEK_OF_YEAR));
	// System.out.println("WEEK_OF_MONTH: "
	// + calendar.get(Calendar.WEEK_OF_MONTH));
	// System.out.println("DATE: " + calendar.get(Calendar.DATE));
	// System.out.println("DAY_OF_MONTH: "
	// + calendar.get(Calendar.DAY_OF_MONTH));
	// System.out
	// .println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
	// System.out
	// .println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
	// System.out.println("DAY_OF_WEEK_IN_MONTH: "
	// + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
	// System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
	// System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
	// System.out
	// .println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
	// System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
	// System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
	// System.out
	// .println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
	// System.out.println("ZONE_OFFSET: "
	// + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000))); // in
	// // hours
	// System.out.println("DST_OFFSET: "
	// + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000))); // in
	// // hours
	// }

}
