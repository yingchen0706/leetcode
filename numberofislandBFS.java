class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        if (m ==0) {
            return 0;
        }
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] =='1') {
                    BFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    class Index {
        public int i;
        public int j;
        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    private void BFS(char[][] grid, int i, int j) {
        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(i, j));
        
        while (!queue.isEmpty()) {
            Index head = queue.poll();
            grid[head.i][head.j] = '0';
            if (head.i > 0 && grid[head.i - 1][head.j] == '1') {
                queue.offer(new Index(head.i-1, head.j));
            }
            if (head.j > 0 && grid[head.i][head.j-1] == '1') {
                queue.offer(new Index(head.i, head.j-1));
            } 
            if (head.i < grid.length-1 && grid[head.i + 1][head.j] == '1') {
                queue.offer(new Index(head.i+1, head.j));
            } 
            if (head.j < grid[0].length-1 && grid[head.i][head.j+1] == '1') {
                queue.offer(new Index(head.i, head.j+1));
            }
        }
        
        return ;
    }
}
// memory exceed
