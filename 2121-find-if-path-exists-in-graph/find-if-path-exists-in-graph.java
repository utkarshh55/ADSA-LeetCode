class Solution {
    public boolean dfs(int node, int destination,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        if(node==destination) return true;
        visited[node]=true;
        for(int i=0;i<adj.get(node).size();i++){
            int neigh=adj.get(node).get(i);
            if(!visited[neigh]){
                if(dfs(neigh,destination,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        boolean[] visited=new boolean[n];
        return dfs(source,destination,adj,visited);

    }
}