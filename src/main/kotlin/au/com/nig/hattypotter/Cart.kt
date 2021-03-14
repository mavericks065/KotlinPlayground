package au.com.nig.hattypotter

import java.math.BigDecimal

object Cart {
    fun getPrice(books: List<Book>): BigDecimal {
        return if (books.isNotEmpty()) {
            Book.PRICE
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
