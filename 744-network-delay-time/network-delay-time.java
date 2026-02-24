class Solution {
    class Pair {
        int node;
        int dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] arr : times) {
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            adj.get(u).add(new Pair(v, wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int currDist = curr.dist;
            if(currDist > dist[node]) continue;
            for(Pair nei : adj.get(node)) {
                int nextNode = nei.node;
                int weight = nei.dist;
                if(dist[nextNode] > dist[node] + weight) {
                    dist[nextNode] = dist[node] + weight;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}