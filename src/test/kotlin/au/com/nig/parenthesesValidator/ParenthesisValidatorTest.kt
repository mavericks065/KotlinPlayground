package au.com.nig.parenthesesValidator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ParenthesisValidatorTest {
    @Test
    fun `given a string with opening and closing parenthesis in the right order it should return positive results`() {
        // Given
        val content0 = "word"
        val content1 = "(word)"
        val content2 = "(foo(bar))"
        val content3 = "()"
        val content4 = "({(word)})"

        // When
        val result0 = ParenthesisValidator.checkingParenthesis(content0)
        val result1 = ParenthesisValidator.checkingParenthesis(content1)
        val result2 = ParenthesisValidator.checkingParenthesis(content2)
        val result3 = ParenthesisValidator.checkingParenthesis(content3)
        val result4 = ParenthesisValidator.checkingParenthesis(content4)

        // Then
        assertTrue(result0)
        assertTrue(result1)
        assertTrue(result2)
        assertTrue(result3)
        assertTrue(result4)
    }

    @Test
    fun `given a string with opening and closing parenthesis not in opening or closing order it should return negative results`() {
        // Given
        val content0 = "(word"
        val content1 = "((word)"
        val content2 = "([]foo(bar)"
        val content3 = "{foo})("
        val content4 = ")(foo"

        // When
        val result0 = ParenthesisValidator.checkingParenthesis(content0)
        val result1 = ParenthesisValidator.checkingParenthesis(content1)
        val result2 = ParenthesisValidator.checkingParenthesis(content2)
        val result3 = ParenthesisValidator.checkingParenthesis(content3)
        val result4 = ParenthesisValidator.checkingParenthesis(content4)

        // Then
        assertFalse(result0)
        assertFalse(result1)
        assertFalse(result2)
        assertFalse(result3)
        assertFalse(result4)
    }
}
