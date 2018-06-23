class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums == null) {
            return null;
        }
        
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            
            
            for (List<Integer> oneSet : res) {
                tmp.add(new ArrayList(oneSet));
            }
            for (List<Integer> oneSet : tmp) {
                oneSet.add(nums[i]);
            }
            
            List<Integer> one = new ArrayList<>();
            one.add(nums[i]);
            tmp.add(one);
            
            res.addAll(tmp);
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
}
