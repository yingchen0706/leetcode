class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<Integer>();
        for (int i: nums) {
            if (unique.contains(i)) {
                return i;
            } else {
                unique.add(i);
            }
        }
        return -1;
    }
}
