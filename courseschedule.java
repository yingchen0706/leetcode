class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int N = prerequisites.length;
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            indegree[i]=0;
        }
        
        //int[][] matrix = new int[numCourses][numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int pre = prerequisites[i][1];
            int after = prerequisites[i][0];
            /*if (matrix[pre][after] == 0) {
                indegree[after]++;
            }
            matrix[pre][after] = 1;*/
            List<Integer> list = map.get(pre);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(pre, list);
            }
            list.add(after);
            indegree[after]++;
            // need to check duplicate
        }
        int count = 0;
        Queue<Integer> noInQ = new LinkedList<>();
        for (int i=0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                noInQ.offer(i);
                count++;
            }
        }
        
        while (!noInQ.isEmpty()) {
            int node = noInQ.poll();
            //for (int i = 0; i < numCourses; i++) {
                //if (matrix[node][i] == 1) {
            List<Integer> list = map.get(node);
            if (list == null) {
                continue;
            }
            for (int i: list) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    noInQ.offer(i);
                    count++;
                }
            }
            //}
        }
        
        return count==numCourses;
    }
}
