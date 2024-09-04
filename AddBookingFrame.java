import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookingFrame extends JFrame {
    JButton b1;
    JButton b2;
    JButton b3;
    JLabel l1, l0, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JTextField t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
    JRadioButton rb1, rb2;
    ButtonGroup buttonGroup;
    JLabel totalBillLabel; // New label for displaying the total bill

    public AddBookingFrame() {
        setLayout(new GridLayout(14, 2)); // Increased the number of rows to accommodate the new label

        l4 = new JLabel("Booking ID");
        t4 = new JTextField(20);
        l5 = new JLabel("First Name");
        t5 = new JTextField(20);
        l2 = new JLabel("Last Name");
        t2 = new JTextField(10);
        l0 = new JLabel("Email");
        t0 = new JTextField(20);
        l6 = new JLabel("Apartment Type");
        rb1 = new JRadioButton("Villa");
        rb2 = new JRadioButton("Executive Suite");
        l1 = new JLabel("Number of days");
        t1 = new JTextField(20);
        l2 = new JLabel("Check-in Day");
        t2 = new JTextField(20);
        l3 = new JLabel("Check-in Month");
        t3 = new JTextField(20);
        l7 = new JLabel("Check-in Year");
        t7 = new JTextField(20);
        l8 = new JLabel("Check-out Day");
        t8 = new JTextField(20);
        l9 = new JLabel("Check-out Month");
        t9 = new JTextField(20);
        l10 = new JLabel("Check-out Year");
        t10 = new JTextField(20);
        l11 = new JLabel("Check-out Month");
        t11 = new JTextField(20);
        l12 = new JLabel("Check-out Year");
        t12 = new JTextField(20);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(rb1);
        buttonGroup.add(rb2);
        b1 = new JButton("Add Booking");
        b2 = new JButton("Cancel");
        b3 = new JButton("MAIN MENU");

        totalBillLabel = new JLabel(""); // Initialize the label

        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l2);
        add(t2);
        add(l0);
        add(t0);
        add(l6);
        JPanel apartmentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        apartmentPanel.add(rb1);
        apartmentPanel.add(rb2);
        add(apartmentPanel);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l7);
        add(t7);
        add(l8);
        add(t8);
        add(l9);
        add(t9);
        add(l10);
        add(t10);
        add(l11);
        add(t11);
        add(l12);
        add(t12);
        add(b1);
        add(b2);
        add(b3);
        add(new JLabel("Total Bill:")); // Label for displaying the total bill
        add(totalBillLabel); // Label to show the total bill

        MyActionListener listener = new MyActionListener();
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);

        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public class MyActionListener implements ActionListener {
        Booking booking;
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add Booking")) {
                // Retrieve the values from the text fields
                String bookingID = t4.getText();
                String firstName = t5.getText();
                String lastName = t2.getText();
                String email = t0.getText();
                int noOfDays = Integer.parseInt(t1.getText());
                int checkInDay = Integer.parseInt(t2.getText());
                int checkInMonth = Integer.parseInt(t3.getText());
                int checkInYear = Integer.parseInt(t7.getText());
                int checkOutDay = Integer.parseInt(t8.getText());
                int checkOutMonth = Integer.parseInt(t9.getText());
                int checkOutYear = Integer.parseInt(t10.getText());

                // Create the customer object
                Customer customer = new Customer(firstName, lastName, email);

                // Create the apartment object based on the selected radio button
                Apartment apartment;
                if (rb1.isSelected()) {
                    apartment = new Villa();
                } else if (rb2.isSelected()) {
                    apartment = new ExecutiveSuite();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an apartment type.");
                    return;
                }
                Date checkInDate = new Date(checkInDay, checkInMonth, checkInYear);
                Date checkOutDate = new Date(checkOutDay, checkOutMonth, checkOutYear);
                booking = new Booking(checkInDate, checkOutDate, noOfDays, bookingID, customer, apartment);
                double totalBill = booking.calculateTotalBill();

                totalBillLabel.setText(String.valueOf(totalBill));
                new Booking(checkInDate, checkOutDate, noOfDays, bookingID, customer, apartment,totalBill);
                Booking.WriteToBookings(booking);
                JOptionPane.showMessageDialog(null, "Booking Added Successfully");
            } else if (e.getActionCommand().equals("Cancel")) {
                System.exit(0);
            } else if (e.getActionCommand().equals("MAIN MENU")) {
                CustomerMainMenu c = new CustomerMainMenu();
            }
        }
    }
}
