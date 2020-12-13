package au.com.nig.oop.basics

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.time.Instant
import java.time.LocalDate

object EmployeeTest: Spek({
    describe("Employee"){
        it("should print firstName and lastName"){
            // Given
            val employee = Employee(
                firstName= "Test",
                lastName= "Name"
            )

            // When
            println(employee)
            println(employee.firstName)
            println(employee.lastName)

            employee.firstName = "Nicolas"

            println(employee.firstName)

            // Then
        }
        it("getAge() should return employee age"){
            // Given
            val birthDate = LocalDate.of(1965, 1,1)
            val dateOfBirth = Instant.ofEpochMilli(birthDate.toEpochDay())
            val employee = Employee(
                firstName= "Test",
                lastName= "Name",
                dateOfBirth= dateOfBirth
            )

            // When
            val result = employee.getAge()

            // Then
            assertEquals(55, result)
        }
        it("should create two employess and compare the names"){
            // Given
            val birthDate = LocalDate.of(1965, 1,1)
            val dateOfBirth = Instant.ofEpochMilli(birthDate.toEpochDay())

            val employee1 = Employee(
                firstName= "Paul",
                lastName= "Vince"
            )

            val employee2 = Employee(
                firstName= "Paul",
                lastName= "Vince"
            )


            // When
            println(employee1.firstName)
            println(employee1.lastName)

            println(employee2.firstName)
            println(employee2.lastName)

//            println(employee1.firstName == employee2.firstName)
//            println(employee1.firstName.equals(employee2.firstName))

            println(employee1 === employee2)
            println(employee1.equals(employee2))

            // Then
            assertEquals(true, employee1 == employee2)
            assertEquals(true, employee1.equals(employee2))
        }
    }
})
