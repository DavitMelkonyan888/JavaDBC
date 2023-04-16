package airport_jdbc.pojo_classes;

public class Passenger {
    
    private int    id;
    private String name;
    private String phone;
    private int    addressId;
    
    public Passenger () {}
    
    public Passenger (int id, String name, String phone, int addressId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.addressId = addressId;
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
    
    public String getPhone () {
        return phone;
    }
    
    public void setPhone (String phone) {
        this.phone = phone;
    }
    
    public int getAddressId () {
        return addressId;
    }
    
    public void setAddressId (int addressId) {
        this.addressId = addressId;
    }
}
