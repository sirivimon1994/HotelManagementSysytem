package data;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Room;


public class RoomAvailableData {

	 public static List<Room> parseJson(String json) {
    	 List<Room> roomtypes = new ArrayList<>();
         try {
             JSONArray jsonArray = new JSONArray(json);

             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObject = jsonArray.getJSONObject(i);

                	 Room roomtype = new Room(
                	   jsonObject.optInt("RoomTypeID"),
                       jsonObject.optInt("Adult"),
                       jsonObject.optInt("Children"),
                       jsonObject.optDouble("Price"),
                       jsonObject.optInt("RoomCount"),
                       jsonObject.optString("Amenities"),
                       jsonObject.optString("Image") ,
                       jsonObject.optString("RoomName"),
                       jsonObject.optString("RoomNumber")
                	 );
                	 roomtypes.add(roomtype);

             }
         } catch (JSONException e) {
             System.err.println("Error parsing JSON array: " + e.getMessage());
             // Handle or log the error as needed
         }
         return roomtypes;
  }
	 
}

