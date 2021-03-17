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

class PriceCalculator {
    fun calculatePrice(books: List<Item>): BigDecimal {
        return if (books.isNotEmpty()) {
            BookSetFactory.getOptimizedBookSetsForCart(books)
                .map { it.books.size.toDouble().times(it.setDiscount.discount) }
                .map { PRICE.multiply(BigDecimal.valueOf(it)) }
                .reduce{x, y -> x.plus(y)}

        } else {
            BigDecimal.ZERO
        }
    }
}

object BookSetFactory {
    enum class Discount(val discount: Double) {
        NO_DISCOUNT(1.0),
        FIVE_PERCENT(0.95),
        TEN_PERCENT(0.9),
        TWENTY_PERCENT(0.8),
        TWENTY_FIVE_PERCENT(0.75)
    }

    fun getOptimizedBookSetsForCart(items: List<Item>): List<BookSet> {
        val result: MutableList<Set<Book>> = mutableListOf(items.map { it.book }.toSet())

        var areThereLeftOverItems = true
        var leftOverItems: List<Item> = items
        while (areThereLeftOverItems) {
            leftOverItems = leftOverItems.map { (book, quantity) -> Item(book, quantity - 1) }
                .filter { it.qtity > 0 }
            if (leftOverItems.isEmpty()) {
                areThereLeftOverItems = false
            } else {
                result.add(leftOverItems.map { it.book }.toSet())
                areThereLeftOverItems = true
            }

        }
        return result.map { books ->
            val discount = when (books.size) {
                2 -> FIVE_PERCENT
                3 -> TEN_PERCENT
                4 -> TWENTY_PERCENT
                5 -> TWENTY_FIVE_PERCENT
                else -> NO_DISCOUNT
            }
            BookSet(books, discount)
        }.toList()
    }

}

data class BookSet(val books: Set<Book>, val setDiscount: BookSetFactory.Discount)

data class Book(val title: String) {
    companion object {
        val PRICE = BigDecimal.valueOf(8)
    }
}
