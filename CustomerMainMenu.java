import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CustomerMainMenu extends JFrame implements Serializable {
    JButton j1;
    JButton j2;
    JButton j3;

    CustomerMainMenu() {
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(5, 2));
        j1 = new JButton("Manager Operations");
        j2 = new JButton("Customer Operations");
        add(j1);
        add(j2);
        MyActionListener a = new MyActionListener();

        j1.addActionListener(a);
        j2.addActionListener(a);
    }

    public class MyActionListener implements ActionListener {
        private final String managerPassword = "PineHotel123";

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Manager Operations")) {
                String inputPassword = JOptionPane.showInputDialog(null, "Enter Manager Password:");

                if (inputPassword != null && inputPassword.equals(managerPassword)) {
                    ManagerFrame a = new ManagerFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect password. Please try again.");
                }
            } else if (e.getActionCommand().equals("Customer Operations")) {
                CustomerFrame c = new CustomerFrame();
            }
        }
    }
}
