package au.com.nig.oop.basics

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

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

            // Then
        }
    }
})