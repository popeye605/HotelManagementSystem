import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ManagerFrame extends JFrame implements Serializable{
    JButton j1;
    JButton j2;
    JButton j3;
    JButton j4;
    JButton j5;
    JButton j6;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5;
    ManagerFrame(){
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(5,2));
        j1 = new JButton("Add an Employee");
        j2 = new JButton("View Booking");
        j3 = new JButton("Cancel Booking");
        j4 = new JButton("Modify a Booking");
        j5 = new JButton("Calculate Customer's Bill");
        j6 = new JButton("Back to Main Menu");

        add(j1);
        add(j2);
        add(j3);
        add(j4);
        add(j5);
        add(j6);
        MyActionListener listener = new MyActionListener();
        j1.addActionListener(listener);
        j2.addActionListener(listener);
        j3.addActionListener(listener);
        j4.addActionListener(listener);
        j5.addActionListener(listener);
        j6.addActionListener(listener);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Add an Employee")) {
                AddEmployeeFrame e = new AddEmployeeFrame();
            } else if (ae.getActionCommand().equals("View Booking")) {
                String customerID = JOptionPane.showInputDialog(null, "Enter Customer ID:");
                viewBookingByID(customerID);
            } else if (ae.getActionCommand().equals("Cancel Booking")) {
                String bookingID = JOptionPane.showInputDialog(null, "Enter Booking ID:");
                cancelBookingByID(bookingID);
            } else if (ae.getActionCommand().equals("Modify a Booking")) {
                // String bookingID = JOptionPane.showInputDialog(null, "Enter Booking ID:");
                //updateBookingByID(bookingID);
                // else if(ae.getActionCommand().equals(""))
                // UpdateBookingFrame u = new UpdateBookingFrame();
                String bookingID = JOptionPane.showInputDialog(null, "Enter Booking ID:");
                updateBookingByID(bookingID);
              //  UpdateBookingFrame u = new UpdateBookingFrame();
            }
            else if(ae.getActionCommand().equals("Calculate Customer's Bill")){
                String bookingID = JOptionPane.showInputDialog(null, "Enter Booking ID:");
                calculateCustomerBill(bookingID);
            }
            else if(ae.getActionCommand().equals("Back to Main Menu")){
                CustomerMainMenu c = new CustomerMainMenu();
            }
        }
    }
    public static void viewBookingByID(String bookingID) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelBookings.ser"))) {
            while (true) {
                try {
                    Booking booking = (Booking) ois.readObject();
                    if (booking.getBookingID().equals(bookingID)) {
                        JOptionPane.showMessageDialog(null, "Booking Details for Booking ID: " + bookingID + "\n" + booking.toString());
                        ois.close();
                        return;
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            JOptionPane.showMessageDialog(null, "No booking found for Booking ID: " + bookingID);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class not found: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error viewing booking for Booking ID: " + bookingID + " - " + e.getMessage());
        }
    }

    public static void cancelBookingByID(String bookingID) {
        ArrayList<Booking> list = Booking.ReadFromBookings();
        for (int i = 0; i < list.size(); i++) {
            Booking booking = list.get(i);
            if (booking.getBookingID().equals(bookingID)) {
                list.remove(i);
                break;
            }
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("HotelBookings.ser"));
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }
            oos.close();
            System.out.println("Booking with ID: " + bookingID + " canceled successfully");
        } catch (IOException e) {
            System.out.println("Error canceling booking with ID: " + bookingID + " - " + e.getMessage());
        }
    }
//
//    public static void ReadFromBookings() {
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelBookings.ser"));
//            while (true) {
//                Booking b = (Booking) ois.readObject();
//                System.out.println(b);
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
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("HotelBookings.ser"));

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
    public static void updateBookingByID(String bookingID) {
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
                if (booking.getBookingID().equals(bookingID)) {
                    UpdateBookingFrame u = new UpdateBookingFrame();
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
    public static void calculateCustomerBill(String bookingID) {
        double totalBill = 0.0;

        ArrayList<Booking> list = Booking.ReadFromBookings();
        for (Booking booking : list) {
            if (booking.getBookingID().equals(bookingID)) {
                totalBill = booking.calculateTotalBill();
                break;
            }
        }
        System.out.println("Customer Bill for Booking ID: " + bookingID);
        System.out.println("Total Bill Amount: " + totalBill);
    }
}