class Solution {
    static class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new Pair(i, j));
                    dist[i][j] = 0;
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = curr.row + dr[k];
                int nc = curr.col + dc[k];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[curr.row][curr.col] + 1;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
        int low = 0;
        int high = n * 2;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canReach(dist, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
    private boolean canReach(int[][] dist, int safe) {
        int n = dist.length;
        if (dist[0][0] < safe) return false;
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        visited[0][0] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (curr.row == n - 1 && curr.col == n - 1) {
                return true;
            }
            for (int k = 0; k < 4; k++) {
                int nr = curr.row + dr[k];
                int nc = curr.col + dc[k];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc] && dist[nr][nc] >= safe) {
                    visited[nr][nc] = true;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
        return false;
    }
}