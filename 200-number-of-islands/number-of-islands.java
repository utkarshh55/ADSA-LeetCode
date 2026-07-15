class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int[] dr={0,0,1,-1};
    int[] dc={1,-1,0,0};
    public boolean isValid(int r,int c,int n,int m){
        if(r>=0 && r<n && c>=0 && c<m) {
            return true;
        }
        return false;
    }
    public void bfs(char[][] grid,boolean[][] isVisited,int currRow,int currCol,int totalRow,int totalCol){
        Queue<Pair> q=new LinkedList<>();
        Pair p=new Pair(currRow,currCol);
        q.add(p);
        isVisited[currRow][currCol]=true;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int currPairRow=curr.row;
            int currPairCol=curr.col;
            for(int i=0;i<4;i++){
                 int newRow=currPairRow+dr[i];
                int newCol=currPairCol+dc[i];
                if(isValid(newRow,newCol,totalRow,totalCol)&& grid[newRow][newCol]=='1' && isVisited[newRow][newCol]==false){
                    isVisited[newRow][newCol]=true;
                    Pair temp=new Pair(newRow,newCol);
                    q.add(temp);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] isVisited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !isVisited[i][j]){
                    count++;
                    bfs(grid,isVisited,i,j,n,m);
                }
            }
        }
        return count;
    }
}