package au.com.nig.pipeline

class Author(val name: String, val twitterHandle: String, val company: String) {
    companion object {
        fun twitterHandles(authors: Iterable<Author>, company: String): Iterable<String> {
            var result: MutableList<String> = mutableListOf()
            var iterableHandles: List<String> = authors
                .filter { it.company.equals(company) }
                .filter { it.twitterHandle != null }
                .map { it.twitterHandle }
            for (handle in iterableHandles) {
                result.add(handle)
            }
            return result
        }
    }
}