package au.com.nig.stringcalculator

import org.junit.jupiter.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object StringCalculatorTest : Spek({
    describe("function add number") {
        it("should return 0 if empty string is passed") {
            // GIVEN WHEN
            val result = StringCalculator.add("")

            // THEN
            Assertions.assertEquals(0, result)
        }
        describe("when 1 number") {
            it("should return it") {
                // GIVEN WHEN
                val result = StringCalculator.add("1")

                // THEN
                Assertions.assertEquals(1, result)
            }
        }
        describe("when receiving normal numbers") {
            it("should add them") {
                // GIVEN WHEN
                val result = StringCalculator.add("1,2")

                // THEN
                Assertions.assertEquals(3, result)
            }
        }

    }
})