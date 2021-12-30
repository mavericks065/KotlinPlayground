package au.com.nig.recursion

object Fibonacci {
    fun findFibonacciRecursive(number: Int): Int {
        val first = 0
        val second = 1

        return when (number) {
            0 -> first
            1, 2 -> second
            else -> {
                findFibonacciRecursive(number - 1) + findFibonacciRecursive(number - 2)
            }
        }
    }

    fun findFibonacciIterative(number: Int): Int {
        if (number == 0) return 0
        if (number == 1 || number == 2) return 1
        val last2Nbs = intArrayOf(1, 1)
        for (i in 3..number) {
            val temp0 = last2Nbs[0]
            val temp1 = last2Nbs[1]
            last2Nbs[0] = temp1
            last2Nbs[1] = temp1 + temp0
        }
        return last2Nbs[1]
    }
}
