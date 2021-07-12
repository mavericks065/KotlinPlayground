package au.com.nig.pipeline

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

internal class BookReaderTest {
    @Test
    fun `should return the readers of the book for a given day`() {
        // Given
        val dataService = object : DataService {
            override fun getBooksReadOn(date: Date): Map<String, Collection<String>> {
                return mapOf(
                    Pair("nig", listOf("mastery", "the goal")),
                    Pair("npa", listOf("sociocracy 3.0")),
                    Pair("won", listOf("the web killers", "freedom inck"))
                )
            }
        }
        val readers = listOf("lygi", "won", "npa")
        val books = listOf("freedom inck", "sociocracy 3.0")
        val bookReader = BookReader(dataService)

        // When
        val result = bookReader.getReadersOfBooks(readers, books, Date())

        // Then
        assertEquals(setOf("won", "npa"), result)

    }
}