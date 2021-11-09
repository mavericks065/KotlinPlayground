package au.com.nig.slidingsum

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SlidingSumTest {

    @Test
    fun `empty array should return an empty array`() {
        // GIVEN
        var array = emptyArray<Int>()

        // WHEN
        var result = SlidingSum.computeSlidingSum(array)

        // THEN
        Assertions.assertEquals(emptyArray<Int>(), result)
    }
}
