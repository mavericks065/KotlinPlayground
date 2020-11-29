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
    }
})
