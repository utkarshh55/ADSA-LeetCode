class Solution {
    class Pair {
        int effort, row, col;
        Pair(int effort, int row, int col) {
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.add(new Pair(0, 0, 0));
        dist[0][0] = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int effort = curr.effort;
            int r = curr.row;
            int c = curr.col;
            if(r == n-1 && c == m-1)
                return effort;
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int newEffort = Math.max(effort,Math.abs(heights[r][c] - heights[nr][nc]));
                    if(newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new Pair(newEffort, nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}