package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ReservationDAO extends BaseDao implements DataDao {

	@Override
	public String executeQuery(Map<String, Object> params) throws SQLException {
		
		String sql = "{CALL usp_addnewcust(?)}";
	    String jsonResult = "[]"; // Default empty JSON array

	    Connection conn = null;
	    CallableStatement stmt = null;
	    ResultSet rs = null;	    
	    try {
	    		conn = getConnection();
	            stmt = conn.prepareCall(sql);
	    		stmt.setString(1, (String) params.get("param1"));
	    		stmt.setString(2, (String) params.get("param2"));
	    		stmt.setString(3, (String) params.get("param3"));
	    		stmt.setString(4, (String) params.get("param4"));
	    		stmt.setString(5, (String) params.get("param5"));
	    		stmt.setString(6, (String) params.get("param6"));
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
