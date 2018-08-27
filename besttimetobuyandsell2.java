class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            int elem = prices[i];
            if (elem <= min) {
                min = elem;
            } else {
                if (i < len - 1 && elem > prices[i+1]) {
                    sum += elem - min;
                    min = Integer.MAX_VALUE;
                } else if (i == len - 1) {
                    sum += elem - min;
                }
            }
        }
        
        return sum;
    }
}
