

class Solution {
    class Index {
        public int x;
        public int y;
        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
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
        int MAX_INT = 101;
        
        Queue<Index> queue = new LinkedList<Index>();
        
        for (int i=0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    queue.add(new Index(i, j));
                } else {
                    res[i][j] = MAX_INT;
                }
            }
        }
        int[][] directions = {{-1, 0},{1, 0},{0, -1},{0, 1}};
            
        while (null != queue.peek()) {
            Index elem = queue.remove();
            
            for (int i=0; i < 4; i++) {
                int[] dir = directions[i];
                int newX = elem.x + dir[0];
                int newY = elem.y + dir[1];
                if (newX >=0 && newX <n && newY >=0 && newY <m) {
                    if (res[newX][newY] > res[elem.x][elem.y] + 1) {
                        res[newX][newY] = res[elem.x][elem.y] + 1;
                        queue.add(new Index(newX, newY));
                    }
                }
            }
        }
         
        return res;
    }
}
