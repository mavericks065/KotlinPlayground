package au.com.nig.hattypotter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class CartTest{
    @Test
    fun `for an empty cart the price should be 0`() {
        // Given
        val cart = Cart()
        // When
        val result = cart.getCartPrice()
        // Then
        assertEquals(BigDecimal.ZERO, result)
    }

    @Test
    fun `for a cart containing only ONE book the price should be 8 Euros`() {
        // Given
        val cart = Cart()
        cart.addItem(Book("Volume1"))
        // When
        val result = cart.getCartPrice()
        // Then
        assertEquals(0, BigDecimal.valueOf(8).compareTo(result))
    }

    @Test
    fun `for a cart containing 2 different books the price should be 16 - 5% Euros`() {
        // Given
        val cart = Cart()
        cart.addItem(Book("Volume1"))
        cart.addItem(Book("Volume2"))
        // When
        val result = cart.getCartPrice()
        // Then
        assertEquals(0, BigDecimal.valueOf(15.2).compareTo(result))
    }

    @Test
    fun `for a cart containing 3 different books the price should be 24 - 10% Euros`() {
        // Given
        val cart = Cart()
        cart.addItem(Book("Volume1"))
        cart.addItem(Book("Volume2"))
        cart.addItem(Book("Volume3"))
        // When
        val result = cart.getCartPrice()
        // Then
        assertEquals(0, BigDecimal.valueOf(21.6).compareTo(result))
    }

    @Test
    fun `for a cart containing 4 different books the price should be 32 - 20% Euros`() {
        // Given
        val cart = Cart()
        cart.addItem(Book("Volume1"))
        cart.addItem(Book("Volume2"))
        cart.addItem(Book("Volume3"))
        cart.addItem(Book("Volume4"))
        // When
        val result = cart.getCartPrice()
        // Then
        assertEquals(0, BigDecimal.valueOf(25.6).compareTo(result))
    }
}
