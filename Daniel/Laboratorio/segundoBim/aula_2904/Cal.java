package aula_2904;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cal {

	private static int dados[];

	public static int[] cal() {
		dados = new int[3];
		GregorianCalendar dataux = new GregorianCalendar();
		GregorianCalendar data = new GregorianCalendar(
				dataux.get(Calendar.YEAR), dataux.get(Calendar.MONTH), 1);
//		System.out.println("dia da semana " + (data.get(Calendar.DAY_OF_WEEK) - 1));
		dados[0] = data.get(Calendar.DAY_OF_WEEK) - 1;
		dados[1] = data.getActualMaximum(Calendar.DAY_OF_MONTH);
		dados[2] = data.get(Calendar.MONTH);
		// data.set(GregorianCalendar.DAY_OF_MONTH,dataux.get(Calendar.DAY_OF_MONTH));
//		System.out.println("dias do m�s "
//				+ data.getActualMaximum(Calendar.DAY_OF_MONTH));
//		System.out.println("m�s " + (data.get(Calendar.MONTH) + 1));
		// data.set(GregorianCalendar.MONTH, dataux.get(Calendar.JANUARY));
		// System.out.println("mes " + data.get(Calendar.MARCH));
		// System.out.println("dias do m�s " + data.get(Calendar.DAY_OF_MONTH));
		// System.out.println("dia " + data.get(Calendar.DATE));
		// System.out.println("mes " + data.get(Calendar.MONTH));
		// System.out.println("ano " + data.get(Calendar.YEAR));
		System.out.println("Ano bissexto? "
				+ data.isLeapYear(dataux.get(Calendar.YEAR)));
		return dados;
	}
	private static String mes(int mes) {
		return "s";
	}
	
	public static int[] cal(int mes) {
		dados = new int[3];
		mes = mes - 1;
		GregorianCalendar dataux = new GregorianCalendar();
		GregorianCalendar data = new GregorianCalendar(
				dataux.get(Calendar.YEAR), mes, 1);
//		System.out.println("dia da semana " + (data.get(Calendar.DAY_OF_WEEK) - 1));
		dados[0] = data.get(Calendar.DAY_OF_WEEK) - 1;
		dados[1] = data.getActualMaximum(Calendar.DAY_OF_MONTH);
		dados[2] = data.get(Calendar.MONTH);
//		System.out.println("dias do m�s "
//				+ data.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("Ano bissexto? "
				+ data.isLeapYear(dataux.get(Calendar.YEAR)));

		return dados;
	}

	public static int[] cal(int mes, int ano) {
		if(mes == 8 && ano == 1752){
			dados = new int[3];
			GregorianCalendar d = new GregorianCalendar(ano, mes, 14);
			// ano,mes informado e dia 1
			GregorianCalendar data = new GregorianCalendar(ano, mes, 1);// mes eh 1 a
			// set troca informando um date no par�metro
			data.setGregorianChange(d.getTime()); // 15/10/1582 default
			// ano,mes informado e dia 1
			data.set(ano, mes, 1);
			System.out.println(data.getGregorianChange());
			//mostra o dia da semana subtraindo 1 pois come�a pelo 0
			System.out.println("Dias da semana " + (data.get(Calendar.DAY_OF_WEEK) - 1));
			dados[0] = data.get(Calendar.DAY_OF_WEEK) - 1;
			dados[2] = mes;
			// percorre calendario e obtem qt dias
			int qt = 1;
			int mesAux, meses = data.get(Calendar.MONTH);
			String omes = " D" + "   " + "S" + "   " + "T" + "   " + "Q" + "   " + "Q" + "   " + "S" + "   " + "S\n";
			while (true) {
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
				if (meses != mesAux) {
					break;
				} else {
					qt++;
				}
			}
			dados[1] = qt;
			System.out.println("Dias desse m�s " + qt);
			System.out.println(omes);
			return dados;
		}else{
		dados = new int[3];
		mes = mes - 1;
		GregorianCalendar d = new GregorianCalendar(ano, mes, 14);
		GregorianCalendar data = new GregorianCalendar(ano, mes, 1);
		data.setGregorianChange(d.getTime());
		data.set(ano,mes,1);
			dados[0] = data.get(Calendar.DAY_OF_WEEK) - 1;
			dados[1] = data.getActualMaximum(Calendar.DAY_OF_MONTH);
			dados[2] = data.get(Calendar.MONTH);
			System.out.println("Ano bissexto? " + data.isLeapYear(ano));
			return dados;
		}
	}

	public String toString() {
		String semana = "", mes = "";
		switch (dados[0]) {
		case 0:
			semana = "Domingo";
			break;
		case 1:
			semana = "Segunda";
			break;
		case 2:
			semana = "Ter�a";
			break;
		case 3:
			semana = "Quarta";
			break;
		case 4:
			semana = "Quinta";
			break;
		case 5:
			semana = "Sexta";
			break;
		case 6:
			semana = "Sabado";
			break;
		}
		switch (dados[2]) {
		case 0:
			mes = "Janeiro";
			break;
		case 1:
			mes = "Fevereiro";
			break;
		case 2:
			mes = "Mar�o";
			break;
		case 3:
			mes = "Abril";
			break;
		case 4:
			mes = "Maio";
			break;
		case 5:
			mes = "Junho";
			break;
		case 6:
			mes = "Julho";
			break;
		case 7:
			mes = "Agosto";
			break;
		case 8:
			mes = "Setembro";
			break;
		case 9:
			mes = "Outubro";
			break;
		case 10:
			mes = "Novembro";
			break;
		case 11:
			mes = "Dezembro";
			break;
		}
		return "Primeiro dia da semana do m�s cai na " + semana
				+ "!!!!!, o m�s de " + mes + " tem " + dados[1] + " dias";
	}

	/*
	 * java.util.GregorianCalendar A classe Date � bem simples e serve para
	 * armazenar datas apenas. Ainda temos que manipular as datas n�o �? Tipo
	 * acrescentar 10 dias, verificar qual o dia da semana, e coisas assim. Para
	 * isso vamos usar a classe GregorianCalendar.
	 * 
	 * GregorianCalendar gc=new GregorianCalendar(); Como a classe Date, quando
	 * um objeto � criado a data/hora do sistema � assumido automaticamente.
	 * Algumas fun��es da classe s�o muito �teis. Vamos dar uma olhada:
	 * 
	 * GET. Obter o valor de um dos componentes da Data, como dia da semana, dia
	 * do m�s, hora, m�s ou qualquer outra coisa:
	 * 
	 * GregorianCalendar gc=new GregorianCalendar();
	 * System.out.println(gc.get(gc.DAY_OF_WEEK)); //Mostra qual o dia da semana
	 * 1=domingo, 2=segunda, etc Al�m do dia da semana, � poss�vel mostrar a
	 * hora (gc.HOUR), minuto (gc.MINUTES), etc. Veja na documenta��o abaixo os
	 * outros valores de campo dispon�veis.
	 * 
	 * ADD. Adicionar um ou mais dias, horas, m�s ou qualquer outra coisa a uma
	 * data:
	 * 
	 * GregorianCalendar gc=new GregorianCalendar(); gc.add(gc.MONTH, 2);
	 * //Adiciona 2 meses � data atual Al�m de gc.MONTH, � poss�vel adicionar
	 * horas (gc.HOUR), minutos (gc.MINUTES), etc. � l�gico que adicionando
	 * valores negativos, voc� subtrai os valores!
	 * 
	 * IS LEAP YEAR. Verifica se um ano � bissexto.
	 * 
	 * GregorianCalendar gc=new GregorianCalendar();
	 * System.out.println(gc.isLeapYear(2009)); // imprime falso. 2009 n�o �
	 * bissexto. Acho que j� deu para entender como funciona. Outras fun��es
	 * dispon�veis:
	 * 
	 * SET � mudar o valor de uma data. gc.set(10,03,2009); ou
	 * gc.set(10,03,2009,10,30); ou gc.set(gc.HOUR,11); AFTER/BEFORE � verificar
	 * se um data � depois ou antes de outrar. gc.after(gc2) gc � depois de gc2?
	 * GETMAXIMUN � obter o maior valor dispon�vel para um campo considerando os
	 * valores atuais dos outros. gc.getMaximum(gc.DATE); retornaria 28 se o m�s
	 * fosse fevereiro de um ano n�o bissexto. Por fim, para juntar os dois,
	 * GregorianCalendar e Date, utilizamos duas fun��es:
	 * 
	 * GregorianCalendar gc=new GregorianCalendar(); Date d1=gc.getTime();
	 * //"Pega" a data do GregorianCalendar para uma vari�vel Date
	 * gc.setTime(d1); //Armazena a data de d1 para o GregorianCalendar gc.
	 */

}
