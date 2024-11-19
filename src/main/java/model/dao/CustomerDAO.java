package model.dao;

import model.RoomType;
import java.sql.*;
import java.util.Map;

import org.json.JSONArray;

public class CustomerDAO {
	
	 public String getAllGuestsAsJson() throws SQLException {
	        String sql = "{CALL get_all_guests_as_json()}";
	        String jsonResult = "[]"; // Default empty JSON array

	        try (Connection conn = DatabaseManager.getConnection();
	             CallableStatement stmt = conn.prepareCall(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            // Extract the JSON result from the ResultSet
	            if (rs.next()) {
	                jsonResult = rs.getString("result");
	            }
	        } catch (SQLException e) {
	            throw new SQLException("Error executing query: " + e.getMessage(), e);
	        }

	        // Return the JSON result
	        return jsonResult;
	}

    public void addRoomType(RoomType roomType) throws SQLException {
        String query = "INSERT INTO room_types (RoomTypeID, RoomTypeName, RoomName, PricePerNight, CapacityAdults, CapacityChildren, Amenities, Image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, roomType.getRoomTypeID());
            pstmt.setString(2, roomType.getRoomTypeName());
            pstmt.setString(3, roomType.getRoomName());
            pstmt.setDouble(4, roomType.getPricePerNight());
            pstmt.setInt(5, roomType.getCapacityAdults());
            pstmt.setInt(6, roomType.getCapacityChildren());
            pstmt.setString(7, roomType.getAmenities());
            pstmt.setString(8, roomType.getImage());
            pstmt.executeUpdate();
        }
    }

    public void deleteRoomType(String roomTypeID) throws SQLException {
        String query = "DELETE FROM room_types WHERE RoomTypeID = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, roomTypeID);
            pstmt.executeUpdate();
        }
    }


}
