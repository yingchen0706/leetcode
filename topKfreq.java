class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Integer>[] list = new List[nums.length];
        Set<Map.Entry<Integer, Integer>> entrySet = freqMap.entrySet();
        for (Map.Entry<Integer, Integer> item: entrySet) {
            int num = item.getKey();
            int freq = item.getValue() - 1;
            if (list[freq] == null) {
                list[freq] = new LinkedList<Integer>();
            }
            list[freq].add(num);

        }
        List<Integer> res = new LinkedList<>();
        for (int i = nums.length - 1; i>=0 && res.size() < k; i--) {
            if (list[i] !=null) {
                for(Integer num: list[i]){
                    if (res.size() <k) {
                        res.add(num);
                    }
                }
            }
        }
        return res;
    }
}
