class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int cnt=0;
        
        Arrays.fill(indegree, 0);
        
        for (int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][1];
            int dest = prerequisites[i][0];
            indegree[dest]++;
            List<Integer> list = edges.get(source);
            if (list == null) {
                list = new LinkedList<Integer>();
                edges.put(source, list);
            }
            list.add(dest);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            int i = q.poll();
            if (indegree[i] == 0) {
                res[cnt++] = i;
                List<Integer> destList = edges.get(i);
                if (destList != null) {
                    for (int dest: destList) {
                        indegree[dest]--;
                        if (indegree[dest] == 0) {
                            q.offer(dest);
                        }
                    }
                }
            }
        }
        if (cnt< numCourses) {
            res = new int[0];
        }
        return res;
    }
}
