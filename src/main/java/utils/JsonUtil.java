package utils;

import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtil {


    // Convert ResultSet to JSON array
    public static String convertResultSetToJson(ResultSet resultSet) throws SQLException {
        JSONArray jsonArray = new JSONArray();

        int columnCount = resultSet.getMetaData().getColumnCount();

        while (resultSet.next()) {
            JSONObject jsonObject = new JSONObject();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = resultSet.getMetaData().getColumnName(i);
                Object columnValue = resultSet.getObject(i);
                jsonObject.put(columnName, columnValue);
            }

            jsonArray.put(jsonObject);
        }

        return jsonArray.toString();
    }
    
}
