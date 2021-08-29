package au.com.nig.leetcode.twoSumIntToRomanMyAtoi;

import java.util.*;

public class Solution {
    private static final Map<Integer, String> symbolToValue = new HashMap<>();

    static {
        symbolToValue.put(1000, "M");
        symbolToValue.put(900, "CM");
        symbolToValue.put(500, "D");
        symbolToValue.put(400, "CD");
        symbolToValue.put(100, "C");
        symbolToValue.put(90, "XC");
        symbolToValue.put(50, "L");
        symbolToValue.put(40, "XL");
        symbolToValue.put(10, "X");
        symbolToValue.put(9, "IX");
        symbolToValue.put(8, "VIII");
        symbolToValue.put(7, "VII");
        symbolToValue.put(6, "VI");
        symbolToValue.put(5, "V");
        symbolToValue.put(4, "IV");
        symbolToValue.put(3, "III");
        symbolToValue.put(2, "II");
        symbolToValue.put(1, "I");
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

    public String intToRoman(int num) {
        final StringBuffer buf = new StringBuffer("");
        int leftOverNum = num;
        List<Integer> keys = new ArrayList<>(symbolToValue.keySet());
        keys.sort(Collections.reverseOrder());
        for (Integer e : keys) {
            while (leftOverNum - e >= 0) {
                leftOverNum -= e;
                buf.append(symbolToValue.get(e));
            }
        }

        return buf.toString();
    }

    private StringBuffer incrementFrom1To39(StringBuffer buf, int leftOverNum) {
        if (leftOverNum - 9 == 0) {
            buf.append("IX");
            leftOverNum -= 9;
        } else if (leftOverNum - 10 >= 0) {
            buf.append("X");
            leftOverNum -= 10;
            if (leftOverNum - 9 == 0) {
                buf.append("IX");
                leftOverNum -= 9;
            } else if (leftOverNum - 10 >= 0) {
                buf.append("X");
                leftOverNum -= 10;
                if (leftOverNum - 9 == 0) {
                    buf.append("IX");
                    leftOverNum -= 9;
                } else if (leftOverNum - 10 >= 0) {
                    buf.append("X");
                    leftOverNum -= 10;
                }
            }
            if (leftOverNum >= 4) {
                Map<Integer, StringBuffer> incr = incrementFrom4To8(buf, leftOverNum);
                leftOverNum = incr.keySet().stream().findFirst().get();
                buf = incr.values().stream().findFirst().get();
            }

            if (leftOverNum > 0 && leftOverNum < 4 && leftOverNum - 1 > 0) {
                buf.append("I");
                leftOverNum -= 1;
                if (leftOverNum - 1 > 0) {
                    buf.append("I");
                    leftOverNum -= 1;
                    if (leftOverNum - 1 >= 0) {
                        buf.append("I");
                        leftOverNum -= 1;
                    }
                }
            }
        }
        Map<Integer, StringBuffer> incr = incrementFrom4To8(buf, leftOverNum);
        leftOverNum = incr.keySet().stream().findFirst().get();
        buf = incr.values().stream().findFirst().get();
        return buf;
    }

    private Map<Integer, StringBuffer> incrementFrom4To8(StringBuffer buf, int leftOverNum) {
        if (leftOverNum - 4 == 0) {
            buf.append("IV");
            leftOverNum -= 4;
            return Map.of(leftOverNum, buf);
        }
        if (leftOverNum - 5 >= 0) {
            buf.append("V");
            leftOverNum -= 5;
            if (leftOverNum - 1 > 0) {
                buf.append("I");
                leftOverNum -= 1;
                if (leftOverNum - 1 > 0) {
                    buf.append("I");
                    leftOverNum -= 1;
                    if (leftOverNum - 1 >= 0) {
                        buf.append("I");
                        leftOverNum -= 1;
                    }
                }
            }
        }
        if (leftOverNum - 1 == 0) {
            buf.append("I");
            leftOverNum -= 1;
        } else if (leftOverNum - 1 > 0) {
            buf.append("I");
            leftOverNum -= 1;
            if (leftOverNum - 1 >= 0) {
                buf.append("I");
                leftOverNum -= 1;
                if (leftOverNum - 1 >= 0) {
                    buf.append("I");
                    leftOverNum -= 1;
                }
            }
        }
        return Map.of(leftOverNum, buf);
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

        while(iterationStart < s.length() && s.charAt(iterationStart) == '0') iterationStart++;

        long result = 0;

        for (int i = iterationStart; i < lengthOfInput; i++) {
            if (!Character.isDigit(s.charAt(i)))
                break;
            result = result * 10 + (s.charAt(i) - '0');

            if( result * isPositive >= Integer.MAX_VALUE || result * isPositive <= Integer.MIN_VALUE ) {
                return isPositive > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return (int) result * isPositive;
    }
}
