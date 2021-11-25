package com.hibernateemployee.methods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
	
	//  reading a date passes by user as String and storing it in "Date"
	public static Date parseDate(String dateInStr) throws ParseException{
		Date theDate=formatter.parse(dateInStr);
		return theDate;
	}
	
	// Displaying Date as a string in ToString()
	public static String formatDate(Date theDate)
	{
		String dateStr=formatter.format(theDate);
		return dateStr;
	}
}
