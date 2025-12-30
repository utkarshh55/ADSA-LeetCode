class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<=m-3;i++){
            for(int j=0;j<=n-3;j++){
                if(isMagic(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isMagic(int[][]g,int r,int c){
        if(g[r+1][c+1]!=5) return false;
        boolean[] seen=new boolean[10];
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                int val=g[i][j];
                if(val<1 || val>9 || seen[val]) return false;
                seen[val]=true;
            }
        }
        int sum=g[r][c]+g[r][c+1]+g[r][c+2];
        // Condn. for Rows
        for(int i=0;i<3;i++){
            if(g[r+i][c]+g[r+i][c+1]+g[r+i][c+2]!=sum){
                return false;
            }
        }
        // Condn. for Column.
         for(int j=0;j<3;j++){
            if(g[r][c+j]+g[r+1][c+j]+g[r+2][c+j]!=sum){
                return false;
            }
         }
        // Condn. for Diagonals
        if(g[r][c]+g[r+1][c+1]+g[r+2][c+2]!=sum){
                return false;
        }
        if(g[r][c+2]+g[r+1][c+1]+g[r+2][c]!=sum){
                return false;
        }
        return  true;
    }
}