class Solution {
    public boolean validPath(int n, int[][] edges, int src, int destination) {
        if(src==destination) return true;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean [] visited=new boolean[n];
        q.add(src);
        visited[src]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<adj.get(curr).size();i++){
                int neigh=adj.get(curr).get(i);
                if(neigh==destination) return true;
                if(!visited[neigh]){
                    visited[neigh]=true;
                    q.add(neigh);
                }
            }
        }
        return false;
    }
}