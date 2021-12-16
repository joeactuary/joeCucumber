package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    static Connection connection;

    public static Connection getConnection() {
        String dbUrl = ConfigReader.getPropertyValue("dbUrl");
        String dbUserName = ConfigReader.getPropertyValue("dbUserName");
        String dbPassword = ConfigReader.getPropertyValue("dbPassword");

        try {
            connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static List<Map<String, String>> dbIntoListMap(String sqlStatement) {

        Statement statement;
        ResultSet resultSet = null;
        List<Map<String, String>> listofMapsFromDB = new ArrayList<>();

        // sampleSQL Statement = "select * from ohrm_skill"

        try {
            resultSet = getConnection().createStatement().executeQuery(sqlStatement);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();


            while (resultSet.next()) {
                Map<String, String> rowMap = new LinkedHashMap<>();
                int cols = resultSetMetaData.getColumnCount();
                for (int i = 1; i <= cols; i++) {
                    rowMap.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
                }
                listofMapsFromDB.add(rowMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
        }
        return listofMapsFromDB;
    }

    private static void closeResultSet(ResultSet resultSet) {
        try {
            assert resultSet != null;
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
