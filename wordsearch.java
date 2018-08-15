class Solution {
    
    public boolean exist(char[][] board, String word) {
        
        
        boolean[][] used = new boolean[board.length][board[0].length];
       
        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (c == board[i][j]) {
                    used[i][j] = true;
                    if (DFS(board, used, word, 1, i, j)) {
                        return true;
                    } else {
                        used[i][j] = false;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean DFS(char[][] board, boolean[][] used, String word, int startIndex, int x1, int y1) {
        if (startIndex >= word.length()) {
            return true;
        }
        int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
        char c = word.charAt(startIndex);
        for (int i = 0; i < 4; i++) {
            int x = move[i][0] + x1;
            int y = move[i][1] + y1;
            
            if (x >=0 && x < board.length && y >=0 && y <board[x].length) {
                if (c == board[x][y] && used[x][y] == false) {
                    used[x][y] = true;
  
                    if (DFS(board, used, word, startIndex+1, x, y)) {
                        return true;
                    } else {
                        used[x][y] = false;
                    }
                }
            }
        }
        return false;
    }
}
