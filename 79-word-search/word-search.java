class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] visited=new boolean[n][m];
        boolean result=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    result=backtrack(board,word,visited,i,j,0);
                    if(result) return true;
                }
            }
        }
        return  false;
    }
    public boolean backtrack(char[][] board,String word,boolean[][] visited,int i,int j,int idx){
        if(idx==word.length()) return true;
        if(i<0 ||i>=board.length || j<0 || j>=board[0].length ||visited[i][j] || board[i][j]!=word.charAt(idx)){
            return false;
        }
        visited[i][j]=true;
        if (backtrack(board, word, visited, i + 1, j, idx + 1) ||
            backtrack(board, word, visited, i - 1, j, idx + 1) ||
            backtrack(board, word, visited, i, j + 1, idx + 1) ||
            backtrack(board, word, visited, i, j - 1, idx + 1)) {
            return true;
        }
        visited[i][j]=false;
        return false;
    }
}