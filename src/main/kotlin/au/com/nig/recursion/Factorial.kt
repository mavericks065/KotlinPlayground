package au.com.nig.recursion

object Factorial {
    fun findFactorialRecursive(number: Int): Int {
        return if (number > 1)
            findFactorialRecursive(number - 1) * number
        else
            1
    }

    fun findFactorialIterative(number: Int): Int {
        var result = 1
        var i = number
        while (i > 1) {
            result *= i
            i--
        }
        return result
    }
}
