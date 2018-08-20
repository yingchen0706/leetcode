class Solution {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int t1 = min*nums[i];
            int t2 = max*nums[i];
            int tmax = Math.max(t1, t2);
            int tmin = Math.min(t1, t2); 
            max =  tmax > 0 ? tmax : nums[i];
            min = tmin < 0 ? tmin : nums[i];
            res = Math.max(max, res);
        }
        return res;
    }
}
