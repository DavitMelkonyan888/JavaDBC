package airport_jdbc.service_classes;

import java.sql.*;

public class SQLActions {
    
    static ResultSet select(String str) throws SQLException {
        String     url        = "jdbc:postgresql://localhost:5432/Airport";
        String     username   = "postgres";
        String     password   = "sql123";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement  statement  = connection.createStatement();
        ResultSet  resultSet  = statement.executeQuery(str);
        statement.close();
        connection.close();
        return resultSet;
    }
    
    static int update(String str) throws SQLException {
        String     url        = "jdbc:postgresql://localhost:5432/Airport";
        String     username   = "postgres";
        String     password   = "sql123";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement  statement  = connection.createStatement();
        int  count  = statement.executeUpdate(str);
        statement.close();
        connection.close();
        return count;
    }
}
