import java.io.Serializable;

public class Person implements Serializable {
    String firstName, lastName;
    String email;

    public Person(){
        firstName = " null ";
        lastName = "null ";
        email = " null ";
    }
    public Person(String f, String l, String e){
        firstName = f;
        lastName = l;
        email = e;

//        boolean b = ValidateEmail(e);
//        if(b){
//            email = e;
//
//        }
//        else
//            email = " null ";

    }

    public Person(Person p){
        this.firstName = p.firstName;
        this.lastName = p.lastName;
        this.email = p.email;
    }

    public void setFirstName(String f) {
        firstName = f;
    }

    public void setLastName(String l) {
        lastName = l;
    }

    public void setEmail(String e) {

        boolean b = ValidateEmail(e);
        if(b){
            email = e;

        }
        else
            email = " null ";
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    public String toString(){

        return "\nFIRST NAME: " + firstName + "\nLAST NAME:  "  + lastName +  "\nEMAIL:   "  + email;
    }

    private boolean ValidateEmail(String e){

        if(e.contains("@")){
            return true;
        }
        else{
            return false;
        }
    }

}
