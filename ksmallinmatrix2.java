class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> priQ = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            priQ.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k-1; i++) {
            Tuple head = priQ.poll();
            if (head.x == n -1) {
                continue;
            } else {
                priQ.offer(new Tuple(head.x+1, head.y, matrix[head.x+1][head.y]));
            }
        }
        return priQ.poll().val;
    }
    
    class Tuple implements Comparable<Tuple> {
        private int x;
        private int y;
        private int val;
        
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Tuple elem) {
            return this.val - elem.val;
        } 
    }
}class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> priQ = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            priQ.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k-1; i++) {
            Tuple head = priQ.poll();
            if (head.x == n -1) {
                continue;
            } else {
                priQ.offer(new Tuple(head.x+1, head.y, matrix[head.x+1][head.y]));
            }
        }
        return priQ.poll().val;
    }
    
    class Tuple implements Comparable<Tuple> {
        private int x;
        private int y;
        private int val;
        
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Tuple elem) {
            return this.val - elem.val;
        } 
    }
}
