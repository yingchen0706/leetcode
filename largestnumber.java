lclass Solution {
    public String largestNumber(int[] nums) {
        boolean nonZeroExist = false;
        
        List<String> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                nonZeroExist = true;
            }
            list.add((new Integer(nums[i])).toString());
        }
        if (!nonZeroExist) {
            return "0";
        }
        Collections.sort(list, new Sortbyroll());
        return String.join("", list);
    }
    
    static class Sortbyroll implements Comparator<String> 
    { 
        // Used for sorting in ascending order of 
        // roll number 
        public int compare(String a, String b) { 
            return compareSub(a, b, 0, 0); 
        } 
        private static int compareSub(String a, String b, int indexA, int indexB) {
            if (indexA==a.length() && indexB == b.length()) {
                return 0;
            }
            if (indexA == a.length()) {
                return compareSub(a, b, 0, indexB);
            }
            if (indexB == b.length()) {
                return compareSub(a, b, indexA, 0);
            }
            if (a.charAt(indexA) != b.charAt(indexB)) {
                return b.charAt(indexB) - a.charAt(indexA);
            }
            return compareSub(a, b, indexA+1, indexB+1);
        }
    } 
}
