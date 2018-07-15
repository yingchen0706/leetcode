class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1 ;
        
        if (left>right) {
            return false;
        }
        while (left <=right) {
            int mid = (right - left)/2 + left;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[mid] < nums[right] || nums[mid] < nums[left]) { //right in order
                if (target > nums[mid] && target <= nums[right]) {
                    left  = mid +1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[left] || nums[mid] > nums[right]){
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }
        }
        return false;

    }
}
