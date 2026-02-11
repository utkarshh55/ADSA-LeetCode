class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    int[] rowDir = {1, -1, 0, 0};
    int[] colDir = {0, 0, 1, -1};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                q.add(new Pair(i, 0));
                board[i][0] = 'A';
            }
            if(board[i][n - 1] == 'O') {
                q.add(new Pair(i, n - 1));
                board[i][n - 1] = 'A';
            }
        }
        
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {
                q.add(new Pair(0, j));
                board[0][j] = 'A';
            }
            if(board[m - 1][j] == 'O') {
                q.add(new Pair(m - 1, j));
                board[m - 1][j] = 'A';
            }
        }
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            for(int i = 0; i < 4; i++) {
                int newRow = curr.row + rowDir[i];
                int newCol = curr.col + colDir[i];
                if(newRow >= 0 && newCol >= 0 && 
                   newRow < m && newCol < n &&
                   board[newRow][newCol] == 'O') {
                    
                    board[newRow][newCol] = 'A';
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
