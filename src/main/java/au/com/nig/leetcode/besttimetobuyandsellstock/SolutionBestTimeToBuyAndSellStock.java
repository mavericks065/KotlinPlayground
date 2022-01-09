package au.com.nig.leetcode.besttimetobuyandsellstock;

public class SolutionBestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maximizedMargin = 0;
        for(int i = 1; i <= prices.length - 1; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            } else if (prices[i] - lowestPrice > maximizedMargin) {
                maximizedMargin = prices[i] - lowestPrice;
            }
        }
        return maximizedMargin;
    }
}

/*
INPUT
[7,1,5,3,6,4]
[1,2]
OUTPUT
5
1
O(N) time
O(1) space
 */
