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
        val distinctBookSize = findSetSize(books).toLong()
        val setOne = PRICE
            .times(BigDecimal.valueOf(distinctBookSize))
            .times(DISCOUNTS.getOrDefault(distinctBookSize.toInt(), BigDecimal.ONE))
        val setTwo = PRICE
            .times(BigDecimal.valueOf(bookSize - distinctBookSize))
            .times(DISCOUNTS.getOrDefault(bookSize.toInt() - distinctBookSize.toInt(), BigDecimal.ONE))
        return setOne + setTwo
    }

    fun findSetSize(books: List<Book>): Int {
        return books.distinct().size
    }

    fun findBookSet(books: List<Book>): List<List<Book>>{
        println(books.groupBy{ book -> book.title }.map { entry -> Pair(entry.key, entry.value.size) })
        return emptyList()
    }
}

data class Book(val title: String) {
    companion object {
        val PRICE = BigDecimal.valueOf(8)
    }
}
