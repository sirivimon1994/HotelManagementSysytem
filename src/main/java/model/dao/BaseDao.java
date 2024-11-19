package model.dao;

import java.sql.*;


public abstract class BaseDao {
	
	protected Connection getConnection() throws SQLException{
		return DatabaseManager.getConnection();
	}
	
	protected void closeConnection(Connection connection , CallableStatement stmt , ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		DatabaseManager.closeConnection(connection);
	}
	

}
