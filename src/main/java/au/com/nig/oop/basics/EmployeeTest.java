package au.com.nig.oop.basics;

import java.time.Instant;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee("Tom", "Jones", Instant.parse("2010-10-01T08:25:24.00Z"));
        Employee employeeWithDob = new Employee("Tim", "Jones", Instant.now());

        Employee2 employee2 = new Employee2("Mary", "Smith");

        System.out.println(employee.toString());
        System.out.println(employee.calculateAge());

        System.out.println(employeeWithDob.toString());
        System.out.println(employee2.toString());
    }
}
