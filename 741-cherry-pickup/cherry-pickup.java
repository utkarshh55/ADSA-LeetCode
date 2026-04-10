class Solution {
    int n;
    Integer[][][][] dp;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        dp = new Integer[n][n][n][n];
        return Math.max(0, solve(0, 0, 0, 0, grid));
    }
    public int solve(int r1, int c1, int r2, int c2, int[][] grid) {
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n)
            return Integer.MIN_VALUE;
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];
        if (dp[r1][c1][r2][c2] != null)
            return dp[r1][c1][r2][c2];
        int cherries = grid[r1][c1];
        if (r1 != r2 || c1 != c2)
            cherries += grid[r2][c2];
        int a = solve(r1 + 1, c1, r2 + 1, c2, grid);
        int b = solve(r1, c1 + 1, r2, c2 + 1, grid);
        int c = solve(r1 + 1, c1, r2, c2 + 1, grid);
        int d = solve(r1, c1 + 1, r2 + 1, c2, grid);
        int best = Math.max(Math.max(a, b), Math.max(c, d));
        cherries += best;
        return dp[r1][c1][r2][c2] = cherries;
    }
}