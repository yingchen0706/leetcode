class Solution {
    public int coinChange(int[] coins, int amount) {
        int cache[] = new int[amount+1];
        Arrays.fill(cache, amount+1);
        cache[0] = 0;
        for (int sum = 1; sum <= amount; sum++) {
            for (int i = 0; i <coins.length; i++) {
                if (coins[i] <= sum) {
                    int left = sum - coins[i];
                    cache[sum] = Math.min(cache[sum],cache[left] + 1); 
                }
            }
        }
        return cache[amount] >=amount+2 ? -1:cache[amount];
    }
}
