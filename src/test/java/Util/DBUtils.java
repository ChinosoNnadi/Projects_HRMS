package Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    public static List<Map<String, String>> fetch(String query){

        List<Map<String, String>> tableData = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER_NAME, Constants.PASSWORD)) {
            Statement statement = connection.createStatement();
            //String query = "Select * from employee";
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            while (resultSet.next()){
                Map<String, String> rowMap = new HashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount() ; i++) {
                    String key = resultSetMetaData.getColumnName(i);
                    String value = resultSet.getString(i);
                    rowMap.put(key,value);
                }
                tableData.add(rowMap);
            }

        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return tableData;
    }
}
