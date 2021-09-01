package au.com.nig.leetcode.array.rotation;

public class SolutionRotate {
    public void rotate(int[] nums, int k) {
        int originalLength = nums.length;
        int[] temp = new int[originalLength];

        for (int i = 0; i < originalLength; i++) {
            temp[(i + k) % originalLength] = nums[i];
        }

        for (int i = 0; i < originalLength; i++) {
            nums[i] = temp[i];
        }
    }
}
