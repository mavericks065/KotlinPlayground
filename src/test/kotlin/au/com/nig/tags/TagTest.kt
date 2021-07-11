package au.com.nig.tags

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TagTest {

    private val dataSample = listOf(
        "metric.name=1|host:hostA;role:web;availability-zone:ap-south-east-2a",
        "metric.name=1|host:hostB;role:db;availability-zone:ap-south-east-2a",
        "metric.name=1|host:hostC;role:db;availability-zone:ap-south-east-2b",
        "metric.name=1|host:hostD;role:db;availability-zone:ap-south-east-2b"
    )
    @Test
    fun `for one tag it should return the list of metrics associated with it`() {
        // Given
        val tagsToFind = listOf("host:hostA")
        val expectedFoundTags = listOf("role:web", "availability-zone:ap-south-east-2a")

        // when
        val result = Tag.getRelatedTag(dataSample, tagsToFind)

        // Then
        assertEquals(expectedFoundTags, result)
    }
}

