class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinSub(coins, coins.length-1, amount);
    }
    
    private int coinSub(int[] coins, int end, int amount) {
        if (end <0) {
            return -1;
        }
        if (end == 0) {
            if (amount%coins[end] == 0) {
                return amount / coins[end];
            } else {
                return -1;
            }
        }
        int n = amount / coins[end];
        for (int i = n; i > 0;i--) {
            int left = amount -(coins[end]*i);
            if (left == 0) {
                return i;
            }
            int t = coinSub(coins, end -1, left);
            if (t>0) {
                return t+i;
            }
        }
        return coinSub(coins, end-1, amount);
    }
}
