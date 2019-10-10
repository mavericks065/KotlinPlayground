package au.com.nig.pipeline

import java.util.*
import kotlin.collections.HashSet

class BookReader(private val dataService: DataService) {

    fun getReadersOfBooks(readers: Collection<String>, books: Collection<String>, date: Date): Set<String> {
        val result: MutableSet<String> = HashSet()
        val data: Map<String, Collection<String>> = dataService.getBooksReadOn(date)
        val entries = data.entries
            .filter { readers.contains(it.key) }
            .filter { books.intersect(it.value).isNotEmpty() }
            .toHashSet()
        for (e in entries) {
            for (bookId in books) {
                result.add(e.key)
            }
        }
        return result
    }
}