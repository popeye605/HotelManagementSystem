import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class AddCustomerFrame extends JFrame {

        JLabel l1,l2,l3,l4,l5;
        JTextField t1,t2,t3,t4,t5;
        JButton j1,j2;
    AddCustomerFrame(){
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(0, 2));

        l1 = new JLabel("First Name");
        t1 = new JTextField(10);
        l2 = new JLabel("Last Name");
        t2 = new JTextField(10);
        l3 = new JLabel("Email");
        t3 = new JTextField(10);
        l4 = new JLabel("Customer ID");
        t4 = new JTextField(10);
        l5 = new JLabel("Phone number");
        t5 = new JTextField(10);
        j1 = new JButton("Add Customer");
        j2 = new JButton("Cancel");

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(j1);
        add(j2);

        MyActionListener a = new MyActionListener();
        j1.addActionListener(a);
        j2.addActionListener(a);
    }

    public class MyActionListener implements ActionListener {
            public void actionPerformed(ActionEvent ae){
                if(ae.getActionCommand().equals("Add Customer")){
                    String f = t1.getText();
                    String l = t2.getText();
                    String e = t3.getText();
                    String i = t4.getText();
                    String p=t5.getText();
                   // Customer c = new Customer(f,l,e,i,p);
                  //  Customer.WriteToCustomer(c);

                    JOptionPane.showMessageDialog(null,"Customer Added Successfully!");

                }
                if(ae.getActionCommand().equals("Cancel")){
                    System.exit(0);
                }
            }
        }

}
