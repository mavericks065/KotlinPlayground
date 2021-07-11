package au.com.nig.tags

object Tag {
    fun getRelatedTag(stream: List<String>, tags: List<String>): List<String> {
        val resultTags = stream.map {
            val key = it
            val value = it.split("\\|".toRegex()).get(1).split(";")
            Pair(key, value)
        }
            .toMap()
            .filterValues { it.containsAll(tags) }
            .values
            .flatten()
            .minus(tags)

        return resultTags
    }
}
