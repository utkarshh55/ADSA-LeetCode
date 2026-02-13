class Solution {
    private int[] delRow={-1,0,1,0};
    private int[] delCol={0,1,0,-1};
    public boolean isValid(int i,int j,int m,int n){
        if((i>=0 && i<m) &&(j>=0 && j<n)){
            return true;
        }
        return false;
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]vis=new int[m][n];
        int time=0;
        int totalOranges=0;
        int cnt=0;
        Queue<int[]>q= new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cell=grid[i][j];
                if(cell==2){
                    q.offer(new int[]{i,j});     
                }
                if(cell!=0) totalOranges++;
            }
        }
        while(!q.isEmpty()){
            int k=q.size();
            cnt+=k;
            while(k-->0){
                int []cell=q.poll();
                int row=cell[0];
                int col=cell[1];
                for(int i=0;i<4;i++){
                    int nRow=row+delRow[i];
                    int nCol=col+delCol[i];
                    if(isValid(nRow,nCol,m,n) && grid[nRow][nCol]==1){
                        grid[nRow][nCol]=2;
                        q.offer(new int[]{nRow,nCol});
                    }

                }
            }
            if(!q.isEmpty()) time++;
        }


        if(totalOranges==cnt) return time;
        return -1;
        
    }
}