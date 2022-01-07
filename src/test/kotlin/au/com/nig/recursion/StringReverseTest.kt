package au.com.nig.recursion

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StringReverseTest {
    @Test
    fun `reverseStringUsingIterative should return a string reversed`() {
        // Given
        val input = "hello"

        // When
        val result = StringReverse.reverseUsingIterative(input)

        // Then
        assertEquals("olleh", result)
    }
    @Test
    fun `reverseStringUsingRecursion should return a string reversed`() {
        // Given
        val input = "hello"

        // When
        val result = StringReverse.reverseUsingRecursion(input)

        // Then
        assertEquals("olleh", result)
    }

}
