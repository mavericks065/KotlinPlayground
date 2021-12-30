package au.com.nig.recursion

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FibonacciTest {

    @Test
    fun `it should return the fibonacci number at the index given in a recursive manner`() {
        // Given
        val number = 2
        val number1 = 5
        val number2 = 6

        // When
        val result = Fibonacci.findFibonacciRecursive(number)
        val result1 = Fibonacci.findFibonacciRecursive(number1)
        val result2 = Fibonacci.findFibonacciRecursive(number2)

        // Then
        assertEquals(1, result)
        assertEquals(5, result1)
        assertEquals(8, result2)
    }

    @Test
    fun `it should return the fibonacci number at the index given in an iterative manner`() {
        // Given
        val number = 2
        val number1 = 5
        val number2 = 6

        // When
        val result = Fibonacci.findFibonacciIterative(number)
        val result1 = Fibonacci.findFibonacciIterative(number1)
        val result2 = Fibonacci.findFibonacciIterative(number2)

        // Then
        assertEquals(1, result)
        assertEquals(5, result1)
        assertEquals(8, result2)
    }
}
