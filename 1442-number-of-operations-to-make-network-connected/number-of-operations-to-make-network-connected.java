class Solution {
    int[] parent;
    int[] rank;
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public void union(int a,int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return;
        if(rank[pa] < rank[pb]) {
            parent[pa] = pb;
        }
        else if(rank[pb] < rank[pa]) {
            parent[pb] = pa;
        }
        else{
            parent[pb] = pa;
            rank[pa]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
        for(int[] c : connections){
            union(c[0],c[1]);
        }
        int comp = 0;
        for(int i=0;i<n;i++){
            if(parent[i] == i) comp++;
        }
        return comp-1;
    }
}