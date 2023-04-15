package airport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 * A Java program that reads data from input files and stores it in a PostgreSQL database.
 */
public class InsertDataToAllTables {
    
    
    /**
     * The main method that inserts all data to all tables.
     *
     * @param args command line arguments (not used)
     */
    public static void main (String[] args) {
        // set up database connection
        String     url        = "jdbc:postgresql://localhost:5432/Airport";
        String     username   = "postgres";
        String     password   = "sql123";
        Connection connection = null;
        String     line;
        try {
            connection = DriverManager.getConnection(url, username, password);
            // read and insert data from Company input file
            String         companyInputFile = "C:\\Users\\Davit\\Desktop\\homework_JDBC\\companies.txt";
            BufferedReader companyReader    = null;
            try {
                companyReader = new BufferedReader(new FileReader(companyInputFile));
                while ((line = companyReader.readLine()) != null) {
                    String[] values       = line.split(",");
                    String   name         = values[0];
                    String   foundingDate = values[1];
                    String[] dt           = foundingDate.split("/");
                    foundingDate = dt[2] + "-" + dt[0] + "-" + dt[1];
                    String            sql       = "INSERT INTO company (name, founding_date) VALUES (?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, name);
                    statement.setDate(2, java.sql.Date.valueOf(foundingDate));
                    statement.executeUpdate();
                    statement.close();
                }
            } catch (IOException e) {
            
            } finally {
                try {
                    companyReader.close();
                } catch (Exception e) {
                
                }
            }
            
            // read and insert data from Address input file
            String         addressInputFile = "C:\\Users\\Davit\\Desktop\\homework_JDBC\\passengers.txt";
            BufferedReader addressReader    = null;
            try {
                addressReader = new BufferedReader(new FileReader(addressInputFile));
                while ((line = addressReader.readLine()) != null) {
                    String[]          values    = line.split(",");
                    String            country   = values[2];
                    String            city      = values[3];
                    String            sql       = "INSERT INTO Address (country, city) VALUES (?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, country);
                    statement.setString(2, city);
                    statement.executeUpdate();
                    statement.close();
                }
            } catch (IOException e) {
            
            } finally {
                try {
                    addressReader.close();
                } catch (Exception e) {
                
                }
            }
            
            // read and insert data from Passenger input file
            String         passengerInputFile = "C:\\Users\\Davit\\Desktop\\homework_JDBC\\passengers.txt";
            BufferedReader passengerReader    = null;
            try {
                passengerReader = new BufferedReader(new FileReader(passengerInputFile));
                
                int counterForAddressId = 1;
                while ((line = passengerReader.readLine()) != null) {
                    String[]          values    = line.split(",");
                    String            name      = values[0];
                    String            phone     = values[1];
                    int               addressId = counterForAddressId++;
                    String            sql       = "INSERT INTO Passenger (name, phone, address_id) VALUES (?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, name);
                    statement.setString(2, phone);
                    statement.setInt(3, addressId);
                    statement.executeUpdate();
                    statement.close();
                }
            } catch (IOException e) {
            
            } finally {
                try {
                    passengerReader.close();
                } catch (Exception e) {
                
                }
            }
            // read and insert data from Trip input file
            String         tripInputFile = "C:\\Users\\Davit\\Downloads\\trip.txt";
            BufferedReader tripReader    = null;
            try {
                tripReader = new BufferedReader(new FileReader(tripInputFile));
                while ((line = tripReader.readLine()) != null) {
                    String[]          values     = line.split(",");
                    String            tripNumber = values[0];
                    String            companyId  = values[1];
                    String            townFrom   = values[3];
                    String            townTo     = values[4];
                    String            timeOut    = values[5];
                    String            timeIn     = values[6];
                    String            sql        = "INSERT INTO Trip (trip_number, company_id, town_from, town_to, time_out, time_in) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement  = connection.prepareStatement(sql);
                    statement.setInt(1, Integer.parseInt(tripNumber.trim()));
                    statement.setInt(2, Integer.parseInt(companyId.trim()));
                    statement.setString(3, townFrom);
                    statement.setString(4, townTo);
                    statement.setTimestamp(5, Timestamp.valueOf(timeOut));
                    statement.setTimestamp(6, Timestamp.valueOf(timeIn));
                    statement.executeUpdate();
                    statement.close();
                }
            } catch (IOException e) {
            
            } finally {
                try {
                    tripReader.close();
                } catch (Exception e) {
                
                }
            }
            
            // read and insert data from Pass_In_Trip input file
            String         passInTripInputFile = "C:\\Users\\Davit\\Downloads\\pass_in_trip.txt";
            BufferedReader passInTripReader    = null;
            try {
                passInTripReader = new BufferedReader(new FileReader(passInTripInputFile));
                while ((line = passInTripReader.readLine()) != null) {
                    String[]          values      = line.split(",");
                    String            tripId      = values[0];
                    String            passengerId = values[1];
                    String            date        = values[2];
                    String            place       = values[3];
                    String            sql         = "INSERT INTO Pass_in_trip (trip_id, passenger_id, date, place) VALUES (?, ?, ?, ?)";
                    PreparedStatement statement   = connection.prepareStatement(sql);
                    statement.setInt(1, Integer.parseInt(tripId));
                    statement.setInt(2, Integer.parseInt(passengerId));
                    statement.setTimestamp(3, Timestamp.valueOf(date));
                    statement.setString(4, place);
                    statement.executeUpdate();
                    statement.close();
                }
            } catch (IOException e) {
            
            } finally {
                try {
                    passInTripReader.close();
                } catch (Exception e) {
                
                }
            }
            
        } catch (SQLException e) {
        
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }
}
