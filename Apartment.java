import java.io.Serializable;
public class Apartment implements Serializable {
    String apName;
    double cost;
    String roomNo;
    boolean availability;

    public Apartment(){
        apName = " null ";
        cost = 17;
        roomNo = " null ";
        availability = true;
    }
    Apartment(double c){
        cost=c;
    }
    public Apartment(String n , double c, String r, boolean a){
        apName = n;
        cost = c;
        roomNo = r;
        availability = a;
    }
    Apartment(String n , double c){
        apName=n;
        cost=c;
    }
    public Apartment(Apartment a){
        this.apName = a.apName;
        this.cost = a.cost;
        this.roomNo = a.roomNo;
        this.availability = a.availability;
    }

    public String getApName(){
        return apName;
    }

    public boolean getAvailability() {
        return availability;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public double getCost() {
        return cost;
    }

    public void setApName(String n){
        apName = n;
    }
    public void setCost(double c) {
        cost = c;
    }

    public void setAvailability(boolean a) {
        availability = a;
    }

    public void setRoomNo(String r) {
        roomNo = r;
    }

    public String toString(){
        return "\n\nAPARTMENT NAME: " + apName + "\nAVAILABILITY: " +availability + "\nCOST:      " + cost + " $";
    }

}
