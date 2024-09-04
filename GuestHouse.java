import java.io.*;
import java.util.ArrayList;

class GuestHouse implements Serializable {
    String GuestHouseName;
    ArrayList<Apartment> apartments = new ArrayList<>();
    ArrayList<ExecutiveSuite> suite = new ArrayList<>();
    ArrayList<Villa> villa = new ArrayList<>();
    Address address;
    Manager manager;

    public GuestHouse() {
        GuestHouseName = " null ";

        for (int i = 0; i < 5; i++) {
            villa.add(null);
        }
        for (int i = 0; i < 5; i++) {
            apartments.add(null);
        }
        for (int i = 0; i < 5; i++) {
            suite.add(null);
        }
        address = new Address();
        manager = new Manager();
    }

    public GuestHouse(String hn, ArrayList<Apartment> a, ArrayList<ExecutiveSuite> s, ArrayList<Villa> v, Address ad, Manager m) {
        GuestHouseName = hn;
        address = new Address(ad);
        manager = new Manager(m);

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != null) {
                apartments.add(a.get(i));
            }
        }
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) != null) {
                suite.add(s.get(i));
            }
        }
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) != null) {
                villa.add(v.get(i));
            }
        }

    }

    public GuestHouse(String hn, Address ad) {
        GuestHouseName = hn;
        address = new Address(ad);

        for (int i = 0; i < 5; i++) {
            apartments.add(null);
        }
        for (int i = 0; i < 5; i++) {
            apartments.add(null);
        }
        for (int i = 0; i < 5; i++) {
            apartments.add(null);
        }
    }

    public GuestHouse(GuestHouse h) {    //copy
        this.GuestHouseName = h.GuestHouseName;
        this.address = h.address;
        this.manager = h.manager;
        for (int i = 0; i < h.apartments.size(); i++) {
            this.apartments.add(h.apartments.get(i));
        }
        for (int i = 0; i < h.apartments.size(); i++) {
            this.suite.add(h.suite.get(i));
        }
        for (int i = 0; i < h.villa.size(); i++) {
            this.villa.add(h.villa.get(i));
        }

    }

    public void setSuite(ArrayList<ExecutiveSuite> suite) {
        this.suite = suite;
    }

    public void setVilla(ArrayList<Villa> villa) {
        this.villa = villa;
    }

    public void setGuestHouseName(String hn) {
        GuestHouseName = hn;
    }

    public void setAddress(Address a) {
        address = new Address(a);
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    public ArrayList<ExecutiveSuite> getSuite() {
        return suite;
    }

    public ArrayList<Villa> getVilla() {
        return villa;
    }

    public Apartment getApartment(Apartment a) {

        for (int i = 0; i < apartments.size(); i++) {
            if (apartments.get(i).getRoomNo() != null && apartments.get(i).getRoomNo().equalsIgnoreCase(a.roomNo)) {
                return apartments.get(i);
            }
        }
        return null;
    }

    public ExecutiveSuite getSuite(ExecutiveSuite s) {
        for (int i = 0; i < suite.size(); i++) {
            return suite.get(i);
        }
    return null;
}

    public String getHotelName() {
        return GuestHouseName;
    }

    public Address getAddress(){
        return address;
    }

    public void addApartment(Apartment ap1) {apartments.add(new Apartment(ap1));
    }

    public String toString() {

        for (int i = 0; i < apartments.size(); i++) {
            if (apartments.get(i) != null) {

                return "\n Hotel name: " + GuestHouseName + "\nAddress: " + address.toString() + "\n Apartments: " + apartments.toString();
            }
        }
        for (int i = 0; i < suite.size(); i++) {
            if (suite.get(i) != null) {
                return suite.toString();
            }
        }
        for (int i = 0; i < villa.size(); i++) {
            if(villa.get(i)!=null){
                return villa.toString();
            }
        }
        return null;
    }
    public static void WriteToGuestRoom(GuestHouse gh) {                  //static lazmi

        try {

            File f = new File("GuestHouse.txt");
            ObjectOutputStream oos;

            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(gh);
            oos.close();

        } catch (IOException e) {
            System.out.println("ERROR IN FILE WRITING!!");
        }
    }

}
