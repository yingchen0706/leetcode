class Solution {
    public int trap(int[] height) {
        int sum = 0;
        
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    sum+= leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    sum+= rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        
        return sum;
    }
}
