class Solution {
    private static int min(int a, int b, int c) {
        return a > b ? (b>c ? c: b) : (a > c ? c: a);
    }
    public int[][] updateMatrix(int[][] matrix) {
        
        if (matrix == null) {
            return matrix;
        } 
        
        int m = matrix[0].length;
        int n = matrix.length;
        int[][] res = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = 101;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int left = 101;
                int top = 101;
                if (i > 0) {
                    top = res[i-1][j];
                }
                if (j > 0) {
                    left = res[i][j-1];
                }
                res[i][j] = min(res[i][j], left + 1, top + 1);
            }
        }
        
        for (int i = n-1; i >=0; i--) {
            for (int j = m-1; j >=0; j--) {
                int bottom = 101;
                int right = 101;
                if (i < n-1) {
                    bottom = res[i+1][j];
                }
                if (j <m-1) {
                    right = res[i][j+1];
                }
                res[i][j] = min(res[i][j], bottom + 1, right + 1);
            }
        }
        
        return res;
    }
}
