class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> prev = new ArrayList<>();
        Arrays.sort(nums);
        
        if (nums == null) {
            return null;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1] || prev.size() == 0) {
                prev = new ArrayList<>();
                for (List<Integer> oneSet : res) {
                    prev.add(new ArrayList<Integer>(oneSet));
                }
            }
            
            for (List<Integer> onePrev: prev) {
                onePrev.add(nums[i]);
            }
            
            if (i == 0 || nums[i] != nums[i-1]) {
                List<Integer> one = new ArrayList<>();
                one.add(nums[i]);
                prev.add(one);
            }
            
            for (List<Integer> temp : prev) {
			    res.add(new ArrayList<Integer>(temp));
		    }
            
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
}
