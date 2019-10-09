package au.com.nig.fizzbuzz

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FizzBuzzTest {

    @Test
    fun `should return fizz when receiving a multiple of 3`() {
        // Given
        val fizzBuzz = FizzBuzz()
        val nb = 3
        val nb1 = 12

        // WHEN
        val result = fizzBuzz.getResult(nb)
        val result1 = fizzBuzz.getResult(nb1)

        // THEN
        assertEquals("fizz", result)
        assertEquals("fizz", result1)
    }
    @Test
    fun `should return buzz when receiving a multiple of 5`() {
        // Given
        val fizzBuzz = FizzBuzz()
        val nb = 40
        val nb1 = 10

        // WHEN
        val result = fizzBuzz.getResult(nb)
        val result1 = fizzBuzz.getResult(nb1)

        // THEN
        assertEquals("buzz", result)
        assertEquals("buzz", result1)
    }

    @Test
    fun `should return fizzbuzz when receiving a multiple of 15`() {
        // Given
        val fizzBuzz = FizzBuzz()
        val nb = 30
        val nb1 = 15

        // WHEN
        val result = fizzBuzz.getResult(nb)
        val result1 = fizzBuzz.getResult(nb1)

        // THEN
        assertEquals("fizzbuzz", result)
        assertEquals("fizzbuzz", result1)
    }
    @Test
    fun `should return number when receiving a number that is not a multiple of 3, 5, 15`() {
        // Given
        val fizzBuzz = FizzBuzz()
        val nb = 7

        // WHEN
        val result = fizzBuzz.getResult(nb)

        // THEN
        assertEquals("7", result)
    }

}