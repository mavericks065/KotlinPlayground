package au.com.nig.hattypotter

import au.com.nig.hattypotter.Book.Companion.PRICE
import java.math.BigDecimal

object Cart {
    val DISCOUNTS = mapOf(
        Pair(1, BigDecimal.valueOf(1)),
        Pair(2, BigDecimal.valueOf(0.95)),
        Pair(3, BigDecimal.valueOf(0.90)),
        Pair(4, BigDecimal.valueOf(0.80)),
        Pair(5, BigDecimal.valueOf(0.75))
    )


    fun getPrice(books: List<Book>): BigDecimal {
        val bookSize = books.size.toLong()
        return PRICE
            .times(BigDecimal.valueOf(bookSize))
            .times(DISCOUNTS.getOrDefault(bookSize.toInt(), BigDecimal.ONE))
    }

}

data class Book(val title: String) {
    companion object {
        val PRICE = BigDecimal.valueOf(8)
    }
}
