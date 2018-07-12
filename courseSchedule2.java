class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int N = prerequisites.length;
        
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int pre = prerequisites[i][1];
            int after = prerequisites[i][0];

            List<Integer> list = map.get(pre);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(pre, list);
            }
            list.add(after);
        }
        
        Iterator<Map.Entry<Integer, List<Integer>>> it = map.entrySet().iterator();
        boolean[] visited = new boolean[numCourses];
        Arrays.fill(visited, false);
        
        while (it.hasNext()) {
            Map.Entry<Integer, List<Integer>> entry = it.next();
            if (!noCircle(map, visited, entry.getKey())) {
                return false;
            }
        }
        return true;
    }
    
    private boolean noCircle(Map<Integer, List<Integer>> map, boolean[] visited, int node) {
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        List<Integer> list = map.get(node);
        if (list != null) {
            for (int i: list) {
                if(!noCircle(map, visited, i)) {
                    return false;
                }
            }
        }
        visited[node] = false;
        return true;
    }
}
