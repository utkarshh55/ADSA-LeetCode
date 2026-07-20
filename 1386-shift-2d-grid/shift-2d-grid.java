class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;

        k = k % total;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int newIndex = i * m + j;
                int oldIndex = (newIndex - k + total) % total;

                int oldRow = oldIndex / m;
                int oldCol = oldIndex % m;

                row.add(grid[oldRow][oldCol]);
            }

            ans.add(row);
        }

        return ans;
    }
}