package au.com.nig.hattypotter

import au.com.nig.hattypotter.Book.Companion.PRICE
import au.com.nig.hattypotter.BookSetFactory.Discount.*
import java.math.BigDecimal

data class Cart(var priceCalculator: PriceCalculator = PriceCalculator(),
                var items: List<Item> = emptyList()) {

    fun getCartPrice(): BigDecimal {
        return priceCalculator.calculatePrice(items)
    }

    fun addItem(newBook: Book): List<Item> {
        val existingItem = items.find { it.book.equals(newBook) }

        if (existingItem == null) {
            items = items.plus(Item(newBook, 1))
        } else {
            existingItem.qtity = existingItem.qtity + 1
        }

        return items;
    }
}

data class Item(val book: Book, var qtity: Int)
