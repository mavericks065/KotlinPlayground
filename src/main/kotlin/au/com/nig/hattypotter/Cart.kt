package au.com.nig.hattypotter

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
            if (books.size == FIVE_PERCENT.nbBooks && books.map { it.title }.distinct().size == FIVE_PERCENT.nbBooks) {
                Book.PRICE.multiply(BigDecimal(FIVE_PERCENT.nbBooks)).multiply(BigDecimal.valueOf(FIVE_PERCENT.discount))
            } else if (books.size == TEN_PERCENT.nbBooks && books.map { it.title }.distinct().size == TEN_PERCENT.nbBooks) {
                Book.PRICE.multiply(BigDecimal(TEN_PERCENT.nbBooks)).multiply(BigDecimal.valueOf(TEN_PERCENT.discount))
            } else if (books.size == TWENTY_PERCENT.nbBooks && books.map { it.title }.distinct().size == TWENTY_PERCENT.nbBooks) {
                Book.PRICE.multiply(BigDecimal(TWENTY_PERCENT.nbBooks)).multiply(BigDecimal.valueOf(TWENTY_PERCENT.discount))
            } else if (books.size == TWENTY_FIVE_PERCENT.nbBooks && books.map { it.title }.distinct().size == TWENTY_FIVE_PERCENT.nbBooks) {
                Book.PRICE.multiply(BigDecimal(TWENTY_FIVE_PERCENT.nbBooks)).multiply(BigDecimal.valueOf(TWENTY_FIVE_PERCENT.discount))
            } else
                Book.PRICE.multiply(BigDecimal(books.size))
        } else {
            BigDecimal.ZERO
        }
    }
}

object BookSetFactory {
    enum class Discount(val nbBooks: Int, val discount: Double) {
        FIVE_PERCENT(2, 0.95),
        TEN_PERCENT(3, 0.9),
        TWENTY_PERCENT(4, 0.8),
        TWENTY_FIVE_PERCENT(5, 0.75)
    }
}

data class Book(val title: String) {
    companion object {
        val PRICE = BigDecimal.valueOf(8)
    }
}
