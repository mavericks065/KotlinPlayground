package au.com.nig.pipeline

class Author(val name: String, val twitterHandle: String, val company: String) {
    companion object {
        fun twitterHandles(authors: Iterable<Author>, company: String): Iterable<String> {
            var result: MutableList<String> = mutableListOf()
            for (a in authors) {
                if (a.company == company) {
                    var handle = a.twitterHandle
                    if (handle != null)
                        result.add(handle)
                }
            }
            return result
        }
    }
}