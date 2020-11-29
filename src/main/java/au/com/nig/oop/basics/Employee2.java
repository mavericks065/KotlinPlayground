package au.com.nig.oop.basics;

public final class Employee2 {

    public final String firstName;
    public final String lastName;

    public Employee2(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}