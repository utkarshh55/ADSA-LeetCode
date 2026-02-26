class Solution {
    class Pair {
        int cost, city, time;
        Pair(int cost, int city, int time) {
            this.cost = cost;
            this.city = city;
            this.time = time;
        }
    }
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }
        int[][] dist = new int[n][maxTime + 1];
        for(int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Pair(passingFees[0], 0, 0));
        dist[0][0] = passingFees[0];
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int cost = curr.cost;
            int city = curr.city;
            int time = curr.time;
            if(city == n - 1)
                return cost;
            for(int[] nei : adj.get(city)) {
                int nextCity = nei[0];
                int travelTime = nei[1];
                int newTime = time + travelTime;
                if(newTime > maxTime)
                    continue;
                int newCost = cost + passingFees[nextCity];
                if(newCost < dist[nextCity][newTime]) {
                    dist[nextCity][newTime] = newCost;
                    pq.add(new Pair(newCost, nextCity, newTime));
                }
            }
        }
        return -1;
    }
}