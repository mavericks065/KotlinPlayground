package au.com.nig.hattypotter

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

    @Test
    fun `for 3 different books and 1 same book for total of 4 books the price should be 24 * 0,9 EUR + 8 EUR`(){
        // Given
        val listOfBooks = listOf(Book("Volume 1"), Book("Volume 2"), Book("Volume 3"), Book("Volume 3"))

        // When
        val result = Cart.getPrice(listOfBooks)

        // Then
        assertEquals(0, BigDecimal.valueOf(29.6).compareTo(result))
    }

    @Test
    fun `findSet`(){
        // Given
        val listOfBooks = listOf(Book("Volume 1"), Book("Volume 2"), Book("Volume 3"), Book("Volume 3"))

        // When
        val result = Cart.findSetSize(listOfBooks) //

        // Then
        assertEquals(3, result)
    }

    @Test
    fun `findListOfSetOfBooks`(){
        // Given
        val listOfBooks = listOf(Book("Volume 1"), Book("Volume 2"), Book("Volume 3"), Book("Volume 2"), Book("Volume 3"))
        val setOne = listOf(Book("Volume 1"), Book("Volume 2"), Book("Volume 3"))
        val setTwo = listOf(Book("Volume 2"), Book("Volume 3"))
        val expected = listOf(setOne, setTwo)

        // When
        val result = Cart.findBookSet(listOfBooks)

        // Then
        assertEquals(expected, result)
    }

    // [1,2,3,3] set would be [1,2,3]
    // [1,2,3,2,3] set would be [[1,2,3], [2,3]]
}
