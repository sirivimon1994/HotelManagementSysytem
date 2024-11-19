package data;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.RoomType;

public class RoomTypeData {

	  public static List<RoomType> parseJson(String json) {
	    	 List<RoomType> roomtypes = new ArrayList<>();
	         try {
	             JSONArray jsonArray = new JSONArray(json);

	             for (int i = 0; i < jsonArray.length(); i++) {
	                 JSONObject jsonObject = jsonArray.getJSONObject(i);

	                 try {
	                	 RoomType roomtype = new RoomType(
	                	   jsonObject.optString("RoomTypeID"),
	                       jsonObject.optString("RoomTypeName"),
	                       jsonObject.optString("RoomName"),
	                       jsonObject.optDouble("PricePerNight"),
	                       jsonObject.optInt("CapacityAdults"),
	                       jsonObject.optInt("CapacityChildren"),
	                       jsonObject.optString("Amenities"),
	                       jsonObject.optString("Image")
	                	 );
	      
	                	 roomtypes.add(roomtype);
	                 } catch (DateTimeParseException e) {
	                     System.err.println("Error parsing date: " + e.getMessage());
	                     // Handle or log the error as needed
	                 }
	             }
	         } catch (JSONException e) {
	             System.err.println("Error parsing JSON array: " + e.getMessage());
	             // Handle or log the error as needed
	         }
	         return roomtypes;
	  }
	  
}
