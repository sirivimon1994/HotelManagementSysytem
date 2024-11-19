package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CustomerDataByIdDAO extends BaseDao implements DataDao {

	@Override
	public String executeQuery(Map<String, Object> params) throws SQLException {
		
		String sql = "{CALL usp_guestdatabyid(?)}";
	    String jsonResult = "[]"; // Default empty JSON array

	    Connection conn = null;
	    CallableStatement stmt = null;
	    ResultSet rs = null;	    
	    try {
	    		conn = getConnection();
	            stmt = conn.prepareCall(sql);
	    		stmt.setString(1, (String) params.get("param1"));
	    		
	    		rs = stmt.executeQuery();
	    		
	    		if (rs.next()) {
	                jsonResult = rs.getString("result");
	            }
	     } catch (SQLException e) {
	            throw new SQLException("Error executing query: " + e.getMessage(), e);
	     } finally {
	            closeConnection(conn, stmt, rs);
	      }

	  return jsonResult	;
	}

}
