class Solution {
    public int[] searchRange(int[] nums, int target) {
        return innerSearch(nums, 0, nums.length -1, target);
    }
    
    private int[] innerSearch(int[] nums, int left, int right, int target) {
        if (left>right) {
            return new int[]{-1, -1};
        }
        int mid = left + (right-left)/2;
        if (target>nums[mid]) {
            return innerSearch(nums, mid+1, right, target);
        } else if (target<nums[mid]) {
            return innerSearch(nums, left, mid-1, target);
        } else {
            //target = mid;
            int i = mid-1;
            while (i>=0 && nums[i] == target) {
                i--;
            }
            int L = ++i;
            int j = mid + 1;
            while (j<=nums.length -1 && nums[j] == target) {
                j++;
            }
            int R = --j;
            return new int[]{i, j};
        }
    }
}
