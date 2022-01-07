package au.com.nig.recursion

object StringReverse {
    fun reverseUsingIterative(input: String?): String {
        if (input.isNullOrBlank())
            return ""

        var result = ""
        for (i in input.length-1 downTo 0) {
            result += input[i]
        }
        return result
    }

    fun reverseUsingRecursion(input: String?): String {
        if (input.isNullOrBlank())
            return ""
        else {
            return reverseUsingRecursion(input.substring(1)) + input[0]
        }

    }
}
