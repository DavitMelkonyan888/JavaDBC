package airport_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAllTables {
    
    private static final String url      = "jdbc:postgresql://localhost:5432/Airport";
    private static final String user     = "postgres";
    private static final String password = "sql123";
    
    public static void main (String[] args) {
        Connection con = null;
        Statement  st  = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            st.execute("" +
                    "CREATE TABLE Company (\n" + "  " +
                    "id SERIAL PRIMARY KEY,\n" + "  " +
                    "name VARCHAR(255) NOT NULL,\n" + "  " +
                    "founding_date DATE NOT NULL\n" + ");\n" +

                    "CREATE TABLE Address (\n" + "  " +
                    "id SERIAL PRIMARY KEY,\n" + "  " +
                    "country VARCHAR(255) NOT NULL,\n" + "  " +
                    "city VARCHAR(255) NOT NULL\n" + ");\n" +

                    "CREATE TABLE Passenger (\n" + "  " +
                    "id SERIAL PRIMARY KEY,\n" + "  " +
                    "name VARCHAR(255) NOT NULL,\n" + "  " +
                    "phone VARCHAR(20) NOT NULL,\n" + "  " +
                    "address_id INTEGER NOT NULL,\n" + "  " +
                    "FOREIGN KEY (address_id) REFERENCES Address(id)\n" + ");\n" +

                    "CREATE TABLE Trip (\n" + "  " +
                    "trip_number INTEGER PRIMARY KEY NOT NULL,\n" + "  " +
                    "company_id INTEGER NOT NULL,\n" + "  " +
                    "town_from VARCHAR(255) NOT NULL,\n" + "  " +
                    "town_to VARCHAR(255) NOT NULL,\n" + "  " +
                    "time_out TIMESTAMP NOT NULL,\n" + "  " +
                    "time_in TIMESTAMP NOT NULL,\n" + "  " +
                    "FOREIGN KEY (company_id) REFERENCES Company(id)\n" + ");\n" +

                    "CREATE TABLE Pass_in_trip (\n" + "  " +
                    "id SERIAL PRIMARY KEY,\n" + "  " +
                    "trip_id INTEGER NOT NULL,\n" + "  " +
                    "passenger_id INTEGER NOT NULL,\n" + "  " +
                    "date TIMESTAMP NOT NULL,\n" + "  " +
                    "place VARCHAR(255) NOT NULL,\n" + "  " +
                    "FOREIGN KEY (trip_id) REFERENCES Trip(trip_number),\n" + "  " +
                    "FOREIGN KEY (passenger_id) REFERENCES Passenger(id)\n" + ");");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
