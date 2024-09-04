import java.io.*;
import java.util.ArrayList;

public class Booking implements Serializable {
    private int noOfDays;
    private String bookingID;
    private Date checkInDate;
    private Date checkOutDate;
    private Customer customer;
    private Apartment apartment;
    private double totalBill;

    public Booking() {
        noOfDays = 6;
        bookingID = "null";
        checkInDate = new Date();
        checkOutDate = new Date();
        customer = new Customer();
        apartment = new Apartment();
        totalBill = 0;
    }
    Booking(Date checkInDate, Date checkOutDate, int numOfDays, Apartment apartment,double totalBill){
        this.checkInDate=new Date(checkInDate);
        this.checkOutDate=new Date(checkOutDate);
        this.noOfDays=numOfDays;
        this.apartment=new Apartment(apartment);
        this.totalBill=totalBill;

    }
    Booking(Date checkInDate, Date checkOutDate, int numOfDays, Apartment apartment){
        this.checkInDate=new Date(checkInDate);
        this.checkOutDate=new Date(checkOutDate);
        this.noOfDays=numOfDays;
        this.apartment=new Apartment(apartment);
    }
    public Booking(Date iD, Date oD, int n, String i, Customer c, Apartment a,double totalBill) {
        checkInDate = new Date(iD);
        checkOutDate = new Date(oD);
        noOfDays = n;
        bookingID = i;
        customer = new Customer(c);
        apartment = new Apartment(a);
        this.totalBill=totalBill;
    }
    public Booking(Date iD, Date oD, int n, String i, Customer c, Apartment a) {
        checkInDate = new Date(iD);
        checkOutDate = new Date(oD);
        noOfDays = n;
        bookingID = i;
        customer = new Customer(c);
        apartment = new Apartment(a);
    }

