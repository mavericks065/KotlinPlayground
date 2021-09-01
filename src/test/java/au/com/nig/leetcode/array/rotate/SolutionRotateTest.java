package au.com.nig.leetcode.array.rotate;

import au.com.nig.leetcode.array.rotation.SolutionRotate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionRotateTest {
    @Test
    public void test_simple_case(){
        // Given
        int [] input = {-1,-100,3,99};
        int slide = 2;
        SolutionRotate solution = new SolutionRotate();
        int[] expectedSolution = {3,99,-1,-100};
        // When
        solution.rotate(input, slide);

        // Then
        for (int i = 0; i< input.length; i++)
            Assertions.assertEquals(expectedSolution[i], input[i]);
    }

    @Test
    public void test_simple_case_2(){
        // Given
        int [] input = {1,2,3,4,5,6,7};
        int slide = 3;
        SolutionRotate solution = new SolutionRotate();
        int[] expectedSolution = {5,6,7,1,2,3,4};
        // When
        solution.rotate(input, slide);

        // Then
        for (int i = 0; i< input.length; i++)
            Assertions.assertEquals(expectedSolution[i], input[i]);
    }

    @Test
    public void test_edge_case(){
        // Given
        int [] input = {-1};
        int slide = 2;
        SolutionRotate solution = new SolutionRotate();
        int[] expectedSolution = {-1};
        // When
        solution.rotate(input, slide);

        // Then
        for (int i = 0; i< input.length; i++)
            Assertions.assertEquals(expectedSolution[i], input[i]);
    }
}
