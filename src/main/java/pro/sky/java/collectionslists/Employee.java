package pro.sky.java.collectionslists;


public class Employee {
    private String firstName;
    private String lastName;


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }


    @Override
    public String toString () {
        return  "firstName: " + this.firstName + ", lastName: " + this.lastName;
    }

}