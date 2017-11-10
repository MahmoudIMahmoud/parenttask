package parent.eu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) throws ParseException {
		long myTime = System.currentTimeMillis()+3*86400000;

		String myDate = getFormatedDate(myTime);
		System.err.println(myDate);
//		Date date= dateFormatter.parse(myDate);
//		
//		Calendar cal = getWeekFromDate(date);
//		System.err.println(cal.getWeeksInWeekYear());
//		
		
		
	}
	public static String getFormatedDate(long myTime) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MMM/yyyy");
		String myDate = dateFormatter.format(myTime);
		return myDate;
	}
	public static int getWeekFromDate(String date,String formate) {
		try{
		SimpleDateFormat dateFormatter = new SimpleDateFormat(formate);
		return getWeekFromDate(dateFormatter.parse(date)).getWeeksInWeekYear();
		}catch(Exception ex){
			System.err.println(ex.getMessage());
		}
		return -1;
	}
	

	public static Calendar getWeekFromDate(Date date) {
		Calendar cal = Calendar.getInstance();
		System.err.println(cal);
		cal.setTime(date);
		return cal;
	}
}
