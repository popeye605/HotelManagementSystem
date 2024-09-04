import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;

public class UpdateBookingFrame extends JFrame {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l0, totalBillLabel;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t0;
    JButton j1;
    JButton j2;
    JRadioButton rb1, rb2;
    ButtonGroup buttonGroup;

    UpdateBookingFrame() {
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(10, 2, 5, 5));
        totalBillLabel = new JLabel(""); // Initialize the label

        l0 = new JLabel("Enter the ID");
        t0 = new JTextField(20);
        l1 = new JLabel("Number of days");
        t1 = new JTextField(20);
        l2 = new JLabel("Apartment Type");
        rb1 = new JRadioButton("Villa");
        rb2 = new JRadioButton("Executive Suite");
        l3 = new JLabel("Check-in Day");
        t3 = new JTextField(20);
        l4 = new JLabel("Check-in Month");
        t4 = new JTextField(20);
        l5 = new JLabel("Check-in Year");
        t5 = new JTextField(20);
        l6 = new JLabel("Check-out Day");
        t6 = new JTextField(20);
        l7 = new JLabel("Check-out Month");
        t7 = new JTextField(20);
        l8 = new JLabel("Check-out Year");
        t8 = new JTextField(20);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(rb1);
        buttonGroup.add(rb2);

        //  add(l0);
        //  add(t0);
        add(l1);
        add(t1);
        add(l2);
        add(rb1);
        add(new JLabel()); // Empty label for spacing
        add(rb2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(l8);
        add(t8);

        j1 = new JButton("Update Booking");
        j2 = new JButton("Cancel");
        MyActionListener listener = new MyActionListener();
        j1.addActionListener(listener);
        j2.addActionListener(listener);
        add(j1);
        add(j2);
        add(new JLabel("Total Bill:")); // Label for displaying the total bill
        add(totalBillLabel);
    }

    public class MyActionListener implements ActionListener {
        Booking updatedBooking;

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Update Booking")) {
                String id = t0.getText();
                ArrayList<Booking> list = Booking.ReadFromBookings();
                Booking b = null;
                System.out.println("before loop");
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getBookingID().equals(id)) {
                        b = list.get(i);
                        break;
                    }
                }
                System.out.println("afterloop");
                System.out.println(b.getBookingID());
                if (b != null) {
                    int numOfDays = Integer.parseInt(t1.getText());
                    int day = Integer.parseInt(t3.getText());
                    int month = Integer.parseInt(t4.getText());
                    int year = Integer.parseInt(t5.getText());
                    int day1 = Integer.parseInt(t6.getText());
                    int month1 = Integer.parseInt(t7.getText());
                    int year1 = Integer.parseInt(t8.getText());
                    Date checkInDate = new Date(year - 1900, month - 1, day);
                    Date checkOutDate = new Date(year1 - 1900, month1 - 1, day1);
                    // Create the booking object

                    Apartment apartment;
                    if (rb1.isSelected()) {
                        apartment = new Villa();
                    } else if (rb2.isSelected()) {
                        apartment = new ExecutiveSuite();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select an apartment type.");
                        return;
                    }

                    updatedBooking = new Booking(checkInDate, checkOutDate, numOfDays, apartment);
                    double totalBill = updatedBooking.calculateTotalBill();

                    // Set the calculated total bill in the label
                    totalBillLabel.setText(String.valueOf(totalBill));
                    updatedBooking = new Booking(checkInDate, checkOutDate, numOfDays, apartment, totalBill);
                    // updatedBooking.setBookingID(b.getBookingID());
                    //updatedBooking.setCustomer(b.getCustomer());
                    Booking.UpdateBooking(updatedBooking);
                    Booking.WriteToBookings(updatedBooking);
                    JOptionPane.showMessageDialog(null, "Booking Updated Successfully");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Booking id not found.");
                }

            }
        }
    }
}
