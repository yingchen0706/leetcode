class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        int size = nums.size();
        if (size < 3) {
            return res;
        }
        sort(nums.begin(), nums.end());
        for (int i = 0; i < size-2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int first = nums[i];
                int left = -first;
                int lower = i + 1;
                int upper = size - 1;
                while (lower < upper) {
                    int sum = nums[lower] + nums[upper];
                    if (sum == left) {
                        vector<int> vec;
                        vec.push_back(first);
                        vec.push_back(nums[lower]);
                        vec.push_back(nums[upper]);
                        res.push_back(vec);
                        lower++;
                        upper--;
                        while(nums[lower] == nums[lower-1]) {
                            lower++;
                        }
                        while(nums[upper] == nums[upper+1]) {
                            upper--;
                        }
                    } else if (sum < left) {
                        lower++;
                    } else {
                        upper--;
                    }
                }
            }
        }
        return res;
    }
};