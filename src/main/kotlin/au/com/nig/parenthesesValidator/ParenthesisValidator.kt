package au.com.nig.parenthesesValidator

import java.util.*

object ParenthesisValidator {
    private val leftParenthesis = listOf('(', '{', '[')
    private val rightParenthesis = listOf(')', '}', ']')
    private val parenthesis = mapOf(
        Pair('(' , ')'),
        Pair('{' , '}'),
        Pair('[' , ']')
    )
    fun checkingParenthesis(content: String): Boolean {
        val parenthesisStack = Stack<Char>()

        content.toCharArray().forEach{ char: Char  ->
            if (leftParenthesis.contains(char)) {
                parenthesisStack.push(char)
            } else if (rightParenthesis.contains(char)) {
                if (parenthesisStack.isEmpty())
                    return false
                val firstParenthesis = parenthesisStack.pop()
                if (parenthesis[firstParenthesis]!! != char) {
                    return false
                }
            }
        }
        return parenthesisStack.isEmpty()
    }
}
