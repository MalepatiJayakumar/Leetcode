package in.fplanner.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

	public static java.sql.Date getDate(String strDate) throws ParseException{
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date utilDate = format.parse(strDate);
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
}
