package au.com.nig.hattypotter

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CartTest{
    @Test
    fun `for an empty cart the price should be 0`() {
        // Given
        val listOfBooks = emptyList<Book>()
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(0, result)
    }
}
