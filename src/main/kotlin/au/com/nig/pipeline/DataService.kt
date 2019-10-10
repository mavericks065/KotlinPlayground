package au.com.nig.pipeline

import java.util.*

interface DataService {
    fun getBooksReadOn(date: Date): Map<String, Collection<String>>
}