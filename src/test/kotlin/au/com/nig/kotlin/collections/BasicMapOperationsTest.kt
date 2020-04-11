package au.com.nig.kotlin.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BasicMapOperationsTest {
    @Test
    fun `should return non-null element values and odd elements of the keys of the map and transofmr in upper case the values of each pair`() {
        // GIVEN
        val myMap = mapOf(
            Pair(12, "twelve"),
            Pair(13, "thirsteen"),
            Pair(20, "twentieth"),
            Pair(2, "second"),
            Pair(35, null)
        )
        // WHEN
        val result = BasicMapOperations.filterOnKeysAndValuesAndToUpperCaseValues(myMap)

        // THEN
        assertEquals(mapOf(Pair(13, "THIRSTEEN")), result)
    }

    @Test
    fun `should insert elements and remove others`() {
        // GIVEN
        val myMap = mutableMapOf(
            Pair(12, "twelve"),
            Pair(13, "thirsteen"),
            Pair(20, "twentieth"),
            Pair(2, "second")
        )
        // WHEN
        val result = BasicMapOperations.addElementsToMutableMap(myMap, Pair(3, "third"))

        // THEN
        assertEquals(
            mapOf(
                Pair(12, "twelve"),
                Pair(13, "thirsteen"),
                Pair(20, "twentieth"),
                Pair(2, "second"),
                Pair(3, "third")
            ), result
        )

        // WHEN
        // remove third element of the map
        val result1 = BasicMapOperations.removeElementsFromMutableMap(myMap, 20)

        // THEN
        assertEquals(
            mapOf(
                Pair(12, "twelve"),
                Pair(13, "thirsteen"),
                Pair(2, "second"),
                Pair(3, "third")
            ),
            result1
        )

        // WHEN
        // set pair with key 3 to value = fourth
        val result2 = BasicMapOperations.setValue(myMap, 3, "fourth")

        // THEN

        assertEquals(
            mapOf(
                Pair(12, "twelve"),
                Pair(13, "thirsteen"),
                Pair(2, "second"),
                Pair(3, "fourth")
            ),
            result2
        )
    }


    @Test
    fun `should insert elements to non-mutable map`() {
        // GIVEN
        val myMap = mapOf(
            Pair(12, "twelve"),
            Pair(13, "thirsteen"),
            Pair(20, "twentieth"),
            Pair(2, "second")
        )
        // WHEN
        val result = BasicMapOperations.addElementsToMap(myMap, Pair(3, "third"))

        // THEN
        assertEquals(
            mapOf(
                Pair(12, "twelve"),
                Pair(13, "thirsteen"),
                Pair(20, "twentieth"),
                Pair(2, "second"),
                Pair(3, "third")
            ),
            result
        )
    }

    @Test
    fun `should return a list of characters of the values`() {
        // GIVEN
        val myMap = mapOf(
            Pair(12, "twelve"),
            Pair(2, "second")
        )
        // WHEN
        val result = BasicMapOperations.getCharacters(myMap)

        // THEN
        assertEquals(
            listOf('t', 'w', 'e', 'l', 'v', 'e', 's', 'e', 'c', 'o', 'n', 'd'),
            result
        )
    }



    @Test
    fun `should return the leys and the values`() {
        // GIVEN
        val myMap = mapOf(
            Pair(12, "twelve"),
            Pair(2, "second")
        )
        // WHEN
        val result = BasicMapOperations.getKeys(myMap)
        val result1 = BasicMapOperations.getValues(myMap)

        // THEN
        assertEquals(
            listOf(12, 2),
            result
        )
        assertEquals(
            listOf("twelve", "second"),
            result1
        )
    }


}