package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import model.Customer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CustomerData {
	
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static List<Customer> parseJson(String json) {
    	 List<Customer> customers = new ArrayList<>();
         try {
             JSONArray jsonArray = new JSONArray(json);

             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObject = jsonArray.getJSONObject(i);

                 try {
                     // Extract and convert date fields
                     LocalDateTime createDate = parseDateTime(jsonObject.optString("create_date"));
                     LocalDateTime updateDate = parseDateTime(jsonObject.optString("update_date"));

                     // Create a new Customer object
                     Customer customer = new Customer(
                         jsonObject.optInt("id"),
                         jsonObject.optString("guest_id"),
                         jsonObject.optString("firstname"),
                         jsonObject.optString("lastname"),
                         jsonObject.optString("email"),
                         jsonObject.optString("phone"),
                         jsonObject.optString("country"),
                         jsonObject.optString("birthday"),
                         createDate,
                         updateDate
                     );

                     customers.add(customer);
                 } catch (DateTimeParseException e) {
                     System.err.println("Error parsing date: " + e.getMessage());
                     // Handle or log the error as needed
                 }
             }
         } catch (JSONException e) {
             System.err.println("Error parsing JSON array: " + e.getMessage());
             // Handle or log the error as needed
         }
         return customers;
    }

    // Method to parse date strings into LocalDateTime objects
    private static LocalDateTime parseDateTime(String dateTimeString) {
        try {
            return LocalDateTime.parse(dateTimeString, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
            return null; // Handle accordingly
        }
    }
}