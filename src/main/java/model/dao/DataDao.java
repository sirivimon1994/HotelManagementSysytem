package model.dao;

import java.sql.SQLException;
import java.util.Map;

public interface DataDao {
	String executeQuery(Map<String,Object> params) throws SQLException;
}
