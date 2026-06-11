//Copy paste
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(new int[]{1, 0}); // node, depth
        visited[1] = true;

        int maxDepth = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int depth = curr[1];

            maxDepth = Math.max(maxDepth, depth);

            for (int nei : graph[node]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(new int[]{nei, depth + 1});
                }
            }
        }

        return (int) modPow(2, maxDepth - 1);
    }

    private long modPow(long base, long exp) {
        long res = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}