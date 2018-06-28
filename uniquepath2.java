class Solution {
    public int uniquePaths(int m, int n) {
        int[] pre = new int[m];
        int[] cur = new int[m];
        for (int i = 0; i < m; i++) {
            pre[i] = 1;
            cur[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                cur[j] += cur[j-1];
            }
        }
        return cur[m-1];
    }
}
