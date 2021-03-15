package au.com.nig.hattypotter

import java.math.BigDecimal

object Cart {
    fun getPrice(books: List<Book>): BigDecimal {
        return if (books.isNotEmpty()) {
            if (books.size == 2 && books.map { it.title }.distinct().size == 2) {
                Book.PRICE.multiply(BigDecimal(2)).multiply(BigDecimal.valueOf(0.95))
            } else if (books.size == 3 && books.map { it.title }.distinct().size == 3) {
                Book.PRICE.multiply(BigDecimal(3)).multiply(BigDecimal.valueOf(0.9))
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
