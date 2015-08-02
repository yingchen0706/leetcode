class Solution {
public:
    int rob(vector<int>& nums) {
        int len = nums.size();
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }
        
        int max[len];
        max[0] = nums[0];
        max[1] = std::max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            max[i] = std::max(max[i-2] + nums[i], max[i-1]);
        }
        return max[len-1];
    }
};