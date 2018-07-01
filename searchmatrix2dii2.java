class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int r = 0, c = m - 1;
        while (r < n && c >=0) {
            int elem = matrix[r][c];
            if (target > elem) {
                r++;
            } else if (target < elem) {
                c--;
            } else {
                return true;
            }
        }
        return false;
    }
}