    public Booking(Booking b) {
        this.checkInDate = new Date(b.checkInDate);
        this.checkOutDate = new Date(b.checkOutDate);
        this.noOfDays = b.noOfDays;
        this.bookingID = b.bookingID;
        this.customer = new Customer(b.customer);
        this.apartment = new Apartment(b.apartment);
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public String toString() {
        String result = "NO. OF DAYS: " + noOfDays +
                "\nBOOKING ID: " + bookingID +
                "\n" + customer.toString() +
                "\nCHECK-IN DATE: " + checkInDate.toString() +
                "\nCHECK-OUT DATE: " + checkOutDate.toString();

        if (apartment instanceof Villa) {
            Villa villa = (Villa) apartment;
            result += "\nVILLA: " + villa.toString();
        } else if (apartment instanceof ExecutiveSuite) {
            ExecutiveSuite suite = (ExecutiveSuite) apartment;
            result += "\nEXECUTIVE SUITE: " + suite.toString();
        } else {
            result += "\nAPARTMENT: " + apartment.toString();
        }

        return result;
    }

    public double calculateTotalBill() {
        double total;
        total = apartment.getCost() * noOfDays;
    //    return total;
        if(apartment instanceof Villa){
            Villa villa = (Villa) apartment;
            total*=10;
        }
        if(apartment instanceof ExecutiveSuite){
            ExecutiveSuite suite = (ExecutiveSuite) apartment;
            total*=20;
        }
        return total;
    }

 /*   public void makeBooking(Date checkInDate, Date checkOutDate, int noOfDays, String bookingID, Customer customer, Apartment apartment) {
        try {
            File file = new File("HotelBookings.txt");

            ObjectOutputStream oos;

            if (file.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(file, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            Booking booking = new Booking(checkInDate, checkOutDate, noOfDays, bookingID, customer, apartment);
            oos.writeObject(booking);

            oos.close();

            System.out.println("Booking made successfully.");

        } catch (IOException e) {
            System.out.println("Error making booking: " + e.getMessage());
        }
    }  */
    public static Booking viewBooking(String bookingID) {
        try {
            File file = new File("HotelBookings.ser");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            Booking booking;
            while (true) {
                try {
                    booking = (Booking) ois.readObject();
                    if (booking.getBookingID().equals(bookingID)) {
                       /* System.out.println("Booking ID: " + bookingID);
                        System.out.println("Check-in Date: " + booking.getCheckInDate());
                        System.out.println("Check-out Date: " + booking.getCheckOutDate());
                        System.out.println("No. of Days: " + booking.getNoOfDays());
                        System.out.println("Customer Details: " + booking.getCustomer().toString());
                        System.out.println("Apartment Details: " + booking.getApartment().toString()); */
                        return booking;
                    }
                } catch (EOFException e) {
                    System.out.println("Booking not found with ID: " + bookingID);
                    return null;
                }
                ois.close();
            }
          //  ois.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error viewing booking: " + e.getMessage());
        }
        return null;
    }


    public void cancelBooking(String bookingID) {
        try {
            File inputFile = new File("HotelBookings.txt");
            File tempFile = new File("TempBookings.txt");

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tempFile));

            Booking booking;
            boolean found = false;
            while (true) {
                try {
                    booking = (Booking) ois.readObject();
                    if (booking.getBookingID().equals(bookingID)) {
                        found = true;
                        continue;
                    }
                    oos.writeObject(booking);
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();
            oos.close();

            if (!found) {
                System.out.println("Booking not found with ID: " + bookingID);
                tempFile.delete();
            } else {
                inputFile.delete();
                tempFile.renameTo(inputFile);
                System.out.println("Booking canceled successfully.");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error canceling booking: " + e.getMessage());
        }
    }

    public static void deleteBookingIfMoreThan20Days() {
        try {
            File file = new File("HotelBookings.txt");

            ArrayList<Booking> bookings = new ArrayList<>();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            // Read all bookings from the file
            while (true) {
                try {
                    Booking booking = (Booking) ois.readObject();
                    bookings.add(booking);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }

            ois.close();

            // Remove bookings with more than 20 days
            ArrayList<Booking> bookingsToRemove = new ArrayList<>();
            for (int i = 0; i < bookings.size(); i++) {
                Booking booking = bookings.get(i);
                if (booking.getNoOfDays() > 20) {
                    bookingsToRemove.add(booking);
                }
            }

            bookings.removeAll(bookingsToRemove);

            // Write updated bookings back to the file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            for (int i = 0; i < bookings.size(); i++) {
                Booking booking = bookings.get(i);
                oos.writeObject(booking);
            }
            oos.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error deleting booking: " + e.getMessage());
        }
    }
//    public static Booking ReadFromBookings() {
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelBookings.ser"));
//            while (true) {
//                Booking pn = (Booking) ois.readObject();
//                System.out.println(pn);
//            }
//        } catch (ClassNotFoundException e) {
//
//        } catch (EOFException e) {
//            return;
//        } catch (IOException e) {
//
//        }
//    }
public static ArrayList<Booking> ReadFromBookings() {
    ArrayList<Booking> list = new ArrayList<>();

    try {
        ObjectInputStream os = new ObjectInputStream(new FileInputStream("HotelBookings.txt"));

        while (true) {
            Booking booking = (Booking) os.readObject();
            list.add(booking);
        }
    } catch (ClassNotFoundException e) {

    } catch (EOFException e) {

    } catch (IOException e) {

    }
    return list;
}

    public static void UpdateBooking(Booking updatedBooking) {
        try {
            File file = new File("HotelBookings.ser");

            ArrayList<Booking> bookings = new ArrayList<>();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            // Read all bookings from the file
            while (true) {
                try {
                    Booking booking = (Booking) ois.readObject();
                    bookings.add(booking);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }

            ois.close();

            // Find and update the booking
            for (int i = 0; i < bookings.size(); i++) {
                Booking booking = bookings.get(i);
                if (booking.getBookingID().equals(updatedBooking.getBookingID())) {
                    bookings.set(i, updatedBooking);
                    break;
                }
            }
            // Write updated bookings back to the file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            for (Booking booking : bookings) {
                oos.writeObject(booking);
            }
            oos.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error updating booking: " + e.getMessage());
        }
    }



    public static void WriteToBookings(Booking b) {
        try {
            File f = new File("HotelBookings.ser");
            ObjectOutputStream oos;

            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(b);
            oos.close();

        } catch (IOException e) {
            System.out.println("ERROR IN FILE WRITING!!");
        }
    }

}