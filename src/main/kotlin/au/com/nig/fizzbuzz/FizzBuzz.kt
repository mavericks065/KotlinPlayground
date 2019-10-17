package au.com.nig.fizzbuzz

class FizzBuzz {
    companion object {
        const val FIZZBUZZ = "fizzbuzz"
        const val FIZZ = "fizz"
        const val BUZZ = "buzz"
    }

    fun getResult(number: Int): String {
        return when {
            number % 15 == 0 -> FIZZBUZZ
            isFizz(number) -> FIZZ
            isBuzz(number) -> BUZZ
            else -> number.toString()
        }
    }

    fun <U> processList(numbers: List<Int>, fn: (String) -> U): List<U> {
        return numbers.map { fn(getResult(it)) }
    }

    private fun isBuzz(number: Int) = number % 5 == 0 || number.toString().contains("5")

    private fun isFizz(number: Int) = number % 3 == 0 || number.toString().contains("3")
}