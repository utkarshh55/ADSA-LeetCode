class Solution {
    
    class Pair {
        int pr, pc;
        int cr, cc;
        
        Pair(int pr, int pc, int cr, int cc) {
            this.pr = pr;
            this.pc = pc;
            this.cr = cr;
            this.cc = cc;
        }
    }
    
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j, grid, visited, m, n))
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean bfs(int i, int j, char[][] grid, boolean[][] visited, int m, int n) {
        
        int[] rowDir = {1, -1, 0, 0};
        int[] colDir = {0, 0, 1, -1};
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(-1, -1, i, j));
        visited[i][j] = true;
        
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            
            int pr = temp.pr;
            int pc = temp.pc;
            int cr = temp.cr;
            int cc = temp.cc;
            
            for (int k = 0; k < 4; k++) {
                int nr = cr + rowDir[k];
                int nc = cc + colDir[k];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                    && grid[nr][nc] == grid[cr][cc]) {
                    
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new Pair(cr, cc, nr, nc));
                    }
                    else if (nr != pr || nc != pc) {
                        return true; 
                    }
                }
            }
        }
        
        return false;
    }
}