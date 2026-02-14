class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
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
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    distance[newRow][newCol] = 
                    distance[curr.row][curr.col] + 1;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
        return distance;
    }
}
