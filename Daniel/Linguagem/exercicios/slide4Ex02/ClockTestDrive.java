package slide4Ex02;

import java.text.ParseException;

public class ClockTestDrive {

	public static void main(String[] args) throws ParseException {
		Clock c = new Clock();
		
		String modificaData = "10/12/1986"; 
		c.setData(modificaData);
		
		String modificaHora = "13:00:50 AM"; 
		c.setHora(modificaHora);
		
		System.out.println(c.getData());
		System.out.println(c.getHora());
		
//	    SimpleDateFormat simpleDateFormat = 
//	    		new SimpleDateFormat("dd/MM/yyyy");  
//	    String date = simpleDateFormat.format("12/10/1986");//Date eh o dado do banco
//	    System.out.println(date);
		
	}

}
