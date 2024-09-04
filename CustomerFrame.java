import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CustomerFrame extends JFrame implements Serializable{
    JButton j1;
    JButton j2;

    public CustomerFrame() {
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2, 1));

        j1 = new JButton("View Booking");
        j2 = new JButton("Add Booking");

        add(j1);
        add(j2);

        MyActionListener listener = new MyActionListener();
        j1.addActionListener(listener);
        j2.addActionListener(listener);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Booking b;
            if (e.getActionCommand().equals("Add Booking")) {
                AddBookingFrame addBookingFrame = new AddBookingFrame();
            } else if (e.getActionCommand().equals("View Booking")) {
                String customerID = JOptionPane.showInputDialog(null, "Enter Customer ID:");
                //bookin b = viewBookingByID(customerID);
                b = Booking.viewBooking(customerID);
               if(b==null){
                   System.out.println("NULL");
               }
               else{
                  JOptionPane.showMessageDialog(null,b.toString());
               }
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


}
