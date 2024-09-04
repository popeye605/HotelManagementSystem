import java.io.*;

public class Employee implements Serializable {
    private String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee: " + name + ", Position: " + position + ", Salary: $" + salary;
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
}