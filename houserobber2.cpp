class Solution {
public:
    int robChoose0(vector<int>& nums) {
        int len = nums.size();
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }
        
        int max[len];
        max[0] = nums[0];
        max[1] = nums[0];
        for (int i = 2; i < len; i++) {
            if (i < len-1) {
                max[i] = std::max(max[i-2] + nums[i], max[i-1]);
            } else {
                max[i] = std::max(max[i-2], max[i-1]);
            }
        }
        return max[len-1];
    }
    int robNoChoose0(vector<int>& nums) {
        int len = nums.size();
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }
        
        int max[len];
        max[0] = 0;
        max[1] = nums[1];
        for (int i = 2; i < len; i++) {
            max[i] = std::max(max[i-2] + nums[i], max[i-1]);
        }
        return max[len-1];
    }
    int rob(vector<int>& nums) {
        return std::max(robChoose0(nums), robNoChoose0(nums));
    }
};