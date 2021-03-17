package au.com.nig.hattypotter

import au.com.nig.hattypotter.BookSetFactory.Discount.*

data class BookSet(val books: Set<Book>, val setDiscount: BookSetFactory.Discount)

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
