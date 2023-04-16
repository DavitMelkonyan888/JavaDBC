package airport_hibernate.pojo_classes;

import java.sql.Timestamp;

public class PassInTrip {
    
    private int       id;
    private int       tripId;
    private int       passengerId;
    private Timestamp date;
    private String    place;
    
    public PassInTrip () {}
    
    public PassInTrip (int id, int tripId, int passengerId, Timestamp date, String place) {
        this.id = id;
        this.tripId = tripId;
        this.passengerId = passengerId;
        this.date = date;
        this.place = place;
    }
    
    public int getId () {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public int getTripId () {
        return tripId;
    }
    
    public void setTripId (int tripId) {
        this.tripId = tripId;
    }
    
    public int getPassengerId () {
        return passengerId;
    }
    
    public void setPassengerId (int passengerId) {
        this.passengerId = passengerId;
    }
    
    public Timestamp getDate () {
        return date;
    }
    
    public void setDate (Timestamp date) {
        this.date = date;
    }
    
    public String getPlace () {
        return place;
    }
    
    public void setPlace (String place) {
        this.place = place;
    }
}
