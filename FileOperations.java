import java.io.*;
import java.util.ArrayList;



/*
1-WriteToCustomer(Customer c)
       2- WriteToGuestHouse(GuestHouse gh)
       3- WriteToBookings(Booking b)
       4- WriteToExecutiveSuites(ExecutiveSuite suite)
       5- WriteToVilla(Villa pn)
        6-ReadFromCustomer()
        7-ReadAllFromCustomer()
        8-ReadFromGuestHouse()
       9- ReadAllFromGuestHouse()
       10- ReadFromBookings()
       11- ReadAllFromBookings()
       12- ReadFromExecutiveSuites()
        13-ReadAllFromExecutiveSuites()
        14-ReadFromVilla()
        15-ReadAllFromVilla()
       16- UpdateBooking(Booking updatedBooking)
        17-deleteBookingIfMoreThan20Days()
        18-isLocationInIslamabad(String location)
        */











public class FileOperations {

    public static void WriteToCustomer(Customer c) {
        try {
            File f = new File("HotelCustomers.txt");
            ObjectOutputStream oos;

            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(c);
            oos.close();

        } catch (IOException e) {
            System.out.println("ERROR IN FILE WRITING!!");
        }
    }
    public static void WriteToEmployee(Employee e) {
        try {
            File f = new File("HotelEmployees.txt");
            ObjectOutputStream oos;

            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(e);
            oos.close();

        } catch (IOException a) {
            System.out.println("ERROR IN FILE WRITING!!");
        }
    }
    public static void ReadFromEmployee() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelEmployees.txt"));
            while (true) {
                Employee e = (Employee) ois.readObject();
                System.out.println(e);
            }
        } catch (ClassNotFoundException e) {

        } catch (EOFException e) {
            return;
        } catch (IOException e) {

        }
    }
    public static void WriteToGuestHouse(GuestHouse gh) {
        try {
            File f = new File("Guesthouse.txt");
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

    public static void WriteToBookings(Booking b) {
        try {
            File f = new File("HotelBookings.txt");
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

    public static void WriteToExecutiveSuites(ExecutiveSuite suite) {
        try {
            File f = new File("HotelSuites.txt");
            ObjectOutputStream oos;

            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(suite);
            oos.close();

        } catch (IOException e) {
            System.out.println("ERROR IN FILE WRITING!!");
        }
    }

    public static void WriteToVilla(Villa pn) {
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

    public static void ReadFromCustomer() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelCustomers.txt"));
            while (true) {
                Customer c = (Customer) ois.readObject();
                System.out.println(c);
            }
        } catch (ClassNotFoundException e) {

        } catch (EOFException e) {
            return;
        } catch (IOException e) {

        }
    }

    public static ArrayList<Customer> ReadAllFromCustomer() {
        ArrayList<Customer> list = new ArrayList<>();

        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("HotelCustomers.txt"));

            while (true) {
                Customer customer = (Customer) os.readObject();
                list.add(customer);
            }
        } catch (ClassNotFoundException e) {

        } catch (EOFException e) {

        } catch (IOException e) {

        }
        return list;
    }

    public static void ReadFromGuestHouse() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("GuestHouse.txt"));
            while (true) {
                GuestHouse gh = (GuestHouse) ois.readObject();
                System.out.println(gh);
            }
        } catch (ClassNotFoundException e) {

        } catch (EOFException e) {
            return;
        } catch (IOException e) {

        }
    }

    public static ArrayList<GuestHouse> ReadAllFromGuestHouse() {
        ArrayList<GuestHouse> list = new ArrayList<>();

        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("GuestHouse.txt"));

            while (true) {
                GuestHouse guestHouse = (GuestHouse) os.readObject();
                list.add(guestHouse);
            }
        } catch (ClassNotFoundException e) {

        } catch (EOFException e) {

        } catch (IOException e) {

        }
        return list;
    }

    public static void ReadFromBookings() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelBookings.txt"));
            while (true) {
                Booking b = (Booking) ois.readObject();
                System.out.println(b);
            }
        } catch (ClassNotFoundException e) {

        } catch (EOFException e) {
            return;
        } catch (IOException e) {

        }
    }

    public static ArrayList<Booking> ReadAllFromBookings() {
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

    public static void ReadFromExecutiveSuites() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelSuites.txt"));
            while (true) {
                ExecutiveSuite suite = (ExecutiveSuite) ois.readObject();
                System.out.println(suite);
            }
        } catch (ClassNotFoundException e) {

        } catch (EOFException e) {
            return;
        } catch (IOException e) {

        }
    }

    public static ArrayList<ExecutiveSuite> ReadAllFromExecutiveSuites() {
        ArrayList<ExecutiveSuite> list = new ArrayList<>();

        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("HotelSuites.txt"));

            while (true) {
                ExecutiveSuite suite = (ExecutiveSuite) os.readObject();
                list.add(suite);
            }
        } catch (ClassNotFoundException e) {

        } catch (EOFException e) {

        } catch (IOException e) {

        }
        return list;
    }

    public static void ReadFromVilla() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelVillas.txt"));
            while (true) {
                Villa pn = (Villa) ois.readObject();
                System.out.println(pn);
            }
        } catch (ClassNotFoundException e) {

        } catch (EOFException e) {
            return;
        } catch (IOException e) {

        }
    }

    public static ArrayList<Villa> ReadAllFromVilla() {
        ArrayList<Villa> list = new ArrayList<>();

        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("HotelVillas.txt"));

            while (true) {
                Villa villa = (Villa) os.readObject();
                list.add(villa);
            }
        } catch (ClassNotFoundException e) {

        } catch (EOFException e) {

        } catch (IOException e) {

        }
        return list;
    }




    public static void UpdateBooking(Booking updatedBooking) {
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
    public static boolean isLocationInIslamabad() {
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("GuestHouse.txt"));

            while (true) {
                GuestHouse guestHouse = (GuestHouse) os.readObject();
                if (guestHouse.getAddress().getCity().equalsIgnoreCase("Islamabad")) {
                    return true;
                }
            }
        } catch (ClassNotFoundException e) {

        } catch (EOFException e) {

        } catch (IOException e) {

        }
        return false;
    }
 /*  public void makeBooking(String bookingID, Date checkInDate, Date checkOutDate, int noOfDays, Customer customer, Apartment apartment) {
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
    } */

    public void viewBooking(String bookingID) {
        try {
            File file = new File("HotelBookings.txt");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            Booking booking;
            while (true) {
                try {
                    booking = (Booking) ois.readObject();
                    if (booking.getBookingID().equals(bookingID)) {
                        System.out.println("Booking ID: " + bookingID);
                        System.out.println("Check-in Date: " + booking.getCheckInDate());
                        System.out.println("Check-out Date: " + booking.getCheckOutDate());
                        System.out.println("No. of Days: " + booking.getNoOfDays());
                        System.out.println("Customer Details: " + booking.getCustomer());
                        System.out.println("Apartment Details: " + booking.getApartment());
                        break;
                    }
                } catch (EOFException e) {
                    System.out.println("Booking not found with ID: " + bookingID);
                    break;
                }
            }

            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error viewing booking: " + e.getMessage());
        }
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
    public static void cancelBookingByID(String bookingID) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelCustomers.txt"));
            while (true) {
                Customer customer = (Customer) ois.readObject();
                Booking booking = customer.getBooking();
                if (booking != null && booking.getBookingID().equals(bookingID)) {
                    customer.setBooking(null);
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("HotelCustomers.txt"));
                    oos.writeObject(customer);
                    oos.close();
                    System.out.println("Booking with ID: " + bookingID + " canceled successfully for Customer ID: " + customer.getCustomerID());
                    ois.close();
                    return;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (EOFException e) {
            System.out.println("Booking with ID: " + bookingID + " not found");
        } catch (IOException e) {
            System.out.println("Error canceling booking with ID: " + bookingID + " - " + e.getMessage());
        }
    }
    public static boolean isRedundantCustomer(Customer customer) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelCustomers.txt"));
            while (true) {
                Customer c = (Customer) ois.readObject();
                if (c.equals(customer)) {
                    ois.close();
                    return true; // Customer already exists
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (EOFException e) {
        } catch (IOException e) {
            System.out.println("Error checking redundant customer: " + e.getMessage());
        }
        return false;
    }





}