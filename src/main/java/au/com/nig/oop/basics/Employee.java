package au.com.nig.oop.basics;

import java.time.*;

public final class Employee {

    private final String firstName;
    private final String lastName;
    private Instant dob = null;

    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, Instant dob){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public void setDob(Instant dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Instant getDob() {
        return dob;
    }

    public int calculateAge(){
        Period period = Period.between(LocalDate.ofInstant(getDob(), ZoneOffset.UTC), LocalDate.ofInstant(Instant.now(), ZoneOffset.UTC));
        return period.getYears();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                '}';
    }
}