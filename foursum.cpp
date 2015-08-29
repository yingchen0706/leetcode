class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> vRes;
        vector<int> list;
        sort(nums.begin(), nums.end());
        
        for (int i = 0, size = nums.size(); i < size - 3; i++) {
            int first = nums[i];
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target3 = target - first;
            for (int j = i + 1; j < size - 2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int second = nums[j];
                int target2 = target3 - second;
                int k = j + 1;
                int l = size - 1;
                while (k < l) {
                    int sum = nums[k] + nums[l];
                    if (sum == target2) {
                        list.clear();
                        list.push_back(first);
                        list.push_back(second);
                        list.push_back(nums[k]);
                        list.push_back(nums[l]);
                        vRes.push_back(list);
                        k++;
                        l--;
                        while(k < size && nums[k] == nums[k-1]) {
                            k++;
                        }
                        while(l > 0 && nums[l] == nums[l+1]) {
                            l--;
                        }
                    } else if (sum < target2) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return vRes;
    }
};