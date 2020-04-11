package au.com.nig.kotlin.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicListOperationsTest {
    @Test
    fun `should transform a list of integer in strings`() {
        // GIVEN
        val myList = listOf(1, 2, 3, 4, 5, 6, 8, 9)

        // WHEN
        val result = BasicListOperations.transformIntInStrings(myList)

        // THEN
        assertEquals(listOf("1", "2", "3", "4", "5", "6", "8", "9"), result)
    }

    @Test
    fun `should keep only even numbers`() {
        // GIVEN
        val myList = listOf(1, 2, 3, 4, 5, 6, 8, 9)

        // WHEN
        val result = BasicListOperations.keepOnlyEvenNumbers(myList)

        // THEN
        assertEquals(listOf(2, 4, 6, 8), result)
    }

    @Test
    fun `should transform in list of characters`() {
        // GIVEN
        val myList = listOf("Hello", "world")

        // WHEN
        val result = BasicListOperations.transformInListOfChars(myList)

        // THEN
        assertEquals(listOf('H', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd'), result)
    }

    @Test
    fun `should keep only non nulls numbers`() {
        // GIVEN
        val myList = listOf(null, 2, null, 4)

        // WHEN
        val result = BasicListOperations.keepOnlyNonNullNumbers(myList)

        // THEN
        assertEquals(listOf(2, 4), result)
    }

    @Test
    fun `should sum all numbers first way`() {
        // GIVEN
        val myList = listOf(2, 4, 5)

        // WHEN
        val result = BasicListOperations.sumNumbers1(myList)

        // THEN
        assertEquals(11, result)
    }

    @Test
    fun `should sum all numbers second way`() {
        // GIVEN
        val myList = listOf(2, 4, 5)

        // WHEN
        val result = BasicListOperations.sumNumbers2(myList)

        // THEN
        assertEquals(11, result)
    }

    @Test
    fun `should return an element`() {
        // GIVEN
        val myList = listOf(8, 2, 4, 5)

        // WHEN
        val result0 = BasicListOperations.getLastNumber(myList)
        val result1 = BasicListOperations.getFirstNumber(myList)
        val result2 = BasicListOperations.getNumber(myList, 1)

        // THEN
        assertEquals(5, result0)
        assertEquals(8, result1)
        assertEquals(2, result2)
    }

    @Test
    fun `should add and remove elements from a list`() {
        // GIVEN
        val myList = listOf(8, 2, 4, 5)
        val expectedList = listOf(8, 4, 5, 10)

        // WHEN
        val result = BasicListOperations.modify(myList)

        // THEN
        assertEquals(expectedList, result)
    }
}