class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        if(q.isEmpty() || q.size() == n * n) {
            return -1;
        }
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};
        int distance = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            distance++;
            
            for(int i = 0; i < size; i++) {
                Pair curr = q.poll();
                
                for(int d = 0; d < 4; d++) {
                    int newRow = curr.row + rowDir[d];
                    int newCol = curr.col + colDir[d];
                    
                    if(newRow >= 0 && newRow < n &&
                       newCol >= 0 && newCol < n &&
                       !visited[newRow][newCol]) {
                        
                        visited[newRow][newCol] = true;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
        return distance;
    }
}
