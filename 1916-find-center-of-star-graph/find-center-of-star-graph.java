class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length+1;
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        for(int i=0;i<=n;i++){
            if(adjList.get(i).size()==edges.length){
                return i;
            }
        }
        return -1;
    }
}