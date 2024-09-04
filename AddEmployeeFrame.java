import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;



public class AddEmployeeFrame extends JFrame{
    JButton b1;
    JButton b2;
    JButton b3;
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;

    AddEmployeeFrame() {
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(5, 2));
        l1 = new JLabel("Name");
        t1 = new JTextField(20);
        l2 = new JLabel("Position");
        t2 = new JTextField(20);
        l3 = new JLabel("Salary");
        t3 = new JTextField(20);
        b1 = new JButton("Add Employee");
        b2 = new JButton("Cancel");
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        MyActionListener listener = new MyActionListener();
        b1.addActionListener(listener);
        b2.addActionListener(listener);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Add Employee")) {
                String name = t1.getText();
                String position = t2.getText();
                double salary = Double.parseDouble(t3.getText());
                Employee employee = new Employee(name, position, salary);
                Employee.WriteToEmployee(employee);
                JOptionPane.showMessageDialog(null,"Employee Added Successfully");
            } else {
                System.exit(0);
            }
        }
    }
}
