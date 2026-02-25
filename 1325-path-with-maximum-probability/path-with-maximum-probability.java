class Solution {
    class Pair {
        int node;
        double prob;
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }
        double[] prob = new double[n];
        prob[start] = 1.0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start, 1.0));
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            double currProb = curr.prob;
            if(node == end) return currProb;
            for(Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                double newProb = currProb * neighbor.prob;
                if(newProb > prob[nextNode]) {
                    prob[nextNode] = newProb;
                    pq.add(new Pair(nextNode, newProb));
                }
            }
        }
        return 0.0;
    }
}