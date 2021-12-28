package au.com.nig.recursion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FactorialTest {
    @Test
    fun `it should compute in a recursive manner the factorial`() {
        // Given
        val number = 5

        // When
        val result = Factorial.findFactorialRecursive(number)

        // Then
        assertEquals(120, result)
    }

    @Test
    fun `it should compute in an iterative manner the factorial`() {
        // Given
        val number = 5

        // When
        val result = Factorial.findFactorialIterative(number)

        // Then
        assertEquals(120, result)
    }
}
