class Solution {
    class Location {
        int x;
        int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0|| word==null) {
            return true;
        }
        if (board.length == 0 ) {
            return true;
        }
        
        boolean[][] used = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            used[i] = new boolean[board[i].length];
            for (int j = 0; j < board[i].length; j++) {
                used[i][j] = false;
            }
        }
        LinkedList<Location> saved = new LinkedList<>();
        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (c == board[i][j]) {
                    used[i][j] = true;
                    saved.push(new Location(i,j));
                    if (DFS(board, used, word, 1, saved)) {
                        return true;
                    } else {
                        used[i][j] = false;
                        saved.pop();
                    }
                }
            }
        }
        return false;
    }
    
    private boolean DFS(char[][] board, boolean[][] used, String word, int startIndex, LinkedList<Location> saved) {
        if (startIndex >= word.length()) {
            return true;
        }
        Location loc = saved.peek();
        int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
        for (int i = 0; i < 4; i++) {
            int x = move[i][0] + loc.x;
            int y = move[i][1] + loc.y;
            
            if (x >=0 && x < board.length && y >=0 && y <board[x].length) {
                char c = word.charAt(startIndex);
                if (c == board[x][y] && used[x][y] == false) {
                    used[x][y] = true;
                    saved.push(new Location(x,y));
                    if (DFS(board, used, word, startIndex+1, saved)) {
                        return true;
                    } else {
                        saved.pop();
                        used[x][y] = false;
                    }
                }
            }
        }
        return false;
    }
}
