class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        boolean[] hit = new boolean[nums.length];
        Arrays.fill(hit, false);
        hit[0] = true;
        
        for (int i = 0; i < nums.length; i++) {
            if (hit[i] == false) {
                continue;
            }
            if (i == nums.length - 1) {
                return true;
            }
            int jump = nums[i];
            for (int j = 1; j <= jump; j++) {
                if (i+j > nums.length-1) {
                    break;
                }
                hit[i+j] = true;
                if (i+j == nums.length-1) {
                    return true;
                }
            }
        }
        return false;
    }
}
