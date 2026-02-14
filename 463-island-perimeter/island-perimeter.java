class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] visited=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
        int perimeter=0;
        int[] rowDirection={1,-1,0,0};
        int[] colDirection={0,0,1,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j));
                    visited[i][j]=true;
                    break;
                }
            }
            if(!q.isEmpty()) break;
        }
        while(!q.isEmpty()){
            Pair curr=q.poll();
            for(int i=0;i<4;i++){
                int newRow=curr.row+rowDirection[i];
                int newCol=curr.col+colDirection[i];
                if(newRow<0 ||newRow>=n || newCol<0 || newCol>=m){
                    perimeter++;
                }
                else if(grid[newRow][newCol] == 0) {
                    perimeter++;
                }else if(!visited[newRow][newCol]){
                    visited[newRow][newCol]=true;
                    q.add(new Pair(newRow,newCol));
                }
            }
        }
        return perimeter;
    }
}