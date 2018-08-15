class Solution {
    static boolean[][] used;
    public boolean exist(char[][] board, String word) {
        
        used = new boolean[board.length][board[0].length];
        
        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (c == board[i][j] && DFS(board, word, 0, i, j)) {
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean DFS(char[][] board, String word, int startIndex, int x, int y) {
        if (startIndex == word.length()) {
            return true;
        }
        char c = word.charAt(startIndex);
        if (x <0 || x >= board.length || y<0 || y >=board[x].length || used[x][y] || c!=board[x][y]) {
            return false;
        }
        
        used[x][y] = true;
         if(DFS(board, word,startIndex+1, x-1, y ) || 
           DFS(board, word, startIndex+1,x+1, y) ||
           DFS(board, word, startIndex+1,x, y-1) || 
           DFS(board, word, startIndex+1,x, y+1)){
            return true;
        }
        used[x][y] = false;
        return false;
    }
}
