package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import data.CustomerData;
import data.RoomAvailableData;
import data.RoomTypeData;
import model.Customer;
import model.Reservation;
import model.Room;
import model.RoomType;

public class ConnectionService {

	  private CustomerDataByIdDAO customerDataByIdDAO = new CustomerDataByIdDAO();
	  private CustomerNewDAO customerNewDAO = new CustomerNewDAO();
	  private RoomAvailableDAO roomAvailableDAO = new RoomAvailableDAO();
	  private RoomTypeDAO roomTypeDAO = new RoomTypeDAO();
	  private ReservationDAO reservationDAO = new ReservationDAO();
	  
	  
	  private CustomerData cusData;
	  private RoomAvailableData rAvailableData;
	  private RoomTypeData roomData;
	  
	  
	  
	  
	  public Customer callGuestDataByID(String guestId) {
	        Map<String, Object> params = new HashMap<>();
	        params.put("param1", guestId);
	        List<Customer> guests = new ArrayList<Customer>() ;
	        try {
	            String jsonResult = customerDataByIdDAO.executeQuery(params);	          
	            guests = cusData.parseJson(jsonResult);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return guests.get(0);
	 }
	  
	  public List<Room> callRoomsAvailability(String checkIn  , String checkOut , int adults , int children , String code ) {
	        Map<String, Object> params = new HashMap<>();
	        params.put("param1", checkIn);
	        params.put("param2", checkOut);
	        params.put("param3", adults);
	        params.put("param4", children);
	        params.put("param5", code);
	        List<Room> rooms = new ArrayList<Room>() ;
	        try {
	            String jsonResult = roomAvailableDAO.executeQuery(params);
	            rooms = rAvailableData.parseJson(jsonResult);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rooms;
	 } 
	 
	  
	  public  List<RoomType> callAllRoomTypesAsJson() {
	        Map<String, Object> params = new HashMap<>();

	        List<RoomType> roomTypes = new ArrayList<RoomType>() ;
	        try {
	            String jsonResult = roomTypeDAO.executeQuery(params);
	            roomTypes = roomData.parseJson(jsonResult);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return roomTypes;
	 } 
	  

		 
	  public String callAddNewGuest(String name, String lastname, String email, 	String phone, String country ,  String birthdate) {
	        Map<String, Object> params = new HashMap<>();
	        params.put("param1", name);
	        params.put("param2", lastname);
	        params.put("param3", email);
	        params.put("param4", phone);
	        params.put("param5", country);
	        params.put("param6", birthdate);
	        String result = null;
	        try {
	        
	            String jsonResult = customerNewDAO.executeQuery(params);
	            JSONObject jsonObject = new JSONObject(jsonResult);
	            result =  jsonObject.getString("guest_id");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return result;
	 }
	  
	  
	  public Boolean callAddReservation( int guestId ,  int roomTypeID , String roomNumber ,  String createDate ) {
	        Map<String, Object> params = new HashMap<>();
	        params.put("param1", guestId);
	        params.put("param2", roomTypeID);
	        params.put("param3", roomNumber);
	        params.put("param4", createDate);
	        String result = null;
	        try {
	            String jsonResult = reservationDAO.executeQuery(params);	          
	            JSONObject jsonObject = new JSONObject(jsonResult);
	            result =  jsonObject.getString("result");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return Boolean.parseBoolean(result);
	 }


	  
	  
}
