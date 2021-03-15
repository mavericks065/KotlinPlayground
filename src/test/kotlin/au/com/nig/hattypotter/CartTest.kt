package au.com.nig.hattypotter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.MathContext

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
        assertEquals(0, BigDecimal.valueOf(8).compareTo(result))
    }

    @Test
    fun `for a cart containing 2 different books the price should be 16 - 5% Euros`() {
        // Given
        val listOfBooks = listOf(Book("Volume1"), Book("Volume2"))
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(0, BigDecimal.valueOf(15.2).compareTo(result))
    }

    @Test
    fun `for a cart containing 3 different books the price should be 24 - 10% Euros`() {
        // Given
        val listOfBooks = listOf(Book("Volume1"), Book("Volume2"), Book("Volume3"))
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(0, BigDecimal.valueOf(21.6).compareTo(result))
    }
}
