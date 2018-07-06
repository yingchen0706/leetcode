class Solution {
    public List<List<String>> partition(String s) {
        return partition1(s, 0, s.length() -1);
    }
    public List<List<String>> partition1(String s, int start, int end) {
        List<List<String>> list = new ArrayList<>();
        if (end <start) {
            List<String> oneSolution = new ArrayList<>();
            list.add(oneSolution);
        } else {
            for (int i = start; i <= end; i++) {
                if (isPalindrom(s, start, i)) {            
                    List<List<String>> res = partition1(s, i+1, end);            
                    for (List<String> item: res) {
                        item.add(0, s.substring(start, i+1));
                        list.add(item);
                    }
                }
            }
        }
        return list;
    }
    
    private boolean isPalindrom(String s, int l, int r) {
        while (s.charAt(l) == s.charAt(r) && l < r) {
            l++;
            r--;
        }
        if (l >=r) {
            return true;
        } else {
            return false;
        }
    }
}
