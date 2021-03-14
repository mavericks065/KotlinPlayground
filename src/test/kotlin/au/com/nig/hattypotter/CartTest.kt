package au.com.nig.hattypotter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class CartTest{
    @Test
    fun `for an empty cart the price should be 0`() {
        // Given
        val listOfBooks = emptyList<Book>()
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(BigDecimal.ZERO, result)
    }

    @Test
    fun `for a cart containing only ONE book the price should be 8 Euros`() {
        // Given
        val listOfBooks = listOf(Book("Volume1"))
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(BigDecimal.valueOf(8), result)
    }

    @Test
    fun `for a cart containing 2 different books the price should be 16 - 5% Euros`() {
        // Given
        val listOfBooks = listOf(Book("Volume1"), Book("Volume2"))
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(BigDecimal.valueOf(15.2), result)
    }
}
