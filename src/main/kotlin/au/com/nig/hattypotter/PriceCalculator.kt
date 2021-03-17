package au.com.nig.hattypotter

import java.math.BigDecimal

class PriceCalculator {
    fun calculatePrice(books: List<Item>): BigDecimal {
        return if (books.isNotEmpty()) {
            BookSetFactory.getOptimizedBookSetsForCart(books)
                .map { it.books.size.toDouble().times(it.setDiscount.discount) }
                .map { Book.PRICE.multiply(BigDecimal.valueOf(it)) }
                .reduce{x, y -> x.plus(y)}

        } else {
            BigDecimal.ZERO
        }
    }
}
