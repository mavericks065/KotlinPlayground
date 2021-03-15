package au.com.nig.hattypotter

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
            if (books.size == 2 && books.map { it.title }.distinct().size == 2) {
                Book.PRICE.multiply(BigDecimal(2)).multiply(BigDecimal.valueOf(0.95))
            } else if (books.size == 3 && books.map { it.title }.distinct().size == 3) {
                Book.PRICE.multiply(BigDecimal(3)).multiply(BigDecimal.valueOf(0.9))
            } else if (books.size == 4 && books.map { it.title }.distinct().size == 4) {
                Book.PRICE.multiply(BigDecimal(4)).multiply(BigDecimal.valueOf(0.8))
            } else
                Book.PRICE.multiply(BigDecimal(books.size))
        } else {
            BigDecimal.ZERO
        }
    }
}

data class Book(val title: String) {
    companion object {
        val PRICE = BigDecimal.valueOf(8)
    }
}
