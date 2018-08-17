class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;
        int loop = (Math.min(m, n)+1)/2;
        for (int offset = 0; offset < loop; offset++) {
            int i = offset;
            int j = offset;
            for (; j < n - offset; j++) {
                res.add(matrix[i][j]);
            }
            i++;
            j--;
            if (i>=m-offset) {
                break;
            }
            for (;i < m-offset; i++) {
                res.add(matrix[i][j]);
            }
            j--;
            i--;
            if (j<offset) {
                break;
            }
            for (;j>=offset; j--) {
                res.add(matrix[i][j]);
            }
            i--;
            j++;
            if (i<=offset) {
                break;
            }
            for (;i>offset;i--) {
                res.add(matrix[i][j]);
            }
        } 
        return res;
    }
}
