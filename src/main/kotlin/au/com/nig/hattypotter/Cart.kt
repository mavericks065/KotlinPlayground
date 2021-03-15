package au.com.nig.hattypotter

import au.com.nig.hattypotter.Book.Companion.PRICE
import au.com.nig.hattypotter.BookSetFactory.Discount.*
import java.math.BigDecimal

data class Cart(var books: List<Book> = emptyList(),
                var priceCalculator: PriceCalculator = PriceCalculator()) {

    fun getCartPrice(): BigDecimal {
        return priceCalculator.calculatePrice(books)
    }

    fun addItem(newBook: Book): List<Book> {
        books = books.plus(newBook)
        return books;
    }
}

class PriceCalculator {
    fun calculatePrice(books: List<Book>): BigDecimal {
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
    enum class Discount(val nbBooks: Int, val discount: Double) {
        NO_DISCOUNT(1, 1.0),
        FIVE_PERCENT(2, 0.95),
        TEN_PERCENT(3, 0.9),
        TWENTY_PERCENT(4, 0.8),
        TWENTY_FIVE_PERCENT(5, 0.75)
    }

    fun getOptimizedBookSetsForCart(books: List<Book>): List<BookSet> {
        return if (books.size == FIVE_PERCENT.nbBooks && books.map { it.title }.distinct().size == FIVE_PERCENT.nbBooks) {
            listOf(BookSet(books.toSet(), FIVE_PERCENT))
        } else if (books.size == TEN_PERCENT.nbBooks && books.map { it.title }.distinct().size == TEN_PERCENT.nbBooks) {
            listOf(BookSet(books.toSet(), TEN_PERCENT))
        } else if (books.size == TWENTY_PERCENT.nbBooks && books.map { it.title }.distinct().size == TWENTY_PERCENT.nbBooks) {
            listOf(BookSet(books.toSet(), TWENTY_PERCENT))
        } else if (books.size == TWENTY_FIVE_PERCENT.nbBooks && books.map { it.title }.distinct().size == TWENTY_FIVE_PERCENT.nbBooks) {
            listOf(BookSet(books.toSet(), TWENTY_FIVE_PERCENT))
        } else
            listOf(BookSet(books.toSet(), NO_DISCOUNT))
    }

}

data class BookSet(val books: Set<Book>, val setDiscount: BookSetFactory.Discount)

data class Book(val title: String) {
    companion object {
        val PRICE = BigDecimal.valueOf(8)
    }
}
