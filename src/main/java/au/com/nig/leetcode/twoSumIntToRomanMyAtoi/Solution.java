package au.com.nig.leetcode.twoSumIntToRomanMyAtoi;

import java.util.*;

public class Solution {

    private final int[] intValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private final String[] strValues = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

    public String intToRoman(int num) {
        final StringBuffer buf = new StringBuffer("");
        int leftOverNum = num;
        for (int i = 0; i < intValues.length; i++) {
            int e = intValues[i];
            while (leftOverNum - e >= 0) {
                leftOverNum -= e;
                buf.append(strValues[i]);
            }
        }
        return buf.toString();
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            int newTarget = target - nums[i];
            if (numMap.containsKey(newTarget)) {
                return new int[]{
                        numMap.get(newTarget),
                        i
                };
            }
            numMap.put(nums[i], i);
        }
        return null;
    }

    public int myAtoi(String s) {
        if (s.isBlank() || s.length() > 200)
            return 0;

        int lengthOfInput = s.length();
        int isPositive = 1;
        int iterationStart = 0;

        while (iterationStart < lengthOfInput && s.charAt(iterationStart) == ' ') iterationStart++;

        if (s.charAt(iterationStart) == '-' || s.charAt(iterationStart) == '+') {
            isPositive = s.charAt(iterationStart) != '-' ? 1 : -1;
            iterationStart++;
            if (iterationStart > lengthOfInput) return 0;
        }

        while (iterationStart < s.length() && s.charAt(iterationStart) == '0') iterationStart++;

        long result = 0;

        for (int i = iterationStart; i < lengthOfInput; i++) {
            if (!Character.isDigit(s.charAt(i)))
                break;
            result = result * 10 + (s.charAt(i) - '0');

            if (result * isPositive >= Integer.MAX_VALUE || result * isPositive <= Integer.MIN_VALUE) {
                return isPositive > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return (int) result * isPositive;
    }
}
