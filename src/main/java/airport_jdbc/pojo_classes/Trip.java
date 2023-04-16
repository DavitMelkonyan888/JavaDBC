package airport_jdbc.pojo_classes;

import java.sql.Timestamp;

public class Trip {
    
    private int       tripNumber;
    private int       companyId;
    private String    townFrom;
    private String    townTo;
    private Timestamp timeOut;
    private Timestamp timeIn;
    
    public Trip () {}
    
    public Trip (int tripNumber, int companyId, String townFrom, String townTo, Timestamp timeOut, Timestamp timeIn) {
        this.tripNumber = tripNumber;
        this.companyId = companyId;
        this.townFrom = townFrom;
        this.townTo = townTo;
        this.timeOut = timeOut;
        this.timeIn = timeIn;
    }
    
    public int getTripNumber () {
        return tripNumber;
    }
    
    public void setTripNumber (int tripNumber) {
        this.tripNumber = tripNumber;
    }
    
    public int getCompanyId () {
        return companyId;
    }
    
    public void setCompanyId (int companyId) {
        this.companyId = companyId;
    }
    
    public String getTownFrom () {
        return townFrom;
    }
    
    public void setTownFrom (String townFrom) {
        this.townFrom = townFrom;
    }
    
    public String getTownTo () {
        return townTo;
    }
    
    public void setTownTo (String townTo) {
        this.townTo = townTo;
    }
    
    public Timestamp getTimeOut () {
        return timeOut;
    }
    
    public void setTimeOut (Timestamp timeOut) {
        this.timeOut = timeOut;
    }
    
    public Timestamp getTimeIn () {
        return timeIn;
    }
    
    public void setTimeIn (Timestamp timeIn) {
        this.timeIn = timeIn;
    }
}
