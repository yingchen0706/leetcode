class Solution {
    public List < Integer > spiralOrder(int[][] matrix) {
       List<Integer> res = new LinkedList<>();
        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;
        int[] offseti = {0, 1, 0, -1};
        int[] offsetj = {1, 0, -1, 0};
        int i = 0, j = 0, offsetIndex = 0;
        boolean visited[][] = new boolean[m][n];
        for (int cnt = 0; cnt < m*n; cnt++) {
            res.add(matrix[i][j]);
            visited[i][j] = true;
            int i1 = i + offseti[offsetIndex];
            int j1 = j + offsetj[offsetIndex];
            if (i1 >=0 && i1 <m && j1>=0 && j1<n && !visited[i1][j1]) {
                i = i1;
                j = j1;
            } else {
                offsetIndex = (offsetIndex+1)%4;
                i = i + offseti[offsetIndex];
                j = j + offsetj[offsetIndex];
            }
        }
        
        return res;
    }
}
