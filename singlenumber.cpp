class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int size = nums.size();
        if (size == 0) {
            return 0;
        }
        int a = nums[0];
        for (int i = 1; i < size; i++) {
            a = a ^ nums[i];
        }
        return a;
    }
};