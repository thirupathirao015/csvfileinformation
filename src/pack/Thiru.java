package pack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Thiru {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="10/11/2017 20:00 CET";
		s1=s1.replaceAll(" CET", "");
		
		System.out.println(s1);
		
		try {
			Date date1=new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(s1);
			System.out.println(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}

}
