package au.com.nig.pipeline

import java.util.*

class BookReader(private val dataService: DataService) {

    fun getReadersOfBooks(readers: Collection<String>, books: Collection<String>, date: Date): Set<String> {
        val data: Map<String, Collection<String>> = dataService.getBooksReadOn(date)
        return data.entries
            .filter { readers.contains(it.key) }
            .filter { books.intersect(it.value).isNotEmpty() }
            .map { it.key }
            .toHashSet()

    }
}