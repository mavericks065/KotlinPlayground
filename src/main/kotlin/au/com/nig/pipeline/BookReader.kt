package au.com.nig.pipeline

import java.util.*
import kotlin.collections.HashSet

class BookReader(private val dataService: DataService) {

    fun getReadersOfBooks(readers: Collection<String>, books: Collection<String>, date: Date): Set<String> {
        val result: MutableSet<String> = HashSet()
        val data: Map<String, Collection<String>> = dataService.getBooksReadOn(date)
        for (e in data.entries) {
            for (bookId in books) {
                if (e.value.contains(bookId) && readers.contains(e.key)) {
                    result.add(e.key)
                }
            }
        }
        return result
    }
}