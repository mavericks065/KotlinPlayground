package au.com.nig.leetcode.climbingstairs;

import java.util.HashMap;
import java.util.Map;

public class SolutionClimbingStairs {
    private Map<Integer, Integer> stairsCache = new HashMap();

    public int climbStairs(int n) {
        if (stairsCache.get(n) != null) {
            return stairsCache.get(n);
        } else {
            if (n <= 3) {
                stairsCache.put(n, n);
                return n;
            } else {
                int result = climbStairs(n-1) + climbStairs(n-2);
                stairsCache.put(n, result);
                return result;
            }
        }
    }
}

/*
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 INPUT
 2
 12

 OUTPUT
 2
 233

 time: O(N)
 space: O(N)
 */
