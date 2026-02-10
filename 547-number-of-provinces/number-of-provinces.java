class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }
    private void bfs(int[][] graph, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for(int j=0;j<graph.length;j++){
                if(graph[curr][j]==1 && !visited[j]){
                    visited[j]=true;
                    q.add(j);
                }
            }
        }
    }
}
