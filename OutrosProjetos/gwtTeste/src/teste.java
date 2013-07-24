import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class teste {
	public static void main(String[] args) throws ParseException {
//		Date data = new Date(System.currentTimeMillis());
//		SimpleDateFormat formatar = new SimpleDateFormat();
//		System.out.println(new Date(0));
		
//		GregorianCalendar calendar = new GregorianCalendar();
//		Date data = new Date();//(Date) calendar.getTime();  
//		System.out.println(data.getTime());
		
//		Date data = new Date(System.currentTimeMillis());    
//		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");   
//		System.out.print(formatarDate.format(data));  
		
		Date data = new Date(System.currentTimeMillis());    
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");  
		String dataAtual = formatarDate.format(data);
		System.out.println(dataAtual);
	}

}
