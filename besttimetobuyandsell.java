class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            int elem = prices[i];
            min = Math.min(min, elem);
            max = Math.max(max, elem - min);
        }
        return max;
    }
}
