package au.com.nig.leetcode.twoSumIntToRomanMyAtoi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void solution_first_test() {
        // Given
        int[] input = new int[]{3, 2, 4};
        int target = 6;
        int[] expected = new int[]{1, 2};
        Solution sol = new Solution();
        // When
        int[] result = sol.twoSum(input, target);

        // Then
        Assertions.assertEquals(expected[0], result[0]);
        Assertions.assertEquals(expected[1], result[1]);
    }

    @Test
    public void test_myAtoi() {
        // Given
        String input = "  -0012a42";
        Solution solution = new Solution();

        // When
        int result = solution.myAtoi(input);

        // Then
        Assertions.assertEquals(-12, result);
    }

    @Test
    public void test_myAtoi_1() {
        // Given
        String input = "42";
        Solution solution = new Solution();

        // When
        int result = solution.myAtoi(input);

        // Then
        Assertions.assertEquals(-42, result);
    }

    @Test
    public void test_myAtoi_2() {
        // Given
        String input = "4193 with words";
        Solution solution = new Solution();

        // When
        int result = solution.myAtoi(input);

        // Then
        Assertions.assertEquals(4193, result);
    }

    @Test
    public void test_myAtoi_3() {
        // Given
        String input = "words and 987";
        Solution solution = new Solution();

        // When
        int result = solution.myAtoi(input);

        // Then
        Assertions.assertEquals(0, result);
    }

}
