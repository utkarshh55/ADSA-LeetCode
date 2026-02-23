class Solution {
    class Pair {
        int row;
        int col;
        int dist;
        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    int[] rowDirection = {-1,-1,-1,0,0,1,1,1};
    int[] colDirection = {-1,0,1,-1,1,-1,0,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));   
        grid[0][0] = 1;             
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            int currDist = curr.dist;
            if(currRow == n-1 && currCol == m-1)
                return currDist;
            for(int i = 0; i < 8; i++) {
                int newRow = currRow + rowDirection[i];
                int newCol = currCol + colDirection[i];
                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m &&
                   grid[newRow][newCol] == 0) {
                    q.add(new Pair(newRow, newCol, currDist + 1));
                    grid[newRow][newCol] = 1;  
                }
            }
        }
        return -1;
    }
}