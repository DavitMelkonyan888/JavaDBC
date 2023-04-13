package test_con;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
    
    private static final String url = "jdbc:postgresql://localhost:5432/TestDB";
    private static final String user = "postgres";
    private static final String password = "sql123";
    
    public static void main (String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            st.executeQuery("SELECT AVG(REGEXP_REPLACE(costs,'\\D','','g')::INT/100) AS \"Average_Costs\"\n" + "FROM bookings;");
            st.close();
            con.close();
        } catch (SQLException e){
            throw new RuntimeException();
        }
        
    }
    
}
