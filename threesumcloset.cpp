class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int min = INT_MAX;
        int best = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0, size = nums.size(); i < size-2; i++) {
            int first = nums[i];
            int j = i + 1;
            int k = size - 1;
            while (j < k) {
                int sum = first + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } 
                int diff = abs(target - sum);
                if (diff < min) {
                    min = diff;
                    best = sum;
                }
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return best;
    }
};