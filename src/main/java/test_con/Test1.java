package test_con;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
    
    public static void main (String[] args) throws IOException {
        String         companyInputFile = "C:\\Users\\Davit\\Desktop\\homework_JDBC\\companies.txt";
        BufferedReader companyReader    = new BufferedReader(new FileReader(companyInputFile));
        String         line;
        for (int i = 0; i < 10; i++) {
            System.out.println(companyReader.readLine());
        }
        companyReader.close();
    }
        
}
    

