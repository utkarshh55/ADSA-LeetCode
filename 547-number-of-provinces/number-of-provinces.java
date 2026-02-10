class Solution {
    public void bfs(int start,boolean visited[],ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q=new LinkedList<>();
            q.add(start);
            visited[start]=true;
            while(!q.isEmpty()){
                int curr=q.poll();
                for(int i=0;i<adj.get(curr).size();i++){
                    int neigh=adj.get(curr).get(i);
                    if(visited[neigh]==false){
                        visited[neigh]=true;
                        q.add(neigh);
                    }
                }
            }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=isConnected.length;
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (isConnected[i][j] == 1 && i != j) {
                int from=i;
                int to=j;
                adj.get(from).add(to);
                }
            }
        }
        int count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                count++;
                bfs(i,visited,adj);
            }
        }
        return count;
    }
}