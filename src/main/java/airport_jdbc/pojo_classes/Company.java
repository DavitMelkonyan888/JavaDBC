package airport_jdbc.pojo_classes;

import java.sql.Date;

public class Company {
    
    private int    id;
    private String name;
    private Date   foundingDate;
    
    public Company () {}
    
    public Company (int id, String name, Date foundingDate) {
        this.id = id;
        this.name = name;
        this.foundingDate = foundingDate;
    }
    
    public int getId () {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public Date getFoundingDate () {
        return foundingDate;
    }
    
    public void setFoundingDate (Date foundingDate) {
        this.foundingDate = foundingDate;
    }
}
