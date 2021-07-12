package au.com.nig.pipeline

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AuthorTest {
    @Test
    fun `make sure it still works`() {
        // Given
        val a0 = Author("nig", "stuff", "comp1")
        val a1 = Author("apha", "stiff", "comp1")
        val a2 = Author("npa", "blah", "comp2")
        val a3 = Author("npa", null, "comp2")
        val authors = listOf(a0, a1, a2, a3)
        val expectedResults = listOf("stuff", "stiff")

        // When
        val result = Author.twitterHandles(authors, "comp1")

        // Then
        assertEquals(expectedResults, result)
    }
}
