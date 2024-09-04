import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Manager implements Serializable {
    private String name;
    private String position;
    private int age;
    private List<Employee> employees;

    public Manager(String name, String position, int age, ArrayList<Employee> e) {
        this.name = name;
        this.position = position;
        this.age = age;
        for(int i=0;i<employees.size();i++){
            employees.add(e.get(i));
        }
    }

    public Manager() {
        name="Hafsa";
        position="Top manager";
        age=25;
        for(int i=0;i<employees.size();i++){
            employees.add(null);
        }
    }
    Manager(Manager m){
        this.name=m.name;
        this.position=m.position;
        this.age=m.age;
        for(int i=0;i<employees.size();i++){
            this.employees.add(m.employees.get(i));
        }
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public String toString() {
        return "Manager: " + name + ", Position: " + position + ", Age: " + age;
    }
    public static ArrayList<ExecutiveSuite> readAllFromSuites() {
        ArrayList<ExecutiveSuite> list = new ArrayList<>();

        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("HotelSuites.txt"));

            while (true) {
                ExecutiveSuite newSuite = (ExecutiveSuite) os.readObject();
                list.add(newSuite);
            }
        } catch (ClassNotFoundException | EOFException e) {
            // Handle exceptions here
        } catch (IOException e) {
            // Handle exceptions here
        }
        return list;
    }

    public static void readFromVillas() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelVilla.txt"));
            while (true) {
                Villa ph = (Villa) ois.readObject();
                System.out.println(ph);
            }
        } catch (ClassNotFoundException | EOFException e) {
            return;
        } catch (IOException e) {
            return;
        }
    }

    public static ArrayList<Villa> readAllFromVillas() {
        ArrayList<Villa> list = new ArrayList<>();

        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("HotelVillas.txt"));

            while (true) {
                Villa ph = (Villa) os.readObject();
                list.add(ph);
            }
        } catch (ClassNotFoundException | EOFException e) {
            // Handle exceptions here
        } catch (IOException e) {
            // Handle exceptions here
        }
        return list;
    }
    public static void viewAvailableApartments() {
        ArrayList<Villa> villa = readAllFromVillas();

        for (int i = 0; i < villa.size(); i++) {
            if (villa.get(i).getAvailability()) {
                System.out.println(villa.get(i));
            }
        }

        ArrayList<ExecutiveSuite> suites = readAllFromSuites();

        for (int i = 0; i < suites.size(); i++) {
            if (suites.get(i).getAvailability()) {
                System.out.println(suites.get(i));
            }
        }
    }
}