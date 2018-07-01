class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int[] index = new int[matrix.length];
        int m = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            index[i] = 0;
        }
        boolean mark = false;
        while (true) {
            mark = false;
            for (int i = 0; i < index.length; i++) {
                if (index[i] >=0) {
                    mark = true;
                    if (matrix[i][index[i]] < target && index[i] <= m-2) {
                        index[i]++;
                    } else if (matrix[i][index[i]] == target) {
                        return true;
                    } else {
                        index[i] = -1;
                    }
                }
            }
            if (mark == false) {
                return false;
            }
        }
    }
}
