class Solution {
    class Pair {
        int cost, node, stops;
        Pair(int cost, int node, int stops) {
            this.cost = cost;
            this.node = node;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int[] f : flights)
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        int[][] dist = new int[n][k + 2];
        for(int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(0, src, 0));
        dist[src][0] = 0;
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int cost = curr.cost;
            int node = curr.node;
            int stops = curr.stops;
            if(node == dst)
                return cost;
            if(stops == k + 1)
                continue;
            for(int[] neighbour : adj.get(node)) {
                int nextNode = neighbour[0];
                int price = neighbour[1];
                int newCost = cost + price;
                if(newCost < dist[nextNode][stops + 1]) {
                    dist[nextNode][stops + 1] = newCost;
                    pq.add(new Pair(newCost, nextNode, stops + 1));
                }
            }
        }
        return -1;
    }
}