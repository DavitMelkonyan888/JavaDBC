package airport_jdbc.service_classes;

import airport_jdbc.pojo_classes.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CompanyService {
    static Company getById(long id){
        String sql          = "SELECT * FROM Company WHERE id = " + id + ";";
        ResultSet resultSet;
        try {
            resultSet = SQLActions.select(sql);
            resultSet.next();
            return new Company(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3));
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    static Set <Company> getAll(){
        String sql = "SELECT * FROM Company;";
        try {
            ResultSet resultSet = SQLActions.select(sql);
            Set<Company> set = new HashSet<>();
            while(resultSet.next()) {
               set.add(new Company(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3)));
            }
            return set;
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    static Set <Company> get(int offset, int perPage, String sort){
        String sql = "SELECT * FROM Company ORDER BY " + sort + " LIMIT " + perPage + " OFFSET " + offset + ";";
        try {
            ResultSet resultSet = SQLActions.select(sql);
            Set<Company> set = new HashSet<>();
            while(resultSet.next()) {
                set.add(new Company(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3)));
            }
            return set;
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    static boolean save(Company company){
        String sql  = "INSERT INTO company (name, founding_date) VALUES ('" + company.getName() + "', '" + company.getFoundingDate() + "');";
        int count = 0;
        try{
            count = SQLActions.update(sql);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        if (count == 1) return true;
        return false;
    }
    
    static boolean delete(int id){
        String sql = "SELECT * FROM Trip WHERE company_id = " + id + ";";
        boolean t = true;
        try {
            ResultSet resultSet = SQLActions.select(sql);
            if (resultSet.next()) t = false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (!t) {
            System.out.println("This Row Is Connected With Other Row(s) In Table Trip, Please Delete That First!!!!!");
            return false;
        }
        sql  = "DELETE FROM company WHERE id = " + id + ";";
        int count = 0;
        try{
            count = SQLActions.update(sql);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        if (count == 1) return true;
        return false;
    }
    
    static boolean update(Company company){
        String sql = "UPDATE company SET name = '" + company.getName() + "', founding_date = '" + company.getFoundingDate() + "' WHERE id = " + company.getId() + ";";
        try {
            int count = SQLActions.update(sql);
            if (count == 1) return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
