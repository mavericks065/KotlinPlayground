package au.com.nig.pipeline

class Author(val name: String, val twitterHandle: String?, val company: String) {
    companion object {
        fun twitterHandles(authors: Iterable<Author>, company: String): Iterable<String> {
            return authors
                .filter { it.company == company }
                .map { it.twitterHandle }
                .filterNotNull()
        }
    }
}