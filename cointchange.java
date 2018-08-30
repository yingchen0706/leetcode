class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChangeSub(coins, amount, new int[amount+1]);
    }
    
    public int coinChangeSub(int[] coins, int amount, int[] map) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int res = map[amount];
        if (res != 0) {
            return res;
        }
        int min = Integer.MAX_VALUE;
        int len = coins.length;
        for(int i = 0; i < len; i++) {
            int left = amount - coins[i];
            int sub = coinChangeSub(coins, left, map);
            if (sub != -1) {
                min = Math.min(min, sub + 1);
            }
        }
        min = (min == Integer.MAX_VALUE ? -1 : min);
        map[amount] = min;
        return min;
    }
}
