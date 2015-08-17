class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> vRes;
        multimap<int, int> hash;
        for (int i = 0, size = nums.size(); i < size; i++) {
            hash.insert(pair<int, int>(nums[i], i));
        }
        for (auto it = hash.begin(), end = hash.end(); it != end; it++) {
            int a = it->first;
            int b = target - a;
            auto range = hash.equal_range(b);
            for (auto it2 = range.first, end = range.second; it2 != end; it2++) {
                if (it2 != it) {
                    if (it->second < it2->second) {
                        vRes.push_back(it->second + 1);
                        vRes.push_back(it2->second + 1);
                    } else {
                        vRes.push_back(it2->second + 1);
                        vRes.push_back(it->second + 1);
                    }
                    return vRes;
                }
            }
        }
    }
};