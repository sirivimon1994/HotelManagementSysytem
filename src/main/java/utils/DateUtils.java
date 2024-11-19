package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateUtils {
	   private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	  private static final String DATE_FORMAT = "yyyy-MM-dd"; 
	  private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss"; 
	  

	 public static Date parseDate(String dateStr) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	        dateFormat.setLenient(false); // Ensure strict parsing
	        try {
	            return dateFormat.parse(dateStr);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return null; // or throw a custom exception if preferred
	        }
	        
	  }
	 
	 public static String getDateTimeNow() {
		 LocalDateTime now = LocalDateTime.now();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		 return now.format(formatter);
	 }
	
	
	 public static LocalDate toLocalDate(Date date) {
	        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	 }

	 public static Date toDate(LocalDate localDate) {
	      return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	 }
	 

	public static LocalDate parseLocalDate(String dateStr) {
		  try {
	            return LocalDate.parse(dateStr, DATE_FORMATTER);
	        } catch (DateTimeParseException e) {
	            throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd.", e);
	        }
	}    
}
