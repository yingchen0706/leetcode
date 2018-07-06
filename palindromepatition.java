class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        if (s.length() <= 1) {
            List<String> oneSolution = new ArrayList<>();
            if (s.length() > 0) {
                oneSolution.add(s);
            }
            list.add(oneSolution);
        } else {
            for (int i = 1; i <= s.length(); i++) {
                String subString = s.substring(0, i);
                if (isPalindrom(subString)) {
                    
                    List<List<String>> res = partition(s.substring(i));
                    
                    for (List<String> item: res) {
                        item.add(0, subString);
                        list.add(item);
                    }
                }
            }
        }
        return list;
    }
    
    private boolean isPalindrom(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
