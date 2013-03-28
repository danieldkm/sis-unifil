package slide4Ex02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
	private Date hora;
	private Date data;
	
	//para modificar o formato da data e hora
	private SimpleDateFormat modificaData = new SimpleDateFormat("dd/mm/yyyy");
	private SimpleDateFormat modificaHora = new SimpleDateFormat("HH:mm:ss a");
	
	Clock() throws ParseException{
		//modificando o formato da hora e data, na hora da instancia 
		//do objeto ja setando um valor
		hora = modificaHora.parse("00:00:01 PM");
		data = modificaData.parse("10/10/2000");
	}
	
	//convertendo o atributo hora para string e retornando a hora desejada
	String getHora(){
		SimpleDateFormat formata = new SimpleDateFormat("HH:mm:ss a");
		String novoFormato = formata.format(hora);
		return novoFormato;
	}
	
	// atributo hora recebendo o string hora e convertendo para o objeto
	void setHora(String hora) throws ParseException{
		this.hora = modificaHora.parse(hora);
	}
	
	//convertendo o atributo data para string e retornando a data desejada
	String getData(){
		SimpleDateFormat formata = new SimpleDateFormat("dd/mm/yyyy");
		String novoFormato = formata.format(data);
		return novoFormato;
	}

	// atributo data recebendo a string data e convertendo para o objeto
	void setData(String data) throws ParseException{
		this.data = modificaData.parse(data);
	}
	
	//exemplos de alguns formatos
	/*	"yyyy.MM.dd G 'at' HH:mm:ss z" 		2001.07.04 AD at 12:08:56 PDT
		"EEE, MMM d, ''yy" 					Wed, Jul 4, '01
		"h:mm a" 							12:08 PM
		"hh 'o''clock' a, zzzz" 			12 o'clock PM, Pacific Daylight Time
		"K:mm a, z" 						0:08 PM, PDT
		"yyyyy.MMMMM.dd GGG hh:mm aaa" 		02001.July.04 AD 12:08 PM
		"EEE, d MMM yyyy HH:mm:ss Z" 		Wed, 4 Jul 2001 12:08:56 -0700
		"yyMMddHHmmssZ" 					010704120856-0700*/
	
}
