package au.com.nig.stringcalculator

object StringCalculator {
    fun add(string: String): Int {
        return string.split(",").mapNotNull { it.toIntOrNull() }.sum()
    }
}