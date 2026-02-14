class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] height = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                height[i][j] = -1;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isWater[i][j] == 1) {
                    q.add(new Pair(i, j));
                    height[i][j] = 0;  
                }
            }
        }
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            for(int d = 0; d < 4; d++) {
                int newRow = curr.row + rowDir[d];
                int newCol = curr.col + colDir[d];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && height[newRow][newCol] == -1) {
                    height[newRow][newCol] = height[curr.row][curr.col] + 1;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
        return height;
    }
}
