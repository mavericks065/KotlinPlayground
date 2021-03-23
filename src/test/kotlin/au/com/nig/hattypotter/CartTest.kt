package au.com.nig.hattypotter

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class CartTest {
    @Test
    fun `for an empty cart the price should be 0`() {
        // Given
        val listOfBooks = emptyList<Book>()
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(0, BigDecimal.ZERO.compareTo(result))
    }

    @Test
    fun `for one book in the cart the price should be 8 EUR`() {
        // Given
        val listOfBooks = listOf(Book("Volume 1"))
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(0, BigDecimal.valueOf(8).compareTo(result))
    }

    @Test
    fun `for two different books in the cart the price should be 16 * 0,95 EUR`() {
        // Given
        val listOfBooks = listOf(Book("Volume 1"), Book("Volume 2"))
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(0, BigDecimal.valueOf(15.2).compareTo(result))
    }

    @Test
    fun `for 3 different books in the cart the price should be 24 * 0,9 EUR`() {
        // Given
        val listOfBooks = listOf(Book("Volume 1"), Book("Volume 2"), Book("Volume 3"))
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(0, BigDecimal.valueOf(21.6).compareTo(result))
    }

    @Test
    fun `for 4 different books in the cart the price should be 32 * 0,8 EUR`() {
        // Given
        val listOfBooks = listOf(Book("Volume 1"), Book("Volume 2"), Book("Volume 3"), Book("Volume 4"))
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(0, BigDecimal.valueOf(25.6).compareTo(result))
    }

    @Test
    fun `for 5 different books in the cart the price should be 40 * 0,75 EUR`() {
        // Given
        val listOfBooks = listOf(Book("Volume 1"), Book("Volume 2"), Book("Volume 3"), Book("Volume 4"), Book("Volume 5"))
        // When
        val result = Cart.getPrice(listOfBooks)
        // Then
        assertEquals(0, BigDecimal.valueOf(30.0).compareTo(result))
    }
}
