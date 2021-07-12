package au.com.nig.hattypotter

import java.math.BigDecimal

data class Book(val title: String) {
    companion object {
        val PRICE = BigDecimal.valueOf(8)
    }
}
