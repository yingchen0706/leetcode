class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> vRes;
        map<int, int> hash;
        for (int i = 0, size = nums.size(); i < size; i++) {
            int a = nums[i];
            int b = target - a;
            auto it = hash.find(b);
            if (it != hash.end()) {
                vRes.push_back(it->second+1);
                vRes.push_back(i+1);
                return vRes;
            } else {
                hash[a] = i;
            }
        }
        return vRes;
    }
};