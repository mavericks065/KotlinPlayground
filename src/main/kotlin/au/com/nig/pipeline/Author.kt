package au.com.nig.pipeline

class Author(val name: String, val twitterHandle: String, val company: String) {
    companion object {
        fun twitterHandles(authors: Iterable<Author>, company: String): Iterable<String> {
            var result: MutableList<String> = mutableListOf()
            var iterableAuthors = authors
                .filter { it.company.equals(company) }
            for (a in iterableAuthors) {
                var handle = a.twitterHandle
                if (handle != null)
                    result.add(handle)
            }
            return result
        }
    }
}