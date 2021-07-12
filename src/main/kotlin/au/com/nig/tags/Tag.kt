package au.com.nig.tags

object Tag {
    fun getRelatedTag(stream: List<String>, tags: List<String>): Set<String> {
        return stream.map {
            val key = it
            val value = it.split("\\|".toRegex())[1].split(";")
            Pair(key, value)
        }
            .filter { it.second.containsAll(tags) }
            .flatMap { it.second }
            .toSet()
            .minus(tags)
    }
}
