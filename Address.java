import java.io.Serializable;

public class Address implements Serializable {
    String city;
    String streetName;
    int postalCode;

    public Address(){
        city = " null ";
        streetName = " null ";
        postalCode = 0;
    }

    public Address(String c, String s, int p){
        city = c;
        streetName = s;
        postalCode = p;
    }

    public Address(Address a){
        this.city = a.city;
        this.streetName = a.streetName;
        this.postalCode = a.postalCode;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String c) {
        city = c;
    }

    public void setPostalCode(int p) {
        postalCode = p;
    }

    public void setStreetName(String s) {
        streetName = s;
    }

    public String toString(){
        return "\nCITY: " + city + "\nSTREET NAME :"  +streetName + "\nPOSTAL CODE: " + postalCode;
    }
}
