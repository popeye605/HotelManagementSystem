import java.io.*;

public class Villa extends Apartment implements Serializable {
    int noOfRooms;

    public Villa( double c){
        super(c);
        apName="Villa";
    }
    Villa(){
        apName="Villa";
    }

    public Villa(String aname, double c, String r, boolean a, int n){
        super(aname,c,r,a);
        noOfRooms = n;
    }

    public Villa(Apartment a, int n){
        super(a);
        noOfRooms = n;
    }

    public Villa(Apartment a, Villa p){
        super(a);
        this.noOfRooms = p.noOfRooms;
    }

    public Villa(Villa v) {

    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int n){
        noOfRooms = n;
    }

    public String toString(){
        return super.toString() ;
    }
    public static void WriteToVilla(Villa pn) {                  //static lazmi

        try {

            File f = new File("HotelVillas.txt");
            ObjectOutputStream oos;

            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(pn);
            oos.close();

        } catch (IOException e) {
            System.out.println("ERROR IN FILE WRITING!!");
        }
    }
}
