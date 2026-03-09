class Solution {
     boolean union(int u, int v, int[] parent){
        int pu = find(u, parent);
        int pv = find(v, parent);
        if(pu == pv) return false;   
        parent[pu] = pv;           
        return true;
    }
    int find(int x, int[] parent){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int[] e : edges){
            if(!union(e[0], e[1], parent)){
                return e;   
            }
        }
        return new int[0];
    }
}