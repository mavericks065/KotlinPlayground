package au.com.nig.fizzbuzz

class FizzBuzz {
    companion object {
        const val FIZZBUZZ = "fizzbuzz"
        const val FIZZ = "fizz"
        const val BUZZ = "buzz"
    }
    fun getResult(number: Int): String {
        return when(0) {
            number % 15 -> FIZZBUZZ
            number % 3 -> FIZZ
            number % 5 -> BUZZ
            else -> number.toString()
        }
    }

    fun <U> processList(numbers: List<Int>, fn: (String) -> U): List<U> {
        return numbers.map { fn(getResult(it)) }
    }
}