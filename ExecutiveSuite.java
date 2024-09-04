import java.io.Serializable;

public class ExecutiveSuite extends Apartment implements Serializable {

    int noOfBeds;
    ExecutiveSuite(){
        apName="Executive Suite";
    }


    public ExecutiveSuite(String apName, double cost){
        super(apName,cost);
    }

    public ExecutiveSuite(String aname, double c, String r, boolean a, int n){
        super(aname,c,r,a);
        noOfBeds = n;
    }

    public ExecutiveSuite(Apartment a, int n){
        super(a);
        noOfBeds = n;
    }

    public ExecutiveSuite(Apartment a, ExecutiveSuite s){
        super(a);
        this.noOfBeds = s.noOfBeds;
    }

    public ExecutiveSuite(ExecutiveSuite s) {


    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int n) {
        noOfBeds = n;
    }

    public String toString(){
        return super.toString();
    }

}
