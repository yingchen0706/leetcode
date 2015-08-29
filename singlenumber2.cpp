class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for (int i = 0, size = nums.size(); i < size; i++) {
            int a = nums[i];
            twos |= ones & a;
            ones = ones ^ a;
            threes = ones & twos;
            ones = ones & (~threes);
            twos = twos & (~threes);
        }
        return ones;
    }
};