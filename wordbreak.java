class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);
                if (res[j] && wordDict.contains(subStr)) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}
