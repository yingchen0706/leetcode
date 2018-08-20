class Solution {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int t1 = min*nums[i];
            int t2 = max*nums[i];
            max = Math.max(t1, t2) > 0 ? Math.max(t1, t2) : nums[i];
            min = Math.min(t1, t2) < 0 ? Math.min(t1, t2) : nums[i];
            res = Math.max(max, res);
        }
        return res;
    }
}
