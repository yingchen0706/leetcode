class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i = 0;  i < nums.length; i++) {
            int val = nums[i];
            if (val <= min) {
                min = val;
            } else if (val <= secondMin) {
                secondMin = val;
            } else {
                return true;
            }
        }
        return false;
    }
    
   
}
