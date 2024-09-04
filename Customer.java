import java.io.*;

public class Customer extends Person implements Serializable {
    String customerID;
    String phoneNo;
    Booking booking;

    public Customer() {
        super();
        customerID = "null";
        phoneNo = "null";
        booking = null;
    }

    public Customer(String f, String l, String e, String i, String pNo, Booking booking) {
        super(f, l, e);
        customerID = i;
        phoneNo = pNo;
        this.booking = booking;
    }
    public Customer(String f, String l, String e) {
        super(f, l, e);

    }

    public Customer(Person p, String i, String pNo, Booking booking) {
        super(p);
        customerID = i;
        phoneNo = pNo;
        this.booking = booking;
    }

    public Customer(Person p, Customer c) {
        super(p);
        this.customerID = c.customerID;
        this.phoneNo = c.phoneNo;
        this.booking = c.booking;
    }

    public Customer(Customer c) {
        super(c.firstName, c.lastName, c.email);
        this.customerID = c.customerID;
        this.phoneNo = c.phoneNo;
        this.booking = c.booking;
    }

    @Override
    public void setFirstName(String f) {
        super.setFirstName(f);
    }

    @Override
    public void setLastName(String l) {
        super.setLastName(l);
    }

    public void setCustomerID(String c) {
        customerID = c;
    }

    public void setPhoneNo(String p) {
        phoneNo = p;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public Booking getBooking() {
        return booking;
    }

    private boolean ValidateEmail(String e) {
        if (e.contains("@")) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return super.toString(); // + "\nCUSTOMER ID: " + customerID + "\nPHONE#: " + phoneNo;
    }

    public static void WriteToCustomer(Customer c) {
        try {
            File f = new File("HotelCustomers.ser");
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

    public static void viewBookingByID(String customerID) {
        boolean found = false;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelCustomers.txt"))) {
            while (true) {
                try {
                    Customer customer = (Customer) ois.readObject();
                    if (customer.getCustomerID().equals(customerID)) {
                        Booking booking = customer.getBooking();
                        if (booking != null) {
                            System.out.println("Booking Details for Customer ID: " + customerID);
                            System.out.println(booking.toString());
                        } else {
                            System.out.println("No booking found for Customer ID: " + customerID);
                        }
                        found = true;
                    }
                } catch (EOFException e) {
                    // End of file reached, break the loop
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error viewing booking for Customer ID: " + customerID + " - " + e.getMessage());
        }

        if (!found) {
            System.out.println("Customer ID not found: " + customerID);
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
}
