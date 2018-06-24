class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] posArr = new int[n];
        int row = 0;
        while (k > 0) {
            row = findMin(matrix, posArr);
            posArr[row] = posArr[row]+1;
            k--;
        }
        return matrix[row][--posArr[row]];
    }
    
    private int findMin(int[][] matrix, int[] posArr) {
        int min = Integer.MAX_VALUE;
        int minRow = -1;
        int minCol = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (posArr[i] < matrix.length && matrix[i][posArr[i]] < min) {
                min = matrix[i][posArr[i]];
                minRow = i;
            } 
        }
        return minRow;
    }
}
