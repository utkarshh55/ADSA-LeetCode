class Solution {
    int[] delRow = {1, 0, -1, 0};
    int[] delCol = {0, 1, 0, -1};
    public boolean isValid(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        int fresh = 0;
        int rotted = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            boolean spread = false;
            for (int k = 0; k < size; k++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];
                for (int i = 0; i < 4; i++) {
                    int newRow = row + delRow[i];
                    int newCol = col + delCol[i];
                    if (isValid(newRow, newCol, m, n) && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        q.add(new int[]{newRow, newCol});
                        rotted++;
                        spread = true;
                    }
                }
            }
            if (spread) time++;
        }
        return (rotted == fresh) ? time : -1;
    }
}